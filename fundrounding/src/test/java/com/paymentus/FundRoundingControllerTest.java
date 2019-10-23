package com.paymentus;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.paymentus.controller.FundRoundingController;
import com.paymentus.model.OperationDetail;
import com.paymentus.model.RoundedFunds;
import com.paymentus.service.FundRoundingService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = FundRoundingController.class)
public class FundRoundingControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private FundRoundingService service;

	String exampleJson = "{\"values\": [1.6,3.2,5.5],\"initialFund\": 5.0}";
	
	RoundedFunds resp = new RoundedFunds( 
			new ArrayList<OperationDetail>(){{ add(new OperationDetail(3.2f, 3, 0.2f));}},
			new ArrayList<OperationDetail>(){{ add(new OperationDetail(1.6f, 2, 0.4f)); add( new OperationDetail(5.5f, 6, 0.5f));}},
			4.3f
	);
	
	@Test
	public void roundFunds() throws Exception {
		Mockito.when(service.roundFunds(Mockito.anyObject())).thenReturn(resp);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/fundrounding/").accept(MediaType.APPLICATION_JSON)
				.content(exampleJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{\"roundedDown\":[{\"value\":3.2,\"afterRounding\":3,\"difference\":0.2}],\"roundedUp\":[{\"value\":1.6,\"afterRounding\":2,\"difference\":0.4},{\"value\":5.5,\"afterRounding\":6,\"difference\":0.5}],\"remainingFund\":4.3}";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

}
