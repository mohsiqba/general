package com.exercise.main;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXMLFileJava {

	public static final String xmlFilePath = "C:\\mohsin utilities\\example.xml";

	public static void main(String argv[]) {

		try {

			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();
			// root element
			Element root = document.createElement("config");
			document.appendChild(root);
			//status_code
			Element status_code = document.createElement("status_code");
			status_code.appendChild(document.createTextNode("3"));
			root.appendChild(status_code);
			//err_code
			Element err_code = document.createElement("err_code");
			err_code.appendChild(document.createTextNode("3"));
			root.appendChild(err_code);
			//err_msg
			Element err_msg = document.createElement("err_msg");
			err_msg.appendChild(document.createTextNode("3"));
			root.appendChild(err_msg);
			//properties_length
			Element no_of_properties = document.createElement("properties_length");
			no_of_properties.appendChild(document.createTextNode("3"));
			root.appendChild(no_of_properties);
			
			//customer element
			Element customer = document.createElement("customer");
			root.appendChild(customer);
			//billingId element
			Element billingId = document.createElement("billingID");
			billingId.appendChild(document.createTextNode("2080130"));
			customer.appendChild(billingId);
			//lastname element
			Element orgId = document.createElement("orgID");
			orgId.appendChild(document.createTextNode("448368"));
			customer.appendChild(orgId);

			//properties element
			Element properties = document.createElement("properties");
			root.appendChild(properties);
			// firstname element
			Element p1 = document.createElement("property");
			p1.setAttribute("name", "2_X_CUSTOMER");
			p1.setAttribute("value", "YES");
			properties.appendChild(p1);

			// lastname element
			Element p2 = document.createElement("property");
			p2.setAttribute("name", "ENABLE_MOBILE_APP_SECURITY_REVIEW");
			p2.setAttribute("value", "YES");
			properties.appendChild(p2);

			// email element
			Element p3 = document.createElement("property");
			p3.setAttribute("name", "PSS_CUSTOMER");
			p3.setAttribute("value", "YES");
			properties.appendChild(p3);			
			
			
			// create the xml file
			//transform the DOM Object to an XML File
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(xmlFilePath));

			// If you use
			// StreamResult result = new StreamResult(System.out);
			// the output will be pushed to the standard output ...
			// You can use that for debugging 

			transformer.transform(domSource, streamResult);

			System.out.println("Done creating XML File");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
}