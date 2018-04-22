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

@Path("/getCustomerProperties/{env}/{billingID}")
public class CustomerProperty {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String plainText(){
		return "Hello";
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
		public String htmlText(){
			return "<html><body>Hello</body></html>";
		}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public Document xmlText(@PathParam("env") String env, @PathParam("billingID") String billingID) throws ParserConfigurationException{
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
			String query = "select customerid from boms.customer where secondaryaccountid='" + billingID + "'";
			ResultSet rs = dbconnector.execute(connection, query);
			try {
				rs.next();
				orgid=rs.getString(1);
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 query = "select wp.property_name,cp.property_value,wp.display_name from vpn2.customer_property cp left join vpn2.world_property wp on cp.property_id = wp.property_id where cp.customer_id='" + orgid + "'"; 
			
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();		
		    DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
		    Document document = documentBuilder.newDocument();
		    
			// root element
			Element root = document.createElement("config");
			document.appendChild(root);
			//status_code
			Element status_code = document.createElement("status_code");
			status_code.appendChild(document.createTextNode("3"));			//will be decided later
			root.appendChild(status_code);
			//err_code
			Element err_code = document.createElement("err_code");
			err_code.appendChild(document.createTextNode("3"));				//will be decided later
			root.appendChild(err_code);
			//err_msg
			Element err_msg = document.createElement("err_msg");
			err_msg.appendChild(document.createTextNode("3"));				//will be decided later
			root.appendChild(err_msg);
			//customer element
			Element customer = document.createElement("customer");
			root.appendChild(customer);
			//billingId element
			Element billingId = document.createElement("billingID");
			billingId.appendChild(document.createTextNode(billingID));
			customer.appendChild(billingId);
			//orgId element
			Element orgId = document.createElement("orgID");
			orgId.appendChild(document.createTextNode(orgid));
			customer.appendChild(orgId);
		    
			//properties element
			Element properties = document.createElement("properties");
			root.appendChild(properties);
			
		    rs = dbconnector.execute(connection, query);
		    int num_of_props=0;
			try {
				while(rs.next()){
					Element p = document.createElement("property");
					p.setAttribute("name", rs.getString(1));
					p.setAttribute("value", rs.getString(2));
					p.setAttribute("desc", rs.getString(3));
					properties.appendChild(p);
					num_of_props++;
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//properties_length
			Element no_of_properties = document.createElement("properties_length");
			no_of_properties.appendChild(document.createTextNode(String.valueOf(num_of_props)));
			root.appendChild(no_of_properties);
		
		return (document);
	}
}
