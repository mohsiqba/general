package com.bima.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.bima.utils.Utils;

public class PropertiesPersistence {
	private static Map<String,String> propertyMap=new HashMap<>();
	public static Stack<String> stack=new Stack<>();
	
	/**
	 * traverse Stack DS to construct key from root of the hierarchy
	 * @return
	 */
	public static String getKeyFromStack() {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<stack.size();i++) {
			sb.append(stack.get(i)).append(Utils.DOT_SEPARATOR);
		}
		return sb.toString();
	}
	
	/**
	 * persists property into Map
	 * @param key
	 * @param value
	 */
	public static void addEntry(String key,String value){
		propertyMap.put(key.toUpperCase(), value);
	}
	
	/**
	 * fetches value from map for specified key.
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		String value=null;
		if(key!=null) {
			String modifiedRootKey=key.replaceAll("::", ".").toUpperCase();
			if(getPropertyMap().containsKey(modifiedRootKey))
				return getPropertyMap().get(modifiedRootKey);
			String actualKey=modifiedRootKey.substring(modifiedRootKey.lastIndexOf(".")+1);
			List<String> possibleRootKeys=new ArrayList<>();
			Integer index=modifiedRootKey.indexOf(".");
			while(index>0) {
				possibleRootKeys.add(modifiedRootKey.substring(0, index+1).concat(actualKey));
				index=modifiedRootKey.indexOf(".", index+1);
			}
			for(int i=possibleRootKeys.size()-1;i>=0;i--)
				if(getPropertyMap().containsKey(possibleRootKeys.get(i)))
					return getPropertyMap().get(possibleRootKeys.get(i));
			
			return getPropertyMap().get(actualKey);
		}
		return value;
	}
	
	/**
	 * return all properties based map.
	 * @return
	 */
	public static Map<String,String> getPropertyMap(){
		return propertyMap;
	}
	
	/**
	 * identify whether to push/pop new Tag based on the logic.
	 * currently this supports infinite recursive hierarchy.
	 * @param tag
	 */
	public static void checkWhetherPopOrPush(String tag) {
		if(tag.startsWith(Utils.SECTION)) {
			//delete stack for older section
			stack.clear();
			//push for new section
			stack.push(tag);
		}else if(tag.startsWith(Utils.SUB_SECTION) && stack.peek().startsWith(Utils.SUB_SECTION)) {
			String peek=stack.peek().substring(stack.peek().lastIndexOf("-")+1);
			if(peek.length()<=tag.substring(tag.lastIndexOf("-")+1).length()) {
				//push
				stack.push(tag);
			}else {
				//pop  till length becomes same and push new tag
				String tagIdentifier=tag.substring(0, tag.lastIndexOf("-")+1);
				for(int i=stack.size()-1;i>=0;i--) {
					if((stack.get(i).startsWith(tagIdentifier)) &&(stack.get(i).substring(stack.get(i).lastIndexOf("-")+1).length()>=tag.substring(tag.lastIndexOf("-")+1).length())) {
						stack.pop();
					}
				}
				stack.push(tag);
			}
		}else {
			//different tags
			stack.push(tag);
		}
	}
}
