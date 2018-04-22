package com.exercise.main;

import java.util.List;
/**
 * 
 * @author mohsiqba
 *
 */
public class DeviceComplianceStatus {
	private Long billingId;
	private String csn;
	private transient String complianceStatus;
	private List<String> oocReasons;
	public DeviceComplianceStatus(Long billingId,String csn,String complianceStatus,List<String> oocReasons) {
		this.billingId=billingId;
		this.csn=csn;
		this.complianceStatus=complianceStatus;
		this.oocReasons=oocReasons;
				
	}
}
