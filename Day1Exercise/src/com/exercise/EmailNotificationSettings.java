package com.exercise;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * @author MohsinIqbal
 * Module : MDM_IOS
 * Message Type : EmailNotificationSettingsV2
 *
 */
@XStreamAlias("EmailNotificationSetting")
public class EmailNotificationSettings implements Serializable
{
	private static final long serialVersionUID = 6744618516367351201L;

	@XStreamAlias("mailboxId")
	private String mailboxId;			
	
	@XStreamAlias("dataSize")
	private String dataSize;
	
	@XStreamAlias("data")
	private byte[] data;

	public String getMailboxId() {
		return mailboxId;
	}

	public void setMailboxId(String mailboxId) {
		this.mailboxId = mailboxId;
	}

	public String getDataSize() {
		return dataSize;
	}

	public void setDataSize(String dataSize) {
		this.dataSize = dataSize;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
	
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
}
