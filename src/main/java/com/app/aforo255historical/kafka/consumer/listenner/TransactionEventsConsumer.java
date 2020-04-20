package com.app.aforo255historical.kafka.consumer.listenner;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.app.aforo255historical.model.entity.Transaction;
import com.app.aforo255historical.service.TransactionEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class TransactionEventsConsumer {
private Logger log = LoggerFactory.getLogger( TransactionEventsConsumer.class ) ; 
	
	@Autowired
	private TransactionEvent transactionEvent;
	
	@KafkaListener(topics = {"transaction-events"})
	public void onMessage( ConsumerRecord<Integer, String> consumerRecord ) throws JsonMappingException, JsonProcessingException {
		
		log.info("Consumer Record Account: {}",consumerRecord.value());
		//Transaction transactionEvent = objectMapper.readValue(consumerRecord.value(), Transaction.class);
		transactionEvent.processTransactionEvent(consumerRecord);
	}
}
