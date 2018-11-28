package com.qa.business;

import java.util.List;

import com.qa.persistence.domain.Account;

public interface IAccountService {

	List<Account> getAllAccounts();

	Account addAccount(Account account);

	Account getAnAccount(Integer id);

	void deleteAccount(Integer id);

}
