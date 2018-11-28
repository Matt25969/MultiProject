package com.qa.business;

import org.springframework.stereotype.Service;

@Service
public class PrizeService implements IPrizeService {

	@Override
	public String getPrize(String accountNumber) {

		switch (accountNumber.charAt(0)) {
		case 'A':
			return "You Won $50";
		case 'B':
			return "You Won $100";
		case 'C':
			return "lose";

		}
		return "";
	}

}
