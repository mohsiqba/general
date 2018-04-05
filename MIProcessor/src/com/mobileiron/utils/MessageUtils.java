package com.mobileiron.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.mobileiron.model.Message;
/**
 * 
 * @author MohsinIqbal
 *
 */
public class MessageUtils {

	/**
	 * parse String Message Into Message Model
	 * @param message
	 * @return
	 */
	public static Message parseMessage(String message) {
		Message msg=new Message();
		msg.setMessage(message);
		msg.setType(message.substring(0,6));
		msg.setLength(message.substring(7, 11));
		msg.setValue(message.substring(12));
		return msg;
	}

	/**
	 * parse Stream Message Into List<String> 
	 * @param message
	 * @return List<String>
	 */
	public static List<String> convertStream(String message) {
		List<String> strMessages=null;
		if(StringUtils.isEmpty(message))
			return strMessages;
		strMessages=new ArrayList<>();
		while(StringUtils.isNotEmpty(message)) {
			Integer len=Integer.valueOf(message.substring(7, 11))+12;
			strMessages.add(message.substring(0, len));
			message=message.substring(len);
		}
		return strMessages;
	}
	
	/**
	 * parse Stream Message Into Message Model
	 * @param message
	 * @return List<Message>
	 */
	public static List<Message> convertStreamToModel(String message) {
		List<Message> strMessages=null;
		if(StringUtils.isEmpty(message))
			return strMessages;
		strMessages=new ArrayList<>();
		while(StringUtils.isNotEmpty(message)) {
			Integer len=Integer.valueOf(message.substring(7, 11))+12;
			strMessages.add(parseMessage(message.substring(0, len)));
			message=message.substring(len);
		}
		return strMessages;
	}
}
