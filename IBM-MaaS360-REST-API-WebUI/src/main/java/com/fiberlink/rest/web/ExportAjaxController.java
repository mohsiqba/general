package com.fiberlink.rest.web;

import java.io.OutputStream;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fiberlink.rest.service.ExportService;
import com.fiberlink.utils.Constants;

@Controller
public class ExportAjaxController {

	private final Logger logger = LoggerFactory.getLogger(ExportAjaxController.class);
	private final ExportService exportService;

	@PostConstruct
	public void init(){
		System.out.println("class constructed mohsin");
	}
	@Autowired
	public ExportAjaxController(ExportService exportService) {
		this.exportService = exportService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
		System.out.println("index() is executed!");
		return "index";
	}

	@RequestMapping(value = "/export/{format:.+}", method = RequestMethod.GET)
	public void export(@PathVariable("format") String format,HttpServletRequest request,HttpServletResponse response) throws Exception{
		String custId=request.getParameter("custId");
		String env = request.getParameter("environment");
		System.out.println("export() is executed format requested :"+ format+" |env :"+env+" |custId :"+custId);
		byte[] byteArr;
		byteArr=exportService.export(custId, env, format);
		
		response.setContentType(Constants.contentTypeMap.get(format));
		response.setContentLength(byteArr.length);
		response.setHeader("Content-Disposition",
                "attachment;filename="+env+"_"+custId+Constants.formatMap.get(format));
		
		OutputStream os = response.getOutputStream();
		os.write(byteArr);
		os.flush();
		os.close();
	}
}