package com.test.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.rest.model.GCDNumber;
import com.test.rest.repository.NumbersRepository;
import com.test.rest.service.GCDNumberService;

/**
 * The Class NumberServiceImpl.
 */
@Service
public class GCDNumberServiceImpl implements GCDNumberService {

	/** The numbers repository. */
	@Autowired
	private NumbersRepository numbersRepository;

	/* (non-Javadoc)
	 * @see com.unico.services.NumberService#save(com.unico.domain.Number)
	 */
	@Override
	public GCDNumber save(GCDNumber gcdNumber) {
		return numbersRepository.save(gcdNumber);
	}

	/* (non-Javadoc)
	 * @see com.unico.services.NumberService#findAll()
	 */
	@Override
	public List<GCDNumber> findAll() {
		return numbersRepository.findAll();
	}

}
