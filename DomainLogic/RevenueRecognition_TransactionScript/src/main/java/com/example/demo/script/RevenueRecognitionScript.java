package com.example.demo.script;

import java.time.LocalDate;

import javax.money.MonetaryAmount;

public interface RevenueRecognitionScript {

	MonetaryAmount recognizedRevenue(int contractID, LocalDate asOf);
	void calculateRevenueRecognition(int contractID);
	int insertContractInfo(int productID, MonetaryAmount contractPrice,LocalDate dateSigned);
	int insertProductInfo(String name, String type);
}
