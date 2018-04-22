package com.exercise;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class SavedSearch {


	String description;

	Long id;
	String type;
	String name;
	String searchType;
	List<String> policyListForFiltering;
	List<String> enrollmentListForFiltering;
	List<String> appsListForFiltering;
	List<String> docsListForFiltering;
	List<String> rulesListForFiltering;
	List<String> locationsListForFiltering;
	List<String> sharepointSitesForFiltering;
	List<String> groupBasedRulesForFiltering;
	String formattedLastEvaluatedDate;
	Timestamp lastEvaluatedDate;
	String updatedUser;
	String createdUser;
	
	/**VD:actually lastevaluated date is getting used for last updated date hence using another attribute lastGrpEvaluatedDate **/
	Timestamp lastGrpEvaluatedDate;
	// Defaulting to false as in db we can have 0/1, and we are returning true/false from hibernet mapping
	String evalMode = "false";
	
	Timestamp createdDate;
	String formattedCreatedDate;
	boolean privateGroup;
	boolean fibSavedGroup;
	public SavedSearch(String evalMode){
		this.evalMode=evalMode;
	}
	public Timestamp getLastEvaluatedDate() {
		return lastEvaluatedDate;
	}
	public void setLastEvaluatedDate(Timestamp lastEvaluatedDate) {
		this.lastEvaluatedDate = lastEvaluatedDate;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public String getUpdatedUser() {
		return updatedUser;
	}
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}
	public String getformattedLastEvaluatedDate() {
		return formattedLastEvaluatedDate;
	}
	public void setformattedLastEvaluatedDate(String formattedLastEvaluatedDate) {
		this.formattedLastEvaluatedDate = formattedLastEvaluatedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getSharepointSitesForFiltering() {
		return sharepointSitesForFiltering;
	}
	
	public List<String> getGroupBasedRulesForFiltering() {
		return groupBasedRulesForFiltering;
	}
	public void setGroupBasedRulesForFiltering(
			List<String> groupBasedRulesForFiltering) {
		this.groupBasedRulesForFiltering = groupBasedRulesForFiltering;
	}
	public void setSharepointSitesForFiltering(
			List<String> sharepointSitesForFiltering) {
		this.sharepointSitesForFiltering = sharepointSitesForFiltering;
	}
	public List<String> getLocationsListForFiltering() {
		return locationsListForFiltering;
	}
	public void setLocationsListForFiltering(List<String> locationsListForFiltering) {
		this.locationsListForFiltering = locationsListForFiltering;
	}
	public List<String> getRulesListForFiltering() {
		return rulesListForFiltering;
	}
	public void setRulesListForFiltering(List<String> rulesListForFiltering) {
		this.rulesListForFiltering = rulesListForFiltering;
	}
	public List<String> getDocsListForFiltering() {
		return docsListForFiltering;
	}
	public void setDocsListForFiltering(List<String> docsListForFiltering) {
		this.docsListForFiltering = docsListForFiltering;
	}
	public List<String> getAppsListForFiltering() {
		return appsListForFiltering;
	}
	public void setAppsListForFiltering(List<String> appsListForFiltering) {
		this.appsListForFiltering = appsListForFiltering;
	}
	public List<String> getPolicyListForFiltering() {
		return policyListForFiltering;
	}
	public void setPolicyListForFiltering(List<String> policyListForFiltering) {
		this.policyListForFiltering = policyListForFiltering;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getLastGrpEvaluatedDate() {
		return lastGrpEvaluatedDate;
	}
	public void setLastGrpEvaluatedDate(Timestamp lastGrpEvaluatedDate) {
		this.lastGrpEvaluatedDate = lastGrpEvaluatedDate;
	}

	public List<String> getEnrollmentListForFiltering()
	{
		return enrollmentListForFiltering;
	}

	public void setEnrollmentListForFiltering(List<String> enrollmentListForFiltering)
	{
		this.enrollmentListForFiltering = enrollmentListForFiltering;
	}
	
	public String getEvalMode()
	{
		return evalMode;
	}
	
	public void setEvalMode(String evalMode)
	{
		this.evalMode = evalMode;
	}
	
	public Timestamp getCreatedDate()
	{
		return createdDate;
	}
	
	public void setCreatedDate(Timestamp createdDate)
	{
		this.createdDate = createdDate;
	}
	
	public String getFormattedCreatedDate()
	{
		return formattedCreatedDate;
	}
	
	public void setFormattedCreatedDate(String formattedCreatedDate)
	{
		this.formattedCreatedDate = formattedCreatedDate;
	}
	
	public boolean isPrivateGroup()
	{
		return privateGroup;
	}
	
	public void setPrivateGroup(boolean privateGroup)
	{
		this.privateGroup = privateGroup;
	}
	
	public boolean isFibSavedGroup()
	{
		return fibSavedGroup;
	}
	
	public void setFibSavedGroup(boolean fibSavedGroup)
	{
		this.fibSavedGroup = fibSavedGroup;
	}

	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
