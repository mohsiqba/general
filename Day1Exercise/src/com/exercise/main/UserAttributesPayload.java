/**
 * 
 */
package com.exercise.main;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author SOMA SEKHAR
 *
 */
public class UserAttributesPayload {
	
	private Long id;
	private Integer records;
	private Timestamp timestamp;
	private List<UserAttributes> users;
	
	public UserAttributesPayload(Long id, Integer records, Timestamp timestamp,
			List<UserAttributes> userAttributesList) {
		this.id = id;
		this.records = records;
		this.timestamp = timestamp;
		this.users = userAttributesList;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getRecords() {
		return records;
	}
	public void setRecords(Integer records) {
		this.records = records;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public List<UserAttributes> getUserAttributesList() {
		return users;
	}
	public void setUserAttributesList(List<UserAttributes> userAttributesList) {
		this.users = userAttributesList;
	}
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
