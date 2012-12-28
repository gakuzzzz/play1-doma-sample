package config;

import javax.sql.DataSource;

import org.seasar.doma.jdbc.DomaAbstractConfig;
import org.seasar.doma.jdbc.JdbcLogger;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.H2Dialect;
import org.seasar.doma.jdbc.dialect.MysqlDialect;
import org.seasar.doma.jdbc.dialect.PostgresDialect;
import org.seasar.doma.jdbc.tx.LocalTransaction;
import org.seasar.doma.jdbc.tx.LocalTransactionalDataSource;

import play.Play;
import play.db.DB;
import play.exceptions.ConfigurationException;
import play.modules.doma.PlayLogger;

public class DomaConfig extends DomaAbstractConfig {

	protected static final LocalTransactionalDataSource dataSource = new LocalTransactionalDataSource(DB.datasource);

	protected static final Dialect dialect = createDialect();
	
	protected static Dialect createDialect() {
		final String driver = Play.configuration.getProperty("db.driver", "org.h2.Driver");
		if (driver.contains(".h2.")) return new H2Dialect();
		if (driver.contains(".postgresql.")) return new PostgresDialect();
		if (driver.contains(".mysql.")) return new MysqlDialect();
		throw new ConfigurationException("Could not select DB Dialect");
	}

	protected static final JdbcLogger jdbcLogger = new PlayLogger();

	@Override
	public DataSource getDataSource() {
		return dataSource;
	}

	@Override
	public Dialect getDialect() {
		return dialect;
	}

	@Override
	public JdbcLogger getJdbcLogger() {
		return jdbcLogger;
	}

	public static LocalTransaction getLocalTransaction() {
		return dataSource.getLocalTransaction(jdbcLogger);
	}

}
