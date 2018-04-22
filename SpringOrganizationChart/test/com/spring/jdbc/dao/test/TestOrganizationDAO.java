package com.spring.jdbc.dao.test;

import java.io.FileInputStream;
import java.sql.SQLException;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

import org.dbunit.DataSourceBasedDBTestCase;
import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.oracle.OracleDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.spring.jdbc.dao.OrganizationDAO;
import com.spring.jdbc.model.Organization;

public class TestOrganizationDAO extends DataSourceBasedDBTestCase {
	private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String JDBC_URL = "jdbc:oracle:thin:@//iz1grid1-0-vip.sysint.local:1699/vpn2iso2.fiberlink.com";
	private static final String USER = "system";
	private static final String PASSWORD = "sysidsvpn22";
	private DataSource dataSource;
	OrganizationDAO repository;

	@Before
	protected void setUp() throws Exception {
		dataSource=getDataSource();
		repository=new OrganizationDAO();
		repository.setDataSource(dataSource);
		importDataSet();
		super.setUp();
	}
	
	@After
	protected void tearDown() throws Exception
	{
	}

	public void importDataSet() throws Exception {
		IDataSet dataSet = getDataSet();
		cleanlyInsert(dataSet);
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(new FileInputStream("C:\\eclipse_workspace\\SpringOrganizationChart\\test\\com\\spring\\jdbc\\dao\\test\\dataset.xml"));
	}

	private void cleanlyInsert(IDataSet dataSet) throws Exception {
		DataSourceDatabaseTester  databaseTester = new DataSourceDatabaseTester(dataSource);
		databaseTester.getConnection().getConfig().setProperty(DatabaseConfig.FEATURE_QUALIFIED_TABLE_NAMES, true);
		databaseTester.getConnection().getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new OracleDataTypeFactory());
		databaseTester.setSchema("SCHEMA8");
		databaseTester.setSetUpOperation(DatabaseOperation.REFRESH);
		databaseTester.setDataSet(dataSet);
		databaseTester.onSetup();
	}

	@Test
	public void testGetPositive() throws Exception {
		Organization org= repository.get(1003);
		assertEquals(org.getOrgId(), 1003);
		assertEquals(org.getOrgName(), "CXPS");
		assertEquals(org.getOrgDescription(), "Banking");
	}

	@Test
	public void testGetNegative() throws Exception {
		Organization org = repository.get(1010);
		assertNull(org);
	}

	@Override
	protected DataSource getDataSource() {
		OracleDataSource  dataSource=null;
		try{
		dataSource = new OracleDataSource ();
		dataSource.setDriverType(JDBC_DRIVER);
		dataSource.setURL(JDBC_URL);
		dataSource.setUser(USER);
		dataSource.setPassword(PASSWORD);
		}catch(Exception e){
			e.printStackTrace();
		}
		return dataSource;
	}


}
