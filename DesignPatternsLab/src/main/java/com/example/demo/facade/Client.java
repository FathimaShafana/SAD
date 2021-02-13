package com.example.demo.facade;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
public static void main(String[] args) {
	SimpleDateFormat formatter=new SimpleDateFormat("dd/mm/yyyy HH:MM:SS");
	Date date=new Date();
	
	//Generate Sale PDF and Logistics PDF report using facade
	Facade.generateReport(Facade.Types.SALE, Facade.ReportTypes.PDF, date);
	Facade.generateReport(Facade.Types.LOGISTIC, Facade.ReportTypes.PDF, date);
	
	//Generate Sale CSV and Logistics CSV report using facade
		Facade.generateReport(Facade.Types.SALE, Facade.ReportTypes.CSV, date);
		Facade.generateReport(Facade.Types.LOGISTIC, Facade.ReportTypes.CSV, date);
}
}
