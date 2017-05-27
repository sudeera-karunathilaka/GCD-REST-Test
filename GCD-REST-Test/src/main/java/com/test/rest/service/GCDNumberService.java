package com.test.rest.service;

import java.util.List;

import com.test.rest.model.GCDNumber;

/**
 * The Interface NumberService.All number related operations expose as services
 * are defined here
 */
public interface GCDNumberService {

	public GCDNumber save(GCDNumber gcdNumber);

	public List<GCDNumber> findAll();

}
