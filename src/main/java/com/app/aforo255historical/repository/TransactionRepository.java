package com.app.aforo255historical.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.app.aforo255historical.model.entity.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, Integer> {
	
	@Query("{'accountId':?0}")
	public Iterable<Transaction> findByAccountId(Integer account_id);

}
