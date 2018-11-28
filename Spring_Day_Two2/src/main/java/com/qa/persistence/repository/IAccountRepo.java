package com.qa.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.Account;

@Repository
public interface IAccountRepo extends JpaRepository<Account, Integer>{
	
//	void getAllAccounts();

}
