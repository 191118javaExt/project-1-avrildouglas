package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Reimburse;
import com.revature.models.ReimburseTemplate;
import com.revature.util.ConnectionUtil;

public class ReimburseDAOImpl implements ReimburseDAO {
	
	private static Logger logger = LogManager.getLogger(ReimburseDAOImpl.class);
	
	
@Override
	public List<Reimburse> findAll() {
		
		List<Reimburse> list = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM reimbursedb.reimburse;";

			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
	
			while(rs.next()) {
				int reim_id = rs.getInt("reim_id");
				String submit_by = rs.getString("submit_by");
				Double reim_amt = rs.getDouble("reim_amt");
				String reim_type = rs.getString("reim_type");
				String reim_descr = rs.getString("reim_descr");
				Date submit_dte = rs.getDate("submit_dte");
				String reim_recpt = rs.getString("reim_recpt");
				String reim_stat = rs.getString("reim_stat");
				Date process_dte = rs.getDate("process_dte");
				String process_by = rs.getString("process_by");
				String user_name = rs.getString("user_name");
			
				
				Reimburse r = new Reimburse(reim_id, submit_by, reim_amt, reim_type, reim_descr, submit_dte, reim_recpt, reim_stat, process_dte, process_by, user_name);
					
				list.add(r);
			}
			
			rs.close();
		} catch(SQLException e) {
			logger.warn("Unable to retrieve all reimbursements", e);
		}
		return list;
	}



	@Override
	public Reimburse findById(int reim_id) {
		
		return null;
	}

	@Override
	public boolean insert(Reimburse r) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "INSERT INTO reimbursedb.reimburse (submit_by, reim_amt, reim_type, reim_descr, submit_dte, reim_recpt, reim_stat, process_dte, process_by, user_name) " +
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, r.getSubmit_by());
			stmt.setDouble(2, r.getReim_amt());
			stmt.setString(3, r.getReim_type());
			stmt.setString(4, r.getReim_descr());
			stmt.setDate(5, (java.sql.Date) r.getSubmit_dte());
			stmt.setString(6, r.getReim_recpt());
			stmt.setString(7, r.getReim_stat());
			stmt.setDate(8, (java.sql.Date) r.getProcess_dte());
			stmt.setString(9, r.getProcess_by());
			stmt.setString(10,  r.getUser_name());
			
			if(!stmt.execute()) {
				return false;
			}
		} catch(SQLException ex) {
			logger.warn("Unable to retrieve all reimbursements", ex);
			return false;
		}
		
		return true;
	}

	@Override
	public boolean update(Reimburse r) {
		// TODO Auto-generated method stub
		return false;
	}

}