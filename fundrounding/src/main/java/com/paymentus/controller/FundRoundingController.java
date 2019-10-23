package com.paymentus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paymentus.model.FundInputs;
import com.paymentus.model.RoundedFunds;
import com.paymentus.service.FundRoundingService;

@RestController
@RequestMapping("/fundrounding")
public class FundRoundingController {
	
	@Autowired
	public FundRoundingService service;
	
	@PostMapping(path= "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> roundFunds(@RequestBody FundInputs input ) {
		RoundedFunds response = service.roundFunds(input);
		return ResponseEntity.status(HttpStatus.OK)
		        .body(response);
		
	}
	

}
