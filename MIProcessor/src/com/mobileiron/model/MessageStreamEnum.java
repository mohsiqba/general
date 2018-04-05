package com.mobileiron.model;
/**
 * different Message Stream should be listed here
 * @author MohsinIqbal
 *
 */
public enum MessageStreamEnum {
	STANDARD;
	
	public static MessageStreamEnum getEnumFrom(Message message) {
		String sCase="";
		if(message!=null)
			sCase=message.getStream();
		switch(sCase) {
		case "STANDARD": return MessageStreamEnum.STANDARD;
		default : return MessageStreamEnum.STANDARD;
		}
	}
}
