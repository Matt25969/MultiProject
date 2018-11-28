package com.qa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.business.LetterService;

@RestController
public class LetterController {

	@Autowired
	public LetterService service;

	@RequestMapping("/getLetter")
	public String getLetter() {

		return service.getLetter();
	}

}
