package com.paymentus.service;

import com.paymentus.model.FundInputs;
import com.paymentus.model.RoundedFunds;

public interface FundRoundingService {
	
	public RoundedFunds roundFunds(FundInputs input);

}
