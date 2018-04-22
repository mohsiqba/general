package com.exercise.main;
/**
 * 
 * @author mohsiqba
 *
 */
public class DevicePrincipal {
	private Long billingId;
	private String principal;
	private Boolean _delete;
	
	public DevicePrincipal(Long billingId,String principal,Boolean _delete) {
		this.principal=principal;
		this._delete=_delete;
		this.billingId=billingId;
	}
	
}
