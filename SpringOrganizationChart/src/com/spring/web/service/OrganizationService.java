package com.spring.web.service;

import java.util.List;

import com.spring.jdbc.model.Organization;

public interface OrganizationService extends Service<Organization, Integer>{
	public Organization add(Organization sp);
	public Organization get(Integer id);
	public List<Organization> getAll();
	public Organization update(Organization sp);
	public Organization delete(Integer id);
}
