package com.Corptec.SpringBootSalesforceAndSqlIntegrator.model;

public enum UserType {
	ADMIN("ADMIN"), CUSTOMER("CUSTOMER");
	
	private final String type;
	
	UserType(String string) {
		type = string;
	}
	
	@Override
	public String toString() {
		return type;
	}
}
