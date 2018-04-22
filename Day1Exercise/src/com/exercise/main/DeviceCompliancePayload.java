package com.exercise.main;

import java.sql.Timestamp;
import java.util.List;

/**
 * 
 * @author mohsiqba
 *
 */
public class DeviceCompliancePayload {

	private String id;
	private Integer records;
	private Timestamp timestamp;
	private List<DeviceComplianceStatus1> deviceComplStats;
	public DeviceCompliancePayload(String id,Integer records,Timestamp timestamp,List<DeviceComplianceStatus1> deviceComplStats) {
		this.id=id;
		this.records=records;
		this.timestamp=timestamp;
		this.deviceComplStats=deviceComplStats;
	}
	
	static class DeviceComplianceStatus1 {
		private Long billingId;
		private String csn;
		private String complianceStatus;
		private List<String> oocReasons;
		public DeviceComplianceStatus1(Long billingId,String csn,String complianceStatus,List<String> oocReasons) {
			this.billingId=billingId;
			this.csn=csn;
			this.complianceStatus=complianceStatus;
			this.oocReasons=oocReasons;
					
		}
	}
}
