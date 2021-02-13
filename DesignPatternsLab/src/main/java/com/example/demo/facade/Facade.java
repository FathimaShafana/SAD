package com.example.demo.facade;

import java.sql.Connection;
import java.util.Date;

public class Facade {
	
		public static void generateReport(Types type, ReportTypes reportType, Date date) {
		Connection conn=null;
		
		switch (type) {
		
		case SALE:
			conn=SalesReportService.getSaleDBconnection();
			SalesReportService saleService = new SalesReportService();
		switch(reportType) {
			case CSV:
				saleService.generateCSVReport(date);
				break;
			case PDF:
				saleService.generatePDFReport(date);
				break;
			}
			break;
		
		case LOGISTIC:
			conn=LogisticReportService.getLogisticsDBconnection();
			LogisticReportService logisticService = new LogisticReportService();
		switch(reportType) {
			case CSV:
				logisticService.generateCSVReport(date);
				break;
			case PDF:
				logisticService.generatePDFReport(date);
				break;
			}
		break;
	}
	
}
		public static enum Types{
			SALE,LOGISTIC
		}
		
		public static enum ReportTypes{
			PDF,CSV
		}
}
