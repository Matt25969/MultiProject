package com.qa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.business.NumberService;

@RestController
public class NumberController {

	@Autowired
	public NumberService service;

	@RequestMapping("/getNumber")
	public Integer getNumber() {

		return service.getNumber();
	}

}
