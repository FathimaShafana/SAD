package com.example.demo.Strategy;

import com.example.demo.models.Contract;

public class CompleteRecognition implements RecognitionStrategy {

	@Override
	public void calculateRevenueRecognitions(Contract contract) {
		// TODO Auto-generated method stub
		contract.addRevenueRecognition(contract.getRevenue(), contract.getDateSigned());
	}

	
}
