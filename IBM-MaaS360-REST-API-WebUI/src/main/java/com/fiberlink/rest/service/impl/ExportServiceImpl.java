package com.fiberlink.rest.service.impl;

import java.io.Serializable;

import javax.print.DocFlavor.STRING;

import org.apache.commons.lang3.SerializationUtils;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiberlink.rest.dao.CustomerProperty;
import com.fiberlink.rest.service.ExportService;
import com.fiberlink.utils.Constants;
import com.thoughtworks.xstream.XStream;

@Service
public class ExportServiceImpl implements ExportService{
	@Autowired
	CustomerProperty customerProperty=null;
	
	@Override
	public byte[] export(String custId, String env,String format) throws Exception{
		String xml_string =customerProperty.getCustomerProperty(custId, env);
		//String xml_string ="<?xml version=\"1.0\" ?><test attrib=\"moretest\">Turn this to JSON</test>";
		byte[] byteArr = null;
		switch (format){
		case Constants.EXPORT_EXCEL : byteArr= SerializationUtils.serialize((Serializable) exportToExcel(xml_string));
			break;
		case Constants.EXPORT_JSON : byteArr= Constants.toByteArray(exportToJson(xml_string));
			break;
		case Constants.EXPORT_XML : byteArr= Constants.toByteArray(exportToXml(xml_string));
			break;

		}
		System.out.println("b:"+byteArr);
		return byteArr;
	}
	
	public Object exportToExcel(String data){
		return null;
	}
	
	public Object exportToJson(String data){
		JSONObject xmlJSONObj = XML.toJSONObject(data);
		return xmlJSONObj.toString(4);
	}
	
	public Object exportToXml(String data){
		//return new XStream().fromXML(data);
		return data;
	}
}
