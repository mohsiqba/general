package com.passport.entities;

import java.util.Comparator;
import java.util.Date;

public class Applicant{
	Integer tokenId;
	Date tokenDate;
	Integer applicantId;
	Integer stage;
	public Applicant() {
	}
	
	public Integer getTokenId() {
		return tokenId;
	}

	public void setTokenId(Integer tokenId) {
		this.tokenId = tokenId;
	}

	public Date getTokenDate() {
		return tokenDate;
	}

	public void setTokenDate(Date tokenDate) {
		this.tokenDate = tokenDate;
	}

	public Integer getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}

	public Integer getStage() {
		return stage;
	}

	public void setStage(Integer stage) {
		this.stage = stage;
	}

	public static Comparator<Applicant> getTokenIdComparator() {
		return tokenIdComparator;
	}

	public static void setTokenIdComparator(Comparator<Applicant> tokenIdComparator) {
		Applicant.tokenIdComparator = tokenIdComparator;
	}

	public static Comparator<Applicant> getTokenDateComparator() {
		return tokenDateComparator;
	}

	public static void setTokenDateComparator(Comparator<Applicant> tokenDateComparator) {
		Applicant.tokenDateComparator = tokenDateComparator;
	}

	public Applicant(Integer applicantId,Integer stage,Integer tokenId,Date tokenDate) {
		this.applicantId=applicantId;
		this.tokenId=tokenId;
		this.stage=stage;
		this.tokenDate=tokenDate;
	}

	public static Comparator<Applicant> tokenIdComparator = new Comparator<Applicant>() {

        @Override
        public int compare(Applicant c1, Applicant c2) {
        	 return c1.tokenId.compareTo(c2.tokenId);
        }
    };
    
	public static Comparator<Applicant> tokenDateComparator = new Comparator<Applicant>() {

        @Override
        public int compare(Applicant c1, Applicant c2) {
        	return c2.tokenDate.compareTo(c1.tokenDate);
        }
    };

	public static Comparator<Applicant> randomComparator = new Comparator<Applicant>() {

        @Override
        public int compare(Applicant c1, Applicant c2) {
        	return 0;
        }
    };
    public String toString() {
    	StringBuilder sb=new StringBuilder();
    	sb.append("[tokenId").append(tokenId);
    	sb.append("|tokenDate").append(tokenDate);
    	sb.append("|applicantId").append(applicantId);
    	sb.append("|stage").append(stage).append("]");
    	return sb.toString();
    }
}
