//Concrete Class for RevenueRecognitionScript Interface
package com.example.demo.script;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.MonetaryAmountFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Gateways.ContractTableDataGateway;
import com.example.demo.Gateways.ProductTableDataGateway;
import com.example.demo.Gateways.RevenueRecognitionTableDataGateway;
import com.example.demo.Helpers.RevenueRecognitionFactory;

@Service
public class RevenueRecognitionScriptImpl implements RevenueRecognitionScript {
	CurrencyUnit CURRENCY = Monetary.getCurrency("USD");

	
	@Autowired
	RevenueRecognitionFactory rrFactory;
	//Gateways
	@Autowired
	RevenueRecognitionTableDataGateway recognitionGateway;
	@Autowired
	ProductTableDataGateway productGateway;
	@Autowired
	ContractTableDataGateway contractGateway;
	
	MonetaryAmountFactory<?> amountFactory;
	
	//Constructor
	public RevenueRecognitionScriptImpl(
			RevenueRecognitionTableDataGateway recognitionGateway,
			ProductTableDataGateway productGateway,
			ContractTableDataGateway contractGateway) {
		super();
		this.recognitionGateway=recognitionGateway;
		this.productGateway=productGateway;
		this.contractGateway=contractGateway;
		this.amountFactory=Monetary.getDefaultAmountFactory();
	}

	//RecognizedRevenue Method
	@Override
	public MonetaryAmount recognizedRevenue(int contractID, LocalDate asOf) {
		// TODO Auto-generated method stub
		BigDecimal total=BigDecimal.ZERO.setScale(CURRENCY.getDefaultFractionDigits(),RoundingMode.HALF_EVEN);
		try (ResultSet rs=recognitionGateway.findByContract(contractID, asOf)){
			while(rs.next()) {
				total=total.add(rs.getBigDecimal("amount"));
			}
			return amountFactory.setNumber(total).setCurrency(CURRENCY).create();
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void calculateRevenueRecognition(int contractID) {
		// TODO Auto-generated method stub
		try (ResultSet contracts = contractGateway.findOne(contractID)) {
			if (!contracts.next()) {
				throw new RuntimeException(String.format("Contract with id = [%d] not found", contractID));
			}
			BigDecimal totalRevenue = contracts.getBigDecimal("revenue");
			LocalDate dateSigned = contracts.getDate("dateSigned").toLocalDate();
			String type = contracts.getString("type");
			rrFactory.calculateRevenueRecognitions(type, contractID, totalRevenue, dateSigned);
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
	}

	@Override
	public int insertContractInfo(int productID, MonetaryAmount contractPrice, LocalDate dateSigned) {

		return contractGateway.insert(productID, contractPrice.getNumber().numberValue(BigDecimal.class)
				.setScale(contractPrice.getCurrency().getDefaultFractionDigits(), RoundingMode.HALF_EVEN), dateSigned);
	}

	@Override
	public int insertProductInfo(String name, String type) {
		return productGateway.insert(name, type);
	}
	
}
