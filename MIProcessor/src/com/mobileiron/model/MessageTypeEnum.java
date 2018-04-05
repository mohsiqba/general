package com.mobileiron.model;

/**
 * Different Message type should be listed here
 * @author MohsinIqbal
 *
 */
public enum MessageTypeEnum {
	UPPRCS,
	REPLCE,
	ANY;
	
	public static MessageTypeEnum getEnumFrom(Message message) {
		switch(message.getType()) {
		case "UPPRCS": return MessageTypeEnum.UPPRCS;
		case "REPLCE": return MessageTypeEnum.REPLCE;
		default : return MessageTypeEnum.ANY;
		}
	}
}
