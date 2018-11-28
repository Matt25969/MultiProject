package com.qa.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.business.AccountService;
import com.qa.persistence.domain.Account;

@RestController
public class AccountController {

	@Autowired
	public AccountService service;

	@RequestMapping("/getAccount")
	public List<Account> getAllAccounts() {

		return service.getAllAccounts();
	}

	@RequestMapping("/getAccount/{id}")
	public Account getAnAccount(@PathVariable Integer id) {

		return service.getAnAccount(id);

	}

	@RequestMapping("/addAccount")

	public Account addAccount(@RequestBody Account account) {
		return service.addAccount(account);
	}

	@RequestMapping("/deleteAccount/{id}")
	public void deleteAccount(@PathVariable Integer id) {
		service.deleteAccount(id);
	}

	@RequestMapping("/addAccountGen")

	public Account addAccountGen() {
		return service.addAccountGen();
	}
	
	@RequestMapping("/getPrize/{accountNumber}")
	
	public String getPrizeGen(@PathVariable String accountNumber) {
		return service.getPrizeGen(accountNumber);
	}

}
