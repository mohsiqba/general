package com.myrestapi;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
//import org.w3c.dom.Node;

@Path("/getPolicyPayload/{env}/{billingID}/{policyName}")
public class PolicyPayload {
// marking the below function(getPolicyPayload) as get function which gives output at text_xml
	@GET
@Produces(MediaType.TEXT_XML)
public Document getPolicyPayload(@PathParam("env") String env,@PathParam("billingID") String billingID, @PathParam("policyName") String policyName){
		String hostname=null, username, password, port=null, serviceName=null;
		
		switch(env){
			case "iq1" : hostname = "iz1grid1-1-vip.sysint.local"; port = "1699"; serviceName = "vpn2qa1.fiberlink.com";
			break;
			case "iq2" : hostname = "iz1grid1-1-vip.sysint.local"; port = "1699"; serviceName = "vpn2qa2.fiberlink.com";
			break;
			case "iq3" : hostname = "iz1grid1-0-vip.sysint.local"; port = "1699"; serviceName = "vpn2qa3.fiberlink.com";
			break;
			}
			username = "vpn2ro";
			password = "vpn2ro";
			System.out.println(hostname + " " + env);
			String orgid= null;
			DBConnector dbconnector = new DBConnector(username, password);
			dbconnector.Initialize(hostname, port, serviceName);
			Connection connection = dbconnector.connect();	
			//to get org id
			String orgidquery = "select organization_id from boms.customer where secondaryaccountid='" +billingID+"'" ;
			System.out.println(orgidquery);
			ResultSet orgidresult = dbconnector.execute(connection, orgidquery);
			//to open the result
			try {
				orgidresult.next();
				orgid = orgidresult.getString(1);
				orgidresult.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//to get latest version
			String policyversion=null;
			String fetchlatestversion = "select publish_version from boms.po_policy_data where name='" + policyName + "' and organization_id='" +orgid+ "' and rownum =1 order by publish_version desc";
			ResultSet latestversionresult = dbconnector.execute(connection, fetchlatestversion);
			//to open the result
			try {
				latestversionresult.next();
				policyversion = latestversionresult.getString(1);
				latestversionresult.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//to create a document
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();		
			Document document = null;
		    DocumentBuilder documentBuilder;
			try {
				documentBuilder = documentFactory.newDocumentBuilder();
				document = documentBuilder.newDocument();
			} catch (ParserConfigurationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    
			//to get payload configured
			
			String policypayload = "select publish_data from boms.PO_POLICY_DATA where organization_id='" +orgid+ "' and name = '"+policyName+"' and publish_version='" +policyversion+ "'";
			ResultSet policypayloadresult = dbconnector.execute(connection, policypayload);
			//to open result
			try {
				//because the result will have more than one line , we need to read all the lines
				Element e1 = document.createElement("Policy");
				document.appendChild(e1);
				Element  e2 = document.createElement("PolicyName");
				e1.appendChild(e2);
				
				while(policypayloadresult.next()){
					Element e3 = document.createElement("payload");
					e1.appendChild(e3);
				e3.appendChild(document.createTextNode(policypayloadresult.getString(1)));
				
								
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return document;
}
}
