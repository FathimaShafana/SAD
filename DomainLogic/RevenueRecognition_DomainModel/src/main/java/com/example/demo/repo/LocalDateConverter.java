package com.example.demo.repo;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

//This is applied to any local date or
//any type defined in AttributeConverter
@Converter(autoApply=true)
public class LocalDateConverter implements AttributeConverter <LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate attribute) {
		return Date.valueOf(attribute);
	}
	
	@Override
	public LocalDate convertToEntityAttribute(Date dbData) {
		return dbData.toLocalDate();
	}
}
