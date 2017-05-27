package com.test.rest.translator.exception;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.test.rest.builder.ResultBuilder;
import com.test.rest.dto.Result;
import com.test.rest.util.ErrorMessage;

/**
 * The Class ExceptionTranslator. Act as a advisor and translate all exceptions
 * in to readable format
 */
@ControllerAdvice
public class ExceptionTranslator {

	/**
	 * Process validation error.
	 *
	 * @param ex the ex
	 * @return the result
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public Result processValidationError(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();

		return ResultBuilder.buildErrorResult(ErrorMessage.VALIDATION_ERR_MSG, fieldErrors);
	}

	/**
	 * Handle http message not readable.
	 *
	 * @param ex the ex
	 * @return the result
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	protected Result handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {

		String field = "";
		Throwable throwable = ex.getCause();

		if (throwable instanceof JsonMappingException) {
			JsonMappingException jsonMappingException = ((JsonMappingException) throwable);
			List<JsonMappingException.Reference> references = jsonMappingException.getPath();
			for (JsonMappingException.Reference reference : references) {
				if (reference.getFieldName() != null) {
					field += reference.getFieldName() + " ";
				}
			}
			return ResultBuilder.buildErrorResult("'" + field.trim() + "' contains invalid values", null);
		}
		return ResultBuilder.buildErrorResult(ex.getRootCause().getMessage(), null);
	}

	/**
	 * Procecss ilegal argument exception.
	 *
	 * @param ex the ex
	 * @return the result
	 */
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	protected Result procecssIlegalArgumentException(IllegalArgumentException ex) {
		return ResultBuilder.buildErrorResult(ex.getMessage(), null);
	}

	/**
	 * Process constraint violation exception.
	 *
	 * @param ex the ex
	 * @return the result
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	protected Result processConstraintViolationException(ConstraintViolationException ex) {
		Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
		String clientErrorMessage = "";
		for (ConstraintViolation<?> constraintViolation : constraintViolations) {
			clientErrorMessage += constraintViolation.getMessage();
		}
		return ResultBuilder.buildErrorResult(clientErrorMessage, null);
	}

	/**
	 * Process access denied excpetion.
	 *
	 * @param e the e
	 * @return the result
	 */
	@ExceptionHandler(AccessDeniedException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ResponseBody
	public Result processAccessDeniedExcpetion(AccessDeniedException e) {
		return ResultBuilder.buildErrorResult(ErrorMessage.ACCESS_DENIED_ERR_MSG, null);
	}

	/**
	 * Process method not supported exception.
	 *
	 * @param exception the exception
	 * @return the result
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	public Result processMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
		return ResultBuilder.buildErrorResult(ErrorMessage.METHOD_NOT_ALLOWED_ERR_MSG, null);
	}

	/**
	 * Process runtime exception.
	 *
	 * @param ex the ex
	 * @return the response entity
	 * @throws Exception the exception
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Result> processRuntimeException(Exception ex) throws Exception {
		BodyBuilder builder;
		Result errorDTO;
		ResponseStatus responseStatus = AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class);
		if (responseStatus != null) {
			builder = ResponseEntity.status(responseStatus.value());
			errorDTO = ResultBuilder.buildErrorResult(responseStatus.reason(), null);
		} else {
			builder = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
			errorDTO = ResultBuilder.buildErrorResult(ErrorMessage.INTERNAL_SERVER_ERR_MSG, null);
		}
		return builder.body(errorDTO);
	}
}
