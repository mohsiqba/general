package com.exercise.main;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * class for creating/fetching apollo response(s) for DEVICE/DEVICE COMPLIANCE/USER 
 * @author mohsiqba
 *
 */
public class ResponsePayload {
	private Long id;
	private List<FailedElement> failedElements;
	
	public ResponsePayload(Long id,List<FailedElement> failedElements) {
		this.id=id;
		this.failedElements=failedElements;
	}
	public static class FailedElement{
		private Record record;
		private String errorMessage;
		public FailedElement(Record record,String errorMessage) {
			this.record=record;
			this.errorMessage=errorMessage;
		}
		public Record getRecord() {
			return record;
		}
		public String getErrorMessage() {
			return errorMessage;
		}
		@Override
		public String toString(){
			return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		}
	}
	public static class Record{
		private String billingId;
		private String principal;
		private String csn;
		private String userIdentifier;
		public Record(String billingId,String principal,String csn, String userIdentifier) {
			this.billingId=billingId;
			this.principal=principal;
			this.csn=csn;
			this.userIdentifier = userIdentifier;
		}
		public String getBillingId() {
			return billingId;
		}
		public String getPrincipal() {
			return principal;
		}
		public String getCsn() {
			return csn;
		}
		public String getUserIdentifier() {
			return userIdentifier;
		}
		@Override
		public String toString(){
			return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		}
	}
	public Long getId() {
		return id;
	}
	public List<FailedElement> getFailedElements() {
		return failedElements;
	}
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
