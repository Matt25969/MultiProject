package com.qa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.business.PrizeService;

@RestController
public class PrizeController {

	@Autowired
	public PrizeService service;

	@RequestMapping("/getPrize/{accountNumber}")
	public String getNumber(@PathVariable String accountNumber) {

		return service.getPrize(accountNumber);
	}

}
