package config;

import models.EmployeeDao;
import models.EmployeeDaoImpl;

import com.google.inject.AbstractModule;

public class GuiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(EmployeeDao.class).to(EmployeeDaoImpl.class).asEagerSingleton();
	}

}
