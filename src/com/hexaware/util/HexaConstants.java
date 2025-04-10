package com.hexaware.util;

public class HexaConstants {
	
	public static final String EMP_NOT_FOUND="Employee not found";
	public static final String EMP_EXISTS="Employee ID exists";
	public static final String DELIMITER = ",";
	public static final String DB_FILE_NAME = "src/hexadb.properties";
	public static final String DB_DRIVER = "driver";
	public static final String DB_URL="dbUrl";
	public static final String CANNOT_OPEN_CONNECTION = "Connection cannot be opened.";
	
	//in toString()
	public static final String CLIENT_EXISTS_EXCEPTION = "Client Already Exists";
	public static final String POLICY_NOT_FOUND_EXCEPTION = "Policy Not Found Exception";
	
	 // DB Table Columns - Policy
    public static final String POLICY_ID = "policy_id";
    public static final String POLICY_NAME = "policy_name";
    public static final String POLICY_AMT = "policy_amt";
    public static final String POLICY_COVERAGE_AMT = "policy_coverage_amt";
    public static final String POLICY_DURATION = "policy_duration";

    // DB Table Columns - Client
    public static final String CLIENT_ID = "client_id";
    public static final String CLIENT_NAME = "client_name";
    public static final String CONTACT_NO = "contact_no";
    public static final String CLIENT_POLICY_ID = "policy_id";

    // SQL Query Constants
    public static final String ADD_POLICY_QRY = 
        "INSERT INTO policy (policy_id, policy_amt, policy_name, policy_coverage_amt, policy_duration) VALUES (?, ?, ?, ?, ?)";

    public static final String GET_POLICY_BY_CLIENT_ID_QRY = 
    	    "SELECT p.* FROM policy p JOIN client c ON p.policy_id = c.policy_id WHERE c.client_id = ?";

    public static final String GET_ALL_POLICIES_QRY = 
    	    "SELECT p.policy_id, p.policy_amt, p.policy_name, p.policy_coverage_amt, p.policy_duration, " +
    	    "c.client_id, c.client_name, c.contact_no " +
    	    "FROM policy p LEFT JOIN client c ON p.policy_id = c.policy_id";


    public static final String ADD_CLIENT_QRY = 
        "INSERT INTO client (client_id, client_name, contact_no, policy_id) VALUES (?, ?, ?, ?)";

    public static final String CHECK_CLIENT_EXISTS_QRY = 
        "SELECT * FROM client WHERE client_id = ?";

    // Prompt Messages
    public static final String PROMPT_POLICY_ID = "Enter policy ID: ";
    public static final String PROMPT_POLICY_NAME = "Enter policy name: ";
    public static final String PROMPT_POLICY_AMT = "Enter policy amount: ";
    public static final String PROMPT_POLICY_COVERAGE = "Enter coverage amount: ";
    public static final String PROMPT_POLICY_DURATION = "Enter policy duration (in years): ";
    
    public static final String PROMPT_CLIENT_ID = "Enter client ID: ";
    public static final String PROMPT_CLIENT_NAME = "Enter client name: ";
    public static final String PROMPT_CONTACT_NO = "Enter contact number: ";
    public static final String PROMPT_CLIENT_POLICY_ID = "Enter associated policy ID: ";
    
    public static final String ERROR_POLICY_Id_RETRIEVING = "Error retrieving policy by client ID";
    public static final String ERROR_POLICY_NOT_FOUND = "No policies found";
    public static final String ACC_ADD_SUCCESSFUL = "Account Edited Successfully";
    }