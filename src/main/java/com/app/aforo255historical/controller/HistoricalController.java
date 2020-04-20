package com.app.aforo255historical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.aforo255historical.model.entity.Transaction;
import com.app.aforo255historical.service.ITransactionService;

public class HistoricalController {

	@Autowired
	private ITransactionService service;
	@GetMapping("/transaction/{accountId}")
	public ResponseEntity<?> obtenerTransacciones(@PathVariable Integer accountId ){
		Iterable<Transaction> ltransaction = service.findByAccountId(accountId);
		return ResponseEntity.ok(ltransaction);
	}
	
	public List<Transaction> listar(){
		return (List<Transaction>) service.findAll();
	}
}
