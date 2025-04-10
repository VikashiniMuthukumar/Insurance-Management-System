package com.hexaware.entity;

import java.util.Objects;

public class Client {
    private int clientId;
    private String clientName;
    private String contactNo;
    private Policy policy;  
    
    public Client(int clientId, String clientName, String contactNo, Policy policy) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.contactNo = contactNo;
		this.policy = policy;
	}

	public Client() {
    	
    }

	public int getClientId() {
		return clientId;
	}


	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}


	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + ", contactNo=" + contactNo + ", policy="
				+ policy + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(clientId, clientName, contactNo, policy);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return clientId == other.clientId && Objects.equals(clientName, other.clientName)
				&& Objects.equals(contactNo, other.contactNo) && Objects.equals(policy, other.policy);
	}
	
	
    
}
