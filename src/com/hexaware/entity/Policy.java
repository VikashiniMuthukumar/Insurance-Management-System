package com.hexaware.entity;

import java.util.Objects;

import com.hexaware.util.HexaConstants;

public class Policy {
    private int policyId;
    private double policyAmt;
    private String policyName;
    private double policyCoverageAmt;
    private int policyDuration;

    public Policy() {
    	
    }

	
	public Policy(int policyId, double policyAmt, String policyName, double policyCoverageAmt, int policyDuration) {
		super();
		this.policyId = policyId;
		this.policyAmt = policyAmt;
		this.policyName = policyName;
		this.policyCoverageAmt = policyCoverageAmt;
		this.policyDuration = policyDuration;
	}


	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public double getPolicyAmt() {
		return policyAmt;
	}

	public void setPolicyAmt(double policyAmt) {
		this.policyAmt = policyAmt;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public double getPolicyCoverageAmt() {
		return policyCoverageAmt;
	}

	public void setPolicyCoverageAmt(double policyCoverageAmt) {
		this.policyCoverageAmt = policyCoverageAmt;
	}

	public int getPolicyDuration() {
		return policyDuration;
	}

	public void setPolicyDuration(int policyDuration) {
		this.policyDuration = policyDuration;
	}

	@Override
	public String toString() {
		return HexaConstants.POLICY_NOT_FOUND_EXCEPTION;
	}

	@Override
	public int hashCode() {
		return Objects.hash(policyAmt, policyCoverageAmt, policyDuration, policyId, policyName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Policy other = (Policy) obj;
		return Double.doubleToLongBits(policyAmt) == Double.doubleToLongBits(other.policyAmt)
				&& Double.doubleToLongBits(policyCoverageAmt) == Double.doubleToLongBits(other.policyCoverageAmt)
				&& policyDuration == other.policyDuration && policyId == other.policyId
				&& Objects.equals(policyName, other.policyName);
	}
	
	
    
    
    
}
