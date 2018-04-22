package com.exercise.main;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * 
 * @author mohsiqba
 *
 */
public class DevicePrincipalPayload {
	private String id;
	private Integer records;
	private Timestamp timestamp;
	private List<DevicePrincipal1> devicePrincipals;
	public DevicePrincipalPayload(String id,Integer records,Timestamp timestamp,List<DevicePrincipal1> devicePrincipals) {
		this.id=id;
		this.records=records;
		this.timestamp=timestamp;
		this.devicePrincipals=devicePrincipals;
	}
	
	static class DevicePrincipal1 {
		private Long billingId;
		private String principal;
		private Boolean _delete;
		
		public DevicePrincipal1(Long billingId,String principal,Boolean _delete) {
			this.principal=principal;
			this._delete=_delete;
			this.billingId=billingId;
		}
		
		@Override
		public String toString(){
			return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		}
	}
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
