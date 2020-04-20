package com.app.aforo255historical.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.aforo255historical.model.entity.PaymentTransaction;
import com.app.aforo255historical.model.entity.Transaction;
import com.app.aforo255historical.repository.PaymentTransactionRepository;
import com.app.aforo255historical.repository.TransactionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TransactionEvent {
	
	Logger log = LoggerFactory.getLogger(TransactionEvent.class);
	@Autowired
	private TransactionRepository repository;
	@Autowired
	private PaymentTransactionRepository paymentRepository;
	
	ObjectMapper objectMapper= new ObjectMapper();
	
	public void processTransactionEvent(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
	
		Object transactionEvent;
		if(consumerRecord.value().toString().contains("prestamo")) {
			transactionEvent = objectMapper.readValue(consumerRecord.value(), PaymentTransaction.class);
			paymentRepository.save( (PaymentTransaction) transactionEvent);
		}else {
			transactionEvent = objectMapper.readValue(consumerRecord.value(), Transaction.class) ;
			repository.save( (Transaction) transactionEvent);
		}
		
		
		log.info("Success: {}",transactionEvent);
	}
}
