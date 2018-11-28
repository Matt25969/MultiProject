package com.qa.business;

import org.springframework.stereotype.Service;

@Service
public class NumberService implements INumberService {

	@Override
	public Integer getNumber() {
		
		return (int)(Math.random()*1000000);
	}


}
