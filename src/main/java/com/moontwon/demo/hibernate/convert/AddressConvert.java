package com.moontwon.demo.hibernate.convert;

import javax.persistence.AttributeConverter;

 public class AddressConvert implements AttributeConverter<String, String> {

	@Override
	public String convertToDatabaseColumn(String attribute) {
		return attribute + "_666666666";
	}

	@Override
	public String convertToEntityAttribute(String dbData) {
		return dbData.split("_666666666")[0];
	}

}