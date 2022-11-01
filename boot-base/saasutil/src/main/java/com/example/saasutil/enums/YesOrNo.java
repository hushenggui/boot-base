package com.example.saasutil.enums;

public enum YesOrNo {

	YES("1"),
	NO("0");

	private String value;

	YesOrNo(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}