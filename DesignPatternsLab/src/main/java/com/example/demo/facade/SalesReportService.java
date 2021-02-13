package com.example.demo.facade;

import java.sql.Connection;
import java.util.Date;

public class SalesReportService {

	public static Connection getSaleDBconnection() {
		return null;
	}
	
	public void generatePDFReport(Date date) {
		System.out.println("Generating Sales Report in " + "PDF format for\t" + date);
	}

	public void generateCSVReport(Date date) {
		System.out.println("Generating Sales Report in " + "CSV format for\t" + date);
	}
}


