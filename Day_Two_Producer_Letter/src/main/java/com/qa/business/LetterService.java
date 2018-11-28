package com.qa.business;

import org.springframework.stereotype.Service;

@Service
public class LetterService implements ILetterService {

	@Override
	public String getLetter() {
		
		int temp = (int)(Math.random()*3);
		
		switch (temp) {
		case 0:
			return "A";
		case 1:
			return "B";
		case 2:
			return "C";
		}
		
		return "";
	}



}
