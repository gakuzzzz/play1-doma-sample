package models;

import org.seasar.doma.Domain;

public class Name {

	private final String value;
	
	public Name(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Name[" + value + "]";
	}
	
}
