package com.app.aforo255historical.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.app.aforo255historical.model.entity.PaymentTransaction;

public interface PaymentTransactionRepository extends MongoRepository<PaymentTransaction, Integer> {
	
	@Query("{'prestamoid':?0}")
	public Iterable<PaymentTransaction> findByPrestamoId(Integer id);

}
