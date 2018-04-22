package com.fiberlink.rest.web;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExportAjaxController {


	@PostConstruct
	public void init(){
		System.out.println("class constructed mohsin");
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
		System.out.println("index() is executed!");
		return "index";
	}

/*	@RequestMapping(value = "/export/{format:.+}", method = RequestMethod.GET)
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
*/}