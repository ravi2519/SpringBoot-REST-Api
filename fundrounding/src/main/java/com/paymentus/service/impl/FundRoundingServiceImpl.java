package com.paymentus.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.paymentus.model.FundInputs;
import com.paymentus.model.OperationDetail;
import com.paymentus.model.RoundedFunds;
import com.paymentus.service.FundRoundingService;

@Service
public class FundRoundingServiceImpl implements FundRoundingService {

	@Override
	public RoundedFunds roundFunds(FundInputs input) {

		Float initialFund = input.getInitialFund();
		List<Float> values = input.getValues(); 
		RoundedFunds resp = new RoundedFunds();
		System.out.println(initialFund);
		resp.setRemainingFund(initialFund);
		
		for(Float val:values) {
			doRounding(val, resp);
		}
		
		return resp;
	}

	private void doRounding(Float val, RoundedFunds resp) {
		
		int nearestInt = (int)(val + 0.5);
		Float roundedVal = val - nearestInt;
		
		OperationDetail det = new OperationDetail();
		det.setValue(Float.valueOf(String.format("%.1f", val)));
		det.setAfterRounding(nearestInt);
		det.setDifference(Float.valueOf(String.format("%.1f", Math.abs(roundedVal))));
		
		if ( roundedVal < 0 ) {
			if(null == resp.getRoundedUp()) {
				List<OperationDetail> dets = new ArrayList<OperationDetail>();
				dets.add(det);
				resp.setRoundedUp(dets);
			} else {
				resp.getRoundedUp().add(det);
			}
		} else {
			if(null == resp.getRoundedDown()) {
				List<OperationDetail> dets = new ArrayList<OperationDetail>();
				dets.add(det);
				resp.setRoundedDown(dets);
			} else {
				resp.getRoundedDown().add(det);
			}
		}
		
		resp.setRemainingFund(Float.valueOf(String.format("%.1f", resp.getRemainingFund() + roundedVal)));
	}

}
