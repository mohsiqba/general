package com.bima.utils;

public class Utils {
	public static final String SECTION="SECTION-";
	public static final String SUB_SECTION="SUB-SECTION-";
	public static final String DOT_SEPARATOR=".";
	
	/**
	 * checks whether current line is a comment line(starts with hash(#) or exclaim(!))
	 * @param line
	 * @return
	 */
	public static Boolean isComment(String line) {
		if(!line.isEmpty() && (line.startsWith("#")|| line.startsWith("!")))
			return true;
		else if(line.isEmpty())
			return true;
		else
			return false;
	}
	
	/**
	 * checks whether the given line is property based on key value
	 * @param line
	 * @return
	 */
	public static Boolean isKeyValueLine(String line) {
		if(line.isEmpty())
			return false;
		else if(line.contains("="))
			return true;
		else
			return false;
	}
	
	/**
	 * parses property line to get key and value from it.
	 * @param line
	 * @return
	 */
	public static String[] getKeyValueFromLine(String line) {
		String[] kv=null;
		if(isKeyValueLine(line)) {
			kv=new String[2];
			String trimStr=line.trim();
			kv[0]=(trimStr.substring(0, trimStr.indexOf("="))).trim();
			kv[1]=(trimStr.substring(trimStr.indexOf("=")+1)).trim();
		}
		return kv;
	}
	
	/**
	 * construct key from root of the hierarchy
	 * @param parent
	 * @param key
	 * @return
	 */
	public static String constructKey(String parent,String key) {
		if(parent!=null && parent!="")
			return parent+key;
		else
			return key;
	}
}
