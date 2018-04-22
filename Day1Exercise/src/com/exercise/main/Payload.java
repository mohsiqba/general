package com.exercise.main;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Payload{

	private Long id;
	private Integer records;
	private Timestamp timestamp;
	private List<DeviceComplianceStatus2> deviceComplStats;
	private List<DevicePrincipal2> devicePrincipals;
	public Payload(Long id,Integer records,Timestamp timestamp,List<DeviceComplianceStatus2> deviceComplStats,List<DevicePrincipal2> devicePrincipals) {
		this.id=id;
		this.records=records;
		this.timestamp=timestamp;
		this.deviceComplStats=deviceComplStats;
		this.devicePrincipals=devicePrincipals;
	}

	public Payload() {
	}

	public static class DeviceComplianceStatus2 {
		private String billingId;
		private String csn;
		private Boolean isManaged;
		private String isCompliant;
		private List<String> oocReasons;
		private Boolean _deleted;
		public DeviceComplianceStatus2(Long billingId,String csn,Boolean isManaged,String isCompliant,List<String> oocReasons,Boolean _deleted) {
			this.billingId=String.valueOf(billingId);
			this.csn=csn;
			this.isManaged=isManaged;
			this.isCompliant=isCompliant;
			this.oocReasons=oocReasons;
			this._deleted=_deleted;
					
		}
		@Override
		public String toString(){
			return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		}
		public String getBillingId() {
			return billingId;
		}
		public String getCsn() {
			return csn;
		}
		public Boolean getIsManaged() {
			return isManaged;
		}
		public String getIsCompliant() {
			return isCompliant;
		}
		public List<String> getOocReasons() {
			return oocReasons;
		}
		public Boolean get_deleted() {
			return _deleted;
		}
		
		
	}

	public static class DevicePrincipal2 {
		private String billingId;
		private String principal;
		private Boolean _deleted;
		
		public DevicePrincipal2(Long billingId,String principal,Boolean _deleted) {
			this.principal=principal;
			this._deleted=_deleted;
			this.billingId=String.valueOf(billingId);
		}
		
		@Override
		public String toString(){
			return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		}

		public String getBillingId() {
			return billingId;
		}

		public String getPrincipal() {
			return principal;
		}

		public Boolean get_deleted() {
			return _deleted;
		}
		
		
	}
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public Long getId() {
		return id;
	}

	public Integer getRecords() {
		return records;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public List<DeviceComplianceStatus2> getDeviceComplStats() {
		return deviceComplStats;
	}

	public List<DevicePrincipal2> getDevicePrincipals() {
		return devicePrincipals;
	}
	
	
}
