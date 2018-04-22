package com.spring.web.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.spring.jdbc.dao.OrganizationDAO;
import com.spring.jdbc.model.Organization;

public class OrganizationServiceImpl implements OrganizationService{
	private static final Logger logger=Logger.getLogger(OrganizationServiceImpl.class);
	private OrganizationDAO orgDao;
	
	public void setOrgDao(OrganizationDAO orgDao) {
		this.orgDao = orgDao;
	}

	@Override
	public Organization add(Organization sp) {
		logger.info("class=> OrganizationServiceImpl method => add()  : adding Organization :"+sp);
		return orgDao.add(sp);
	}

	@Override
	public Organization get(Integer id) {
		logger.info("class=> OrganizationServiceImpl method => get()  : getting Organization by Id :"+id);
		return orgDao.get(id);
	}

	@Override
	public List<Organization> getAll() {
		logger.info("class=> OrganizationServiceImpl method => getAll()  : getting all Organization");
		return orgDao.getAll();
	}

	@Override
	public Organization update(Organization sp) {
		logger.info("class=> OrganizationServiceImpl method => update()  : updating Organization :"+sp);
		return orgDao.update(sp);
	}

	@Override
	public Organization delete(Integer id) {
		logger.info("class=> OrganizationServiceImpl method => delete()  : adding Organization :"+id);
		return orgDao.delete(id);
	}

}
