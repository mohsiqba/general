package com.fiberlink.rest.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.fiberlink.rest.dao.CustomerProperty;

public interface ExportService {
	byte[] export(String custId,String env,String format) throws Exception;
}