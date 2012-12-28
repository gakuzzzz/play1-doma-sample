package models;

import org.seasar.doma.Domain;

@Domain(valueType = Integer.class)
public class EmployeeId {

	private final Integer value;
	
	public EmployeeId(final Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "EmployeeId[" + value + "]";
	}
	
}
