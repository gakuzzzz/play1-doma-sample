package models;

public class Aliases {
	private Aliases() {}
	
	public static EmployeeId EmployeeId(final Integer value) {
		return new EmployeeId(value);
	}
	
	public static Name Name(final String value) {
		return new Name(value);
	}
}
