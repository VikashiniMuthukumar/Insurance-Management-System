package com.hexaware.main;

import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.IPolicyService;
import com.hexaware.entity.Client;
import com.hexaware.entity.Policy;
import com.hexaware.exception.ClientExistsException;
import com.hexaware.exception.PolicyNotFoundException;
import com.hexaware.util.HexaConstants;

public class Main {

	public static Scanner scan = new Scanner(System.in);
	public static IPolicyService dao = IPolicyService.getDaoInstance();

	public static void main(String[] args) {
		String opt = null;
		do {
			handleMenu();
			System.out.println("Press y to continue:");
			opt = scan.next();
		} while (opt.charAt(0) == 'y' || opt.charAt(0) == 'Y');
	}

	public static void handleMenu() {
		System.out.println("1. Add Client with Policy");
		System.out.println("2. View Policy by ID");
		System.out.println("3. View All Policies");
		int menuopt = scan.nextInt();
		switch (menuopt) {
		case 1:
			handleAddClient();
			break;
		case 2:
			handleViewPolicyById();
			break;
		case 3:
			handleViewAllPolicies();
			break;
		default:
			System.out.println("Invalid menu option");
		}
	}

	public static void handleAddClient() {
		System.out.println(HexaConstants.PROMPT_CLIENT_ID);
		int clientId = scan.nextInt();
		System.out.println(HexaConstants.PROMPT_CLIENT_NAME);
		String clientName = scan.next();
		System.out.println(HexaConstants.PROMPT_CONTACT_NO);
		String contactNo = scan.next();
		System.out.println(HexaConstants.PROMPT_CLIENT_POLICY_ID);
		int policyId = scan.nextInt();

		Policy policy = new Policy();
		policy.setPolicyId(policyId);

		Client client = new Client(clientId, clientName, contactNo, policy);

		try {
			dao.createpolicyForCustomer(client);
			System.out.println("Client registered successfully.");
		} catch (ClientExistsException | PolicyNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void handleViewPolicyById() {
		System.out.println(HexaConstants.PROMPT_CLIENT_ID);
		int policyId = scan.nextInt();
		try {
			Policy policy = dao.getPolicyById(policyId);
			display(policy);
		} catch (PolicyNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void handleViewAllPolicies() {
		try {
			List<Policy> policies = dao.getAllPolicies();
			policies.forEach(p -> display(p));
		} catch (PolicyNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void display(Policy policy) {
		System.out.println("Policy ID: " + policy.getPolicyId());
		System.out.println("Policy Name: " + policy.getPolicyName());
		System.out.println("Policy Amount: " + policy.getPolicyAmt());
		System.out.println("Coverage Amount: " + policy.getPolicyCoverageAmt());
		System.out.println("Duration: " + policy.getPolicyDuration() + " years");
		System.out.println("--------------------------------------");
	}
}
