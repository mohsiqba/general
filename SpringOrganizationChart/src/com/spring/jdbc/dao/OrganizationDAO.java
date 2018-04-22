package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.model.Organization;

public class OrganizationDAO {
	private static final Logger logger=Logger.getLogger(OrganizationDAO.class);
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public JdbcTemplate getJdbcTemplate(){
		return new JdbcTemplate(dataSource);
	}
	
	public Organization add(Organization sp) {
		logger.info("Class => OrganizationDAO  Method => add() ");
		int orgGenId=getJdbcTemplate().queryForObject(QueryString.ORG_ID_GET_QRY, Integer.class);
		sp.setOrgId(orgGenId);
		Object[] args = new Object[] {sp.getOrgId(), sp.getOrgName(), sp.getOrgDescription()};
		int out = getJdbcTemplate().update(QueryString.ORG_INSERT_QRY, args);
		if(out !=0){
			logger.info("Organization saved with id="+sp.getOrgId());
			return get(orgGenId);
		}else {
			logger.info("Organization save failed with id="+sp.getOrgId());
			return null;
		}
	}


	public Organization get(Integer id) {
		logger.info("Class => OrganizationDAO  Method => get() ");
		Organization org= getJdbcTemplate().queryForObject(QueryString.ORG_SELECT_BY_ID_QRY, new Object[]{id}, new RowMapper<Organization>(){
		public Organization mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			Organization org = new Organization();
			org.setOrgId(rs.getInt(QueryString.ORG_ID));
			org.setOrgName(rs.getString(QueryString.ORG_NAME));
			org.setOrgDescription(rs.getString(QueryString.ORG_DESC));
			return org;
		}});
		logger.info("for Id : "+id+" returning "+org);
		return org;
	}

	public List<Organization> getAll() {
		logger.info("Class => OrganizationDAO  Method => getAll() ");
		List<Organization> orgList = new ArrayList<Organization>();
		List<Map<String,Object>> orgRows = getJdbcTemplate().queryForList(QueryString.ORG_GET_ALL_QRY);
		for(Map<String,Object> orgRow : orgRows){
			Organization org = new Organization();
			org.setOrgId(Integer.parseInt(String.valueOf(orgRow.get(QueryString.ORG_ID))));
			org.setOrgName(String.valueOf(orgRow.get(QueryString.ORG_NAME)));
			org.setOrgDescription(String.valueOf(orgRow.get(QueryString.ORG_DESC)));
			orgList.add(org);
		}
		logger.info("returning all Organizations :"+orgList);		
		return orgList;
	}

	public Organization update(Organization sp) {
		logger.info("Class => OrganizationDAO  Method => update() ");
		Object[] args = new Object[] {sp.getOrgName(), sp.getOrgDescription(), sp.getOrgId()};
		int out = getJdbcTemplate().update(QueryString.ORG_UPDATE_BY_ID_QRY, args);
		if(out !=0){
			logger.info("Organization updated with id="+sp.getOrgId());
		}else logger.info("No Organization found with id="+sp.getOrgId());
		return get(sp.getOrgId());
	}

	public Organization delete(Integer id) {
		logger.info("Class => OrganizationDAO  Method => delete() ");
		Organization toBeDeleted=get(id);
		int out = getJdbcTemplate().update(QueryString.ORG_DELETE_BY_ID_QRY, id);
		if(out !=0){
			logger.info("Organization deleted with id="+id);
			return toBeDeleted;
		}else 
			logger.info("No Organization found with id="+id);
		return null;
	}
}
