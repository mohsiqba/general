package com.fiberlink.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Constants {
	public static final String EXPORT_EXCEL="excel";
	public static final String EXPORT_JSON="json";
	public static final String EXPORT_XML ="xml";
	public static Map<String, String> formatMap=new HashMap<String, String>();
	public static Map<String, String> contentTypeMap=new HashMap<String, String>();
	static 
	{
		formatMap.put(EXPORT_JSON, ".json");
		formatMap.put(EXPORT_XML, ".xml");
		formatMap.put(EXPORT_EXCEL, ".xls");
		
		contentTypeMap.put(EXPORT_JSON, "application/json");
		contentTypeMap.put(EXPORT_XML, "application/xml");
		contentTypeMap.put(EXPORT_EXCEL, "application/vnd.ms-excel");
	}
	
	public static byte[] toByteArray (Object obj)
	{
	  byte[] bytes = null;
	  ByteArrayOutputStream bos = new ByteArrayOutputStream();
	  try {
	    ObjectOutputStream oos = new ObjectOutputStream(bos); 
	    oos.writeObject(obj);
	    oos.flush(); 
	    oos.close(); 
	    bos.close();
	    bytes = bos.toByteArray ();
	  }
	  catch (IOException ex) {
	    ex.printStackTrace();
	  }
	  return bytes;
	}
	    
	public static Object toObject (byte[] bytes)
	{
	  Object obj = null;
	  try {
	    ByteArrayInputStream bis = new ByteArrayInputStream (bytes);
	    ObjectInputStream ois = new ObjectInputStream (bis);
	    obj = ois.readObject();
	  }
	  catch (IOException ex) {
	    //TODO: Handle the exception
	  }
	  catch (ClassNotFoundException ex) {
	    //TODO: Handle the exception
	  }
	  return obj;
	}
}
