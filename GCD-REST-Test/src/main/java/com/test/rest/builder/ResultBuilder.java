package com.test.rest.builder;

import java.util.List;

import org.springframework.validation.FieldError;

import com.test.rest.dto.ErrorResult;
import com.test.rest.dto.ResultType;
import com.test.rest.dto.SuccessResult;

/**
 * The Class ResultBuilder. Builds Result Objects. Act as API output type
 */
public class ResultBuilder {
	
	/**
	 * Builds the error result.
	 *
	 * @param msg the msg
	 * @param fieldErrors the field errors
	 * @return the error result
	 */
	public static ErrorResult buildErrorResult(String msg, List<FieldError> fieldErrors) {
		ErrorResult errorResult = new ErrorResult();
		errorResult.setFieldErrors(fieldErrors);
		errorResult.setMsg(msg);
		errorResult.setType(ResultType.ERROR);

		return errorResult;
	}

	/**
	 * Builds the success result.
	 *
	 * @param msg the msg
	 * @param data the data
	 * @return the success result
	 */
	public static SuccessResult buildSuccessResult(String msg, Object data) {
		SuccessResult successResult = new SuccessResult();
		successResult.setMsg(msg);
		successResult.setType(ResultType.SUCCESS);
		successResult.setData(data);

		return successResult;
	}
}
