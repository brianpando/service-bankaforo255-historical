package com.app.aforo255historical.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.aforo255historical.model.entity.Transaction;
import com.app.aforo255historical.repository.TransactionRepository;

public class TransactionServiceImp implements ITransactionService {
	
	@Autowired
	TransactionRepository repository;

	@Override
	public Transaction save(Transaction transaction) {
		// TODO Auto-generated method stub
		return repository.save(transaction);
	}

	@Override
	public Iterable<Transaction> findByAccountId(Integer accountId) {
		// TODO Auto-generated method stub
		return repository.findByAccountId(accountId);
	}

	@Override
	public Iterable<Transaction> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
