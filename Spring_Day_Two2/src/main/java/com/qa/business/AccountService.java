package com.qa.business;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.IAccountRepo;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepo accountRepo;

	@Override
	public List<Account> getAllAccounts() {
		return accountRepo.findAll().stream().collect(Collectors.toList());
	}

	@Override
	public Account getAnAccount(Integer id) {
		return accountRepo.getOne(id);
	}

	@Override
	public Account addAccount(Account account) {
		return accountRepo.save(account);
	}

	@Override
	public void deleteAccount(Integer id) {
		accountRepo.deleteById(id);
	}

	public Account addAccountGen() {

		RestTemplate rt = new RestTemplate();
		Account account = new Account();

		String prefix = rt.getForObject("http://192.168.99.100:8080/getLetter", String.class);
		String suffix = rt.getForObject("http://192.168.99.100:8081/getNumber", String.class);

		account.setAccountNumber(prefix + suffix);
		return accountRepo.save(account);
	}

	public String getPrizeGen(String accountNumber) {
		RestTemplate rt = new RestTemplate();
		String result = rt.getForObject("http://192.168.99.100:8082/getPrize/" + accountNumber, String.class);
		return result;
	}

}
