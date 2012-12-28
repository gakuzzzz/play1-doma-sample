package models;

import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;

@ExternalDomain
public class NameConverter implements DomainConverter<Name, String> {

	@Override
	public String fromDomainToValue(final Name domain) {
		return domain.getValue();
	}

	@Override
	public Name fromValueToDomain(final String value) {
		return new Name(value);
	}

}
