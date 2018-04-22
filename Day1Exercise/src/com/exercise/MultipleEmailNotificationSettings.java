package com.exercise;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * 
 * @author MohsinIqbal
 * Module : MDM_IOS
 * Message Type : EmailNotificationSettingsV2
 *
 */
@XStreamAlias("EmailNotificationSettings")
public class MultipleEmailNotificationSettings  implements Serializable
{	
	private static final long serialVersionUID = 1L;

	@XStreamAlias("updateType")
	private String updateType;
	
	@XStreamAlias("mailBoxesInThisMessage")
	private String mailBoxesInThisMessage;
	
	@XStreamImplicit(itemFieldName = "EmailNotificationSetting")
	private List<EmailNotificationSettings> emailSettingsList=new ArrayList<EmailNotificationSettings>();

	public List<EmailNotificationSettings> getEmailSettingsList() {
		return emailSettingsList;
	}

	public void setEmailSettingsList(List<EmailNotificationSettings> emailSettingsList) {
		this.emailSettingsList = emailSettingsList;
	}

	public String getUpdateType() {
		return updateType;
	}

	public void setUpdateType(String updateType) {
		this.updateType = updateType;
	}

	public String getMailBoxesInThisMessage() {
		return mailBoxesInThisMessage;
	}

	public void setMailBoxesInThisMessage(String mailBoxesInThisMessage) {
		this.mailBoxesInThisMessage = mailBoxesInThisMessage;
	}
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
