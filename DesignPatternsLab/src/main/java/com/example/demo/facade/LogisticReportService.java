package com.example.demo.facade;

import java.sql.Connection;
import java.util.Date;

public class LogisticReportService {

	public static Connection getLogisticsDBconnection() {
		return null;
	}
	
	public void generatePDFReport(Date date) {
		System.out.println("Generating Logistics Report in " + "PDF format for\t" + date+ "\n");
	}

	public void generateCSVReport(Date date) {
		System.out.println("Generating Logistics Report in " + "CSV format for\t" + date);
	}
}
