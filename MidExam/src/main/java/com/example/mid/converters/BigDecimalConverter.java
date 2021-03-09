package com.example.mid.converters;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import javax.money.MonetaryAmount;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=true)
public class BigDecimalConverter implements AttributeConverter <MonetaryAmount, BigDecimal> {
	
	@Override
	public BigDecimal convertToDatabaseColumn(MonetaryAmount attribute) {
		return null;
		//return (BigDecimal)attribute;
	}
	
	@Override
    public MonetaryAmount convertToEntityAttribute(BigDecimal dbData) {
		return null;
		//return dbData.toMonetaryAmount();
    }
	
}

