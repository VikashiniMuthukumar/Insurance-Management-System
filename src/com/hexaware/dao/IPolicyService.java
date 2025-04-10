package com.hexaware.dao;

import java.util.List;

import com.hexaware.entity.Client;
import com.hexaware.entity.Policy;
import com.hexaware.exception.ClientExistsException;
import com.hexaware.exception.PolicyNotFoundException;

public interface IPolicyService {
	
	void createpolicyForCustomer(Client client) throws PolicyNotFoundException, ClientExistsException;
	Policy getPolicyById(int policyId) throws PolicyNotFoundException;
	List<Policy> getAllPolicies() throws PolicyNotFoundException;
 
	static IPolicyService getDaoInstance() {
		IPolicyService dao = new PolicyServiceImpl();
		return dao;
	}
}
