package com.test.rest.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.rest.builder.NumberOutputBuilder;
import com.test.rest.builder.ResultBuilder;
import com.test.rest.dto.NumberInputDTO;
import com.test.rest.dto.Result;
import com.test.rest.dto.ResultType;
import com.test.rest.model.GCDNumber;
import com.test.rest.service.GCDNumberService;

/**
 * The Class GCDNumberController. Expose number related API methods
 */
@RestController
@RequestMapping("/api/numbers")
public class GCDNumberController {

	/** The number service. */
	@Autowired
	private GCDNumberService numberService;

	/** The jms template. */
	@Autowired
	private JmsTemplate jmsTemplate;

	/** The destination. */
	@Value("${outbound.endpoint}")
	private String destination;

	/**
	 * Push numbers.
	 *
	 * @param numberInput
	 *            the number input
	 * @return the result
	 */
	// @Transactional
	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result push(@Validated @RequestBody NumberInputDTO numberInput) {
		// Saves the numbers before sending them to the queue
		GCDNumber gcdNumber = new GCDNumber(numberInput.getNumberOne(), numberInput.getNumberTwo());
		numberService.save(gcdNumber);
		// Sends the numbers to the queue
		jmsTemplate.convertAndSend(destination, gcdNumber);
		return new Result(ResultType.SUCCESS, "Numbers are successfully added to the queue");
	}

	/**
	 * List all numbers.
	 *
	 * @return the result
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result list() {
		return ResultBuilder
				.buildSuccessResult("All the numbers ever added to queue",
						numberService
								.findAll().stream().map(gcdNumber -> new NumberOutputBuilder()
										.setOrder(gcdNumber.getId()).setValue(gcdNumber).build())
								.collect(Collectors.toList()));
	}

}
