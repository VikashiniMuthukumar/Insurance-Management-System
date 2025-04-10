package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.entity.Client;
import com.hexaware.entity.Policy;
import com.hexaware.exception.ClientExistsException;
import com.hexaware.exception.DbConnectionException;
import com.hexaware.exception.PolicyNotFoundException;
import com.hexaware.util.DbConnectionUtil;
import com.hexaware.util.HexaConstants;

public class PolicyServiceImpl implements IPolicyService {

    @Override
    public void createpolicyForCustomer(Client client) throws PolicyNotFoundException, ClientExistsException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = DbConnectionUtil.getDbConnection();
            st = conn.prepareStatement(HexaConstants.CHECK_CLIENT_EXISTS_QRY);
            st.setInt(1, client.getClientId());
            rs = st.executeQuery();

            if (rs.next()) {
                throw new ClientExistsException(HexaConstants.CLIENT_EXISTS_EXCEPTION);
            }
            rs.close();
            st.close();

 
            st = conn.prepareStatement(HexaConstants.CHECK_CLIENT_EXISTS_QRY);
            st.setInt(1, client.getPolicy().getPolicyId());
            rs = st.executeQuery();

            if (!rs.next()) {
                throw new PolicyNotFoundException(HexaConstants.POLICY_NOT_FOUND_EXCEPTION);
            }
            rs.close();
            st.close();


            st = conn.prepareStatement(HexaConstants.ADD_CLIENT_QRY);
            st.setInt(1, client.getClientId());
            st.setString(2, client.getClientName());
            st.setString(3, client.getContactNo());
            st.setInt(4, client.getPolicy().getPolicyId());

            st.executeUpdate();

        } catch (SQLException | DbConnectionException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DbConnectionUtil.closeConnection(conn);
        }
    }

    @Override
    public Policy getPolicyById(int clientId) throws PolicyNotFoundException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = DbConnectionUtil.getDbConnection();
            st = conn.prepareStatement(HexaConstants.GET_POLICY_BY_CLIENT_ID_QRY);
            st.setInt(1, clientId);
            rs = st.executeQuery();

            if (rs.next()) {
                return new Policy(
                    rs.getInt(HexaConstants.POLICY_ID),
                    rs.getDouble(HexaConstants.POLICY_AMT),
                    rs.getString(HexaConstants.POLICY_NAME),
                    rs.getDouble(HexaConstants.POLICY_COVERAGE_AMT),
                    rs.getInt(HexaConstants.POLICY_DURATION)
                );
            } else {
                throw new PolicyNotFoundException(HexaConstants.POLICY_NOT_FOUND_EXCEPTION);
            }

        } catch (SQLException | DbConnectionException e) {
            throw new PolicyNotFoundException(HexaConstants.ERROR_POLICY_Id_RETRIEVING , e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DbConnectionUtil.closeConnection(conn);
        }
    }


    @Override
    public List<Policy> getAllPolicies() throws PolicyNotFoundException {
    	    List<Policy> plist = new ArrayList<>();
    	    Connection conn = null;
    	    PreparedStatement st = null;
    	    ResultSet rs = null;

    	    try {
    	        conn = DbConnectionUtil.getDbConnection();
    	        st = conn.prepareStatement(HexaConstants.GET_ALL_POLICIES_QRY);
    	        rs = st.executeQuery();

    	        boolean anyFound = false;

    	        while (rs.next()) {
    	            anyFound = true;

    	            int policyId = rs.getInt(HexaConstants.POLICY_ID);
    	            String policyName = rs.getString(HexaConstants.POLICY_NAME);
    	            double policyAmt = rs.getDouble(HexaConstants.POLICY_AMT);
    	            double coverageAmt = rs.getDouble(HexaConstants.POLICY_COVERAGE_AMT);
    	            int duration = rs.getInt(HexaConstants.POLICY_DURATION);

    	            // If client is joined:
    	            int clientId = rs.getInt(HexaConstants.CLIENT_ID);
    	            String clientName = rs.getString(HexaConstants.CLIENT_NAME);
    	            String contactNo = rs.getString(HexaConstants.CONTACT_NO);

    	            System.out.println("Policy ID: " + policyId + ", Name: " + policyName);
    	            System.out.println("  -> Client ID: " + clientId + ", Name: " + clientName + ", Contact: " + contactNo);
    	        }

    	        if (!anyFound) {
    	            throw new PolicyNotFoundException(HexaConstants.ERROR_POLICY_NOT_FOUND);
    	        }

    	    } catch (SQLException | DbConnectionException e) {
    	        e.printStackTrace();
    	    } finally {
    	        DbConnectionUtil.closeConnection(conn);
    	    }

    	    return plist;
    	}
}
