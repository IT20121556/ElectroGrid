package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Employee {

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/electricitypower?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String insertEmployee(String empName, String empAddress, String empNIC, String empDOB, String empContact) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into empmanage(`empID`,`empName`,`empAddress`,`empNIC`,`empDOB`,`empContact`)"
					+ " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, empName);
			preparedStmt.setString(3, empAddress);
			preparedStmt.setString(4, empNIC);
			preparedStmt.setString(5, empDOB);
			preparedStmt.setString(6, empContact);
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the employee.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readEmployee() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Employee ID</th><th>Employee Name</th><th>Address</th><th>NIC</th><th>Date Of Birth</th><th>Contact No</th></tr>";
			String query = "select * from empmanage";
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String empID = Integer.toString(rs.getInt("empID"));
				String empName = rs.getString("empName");
				String empAddress = rs.getString("empAddress");
				String empNIC = rs.getString("empNIC");
				String empDOB = rs.getString("empDOB");
				String empContact = rs.getString("empContact");

				// Add into the html table
				output += "<tr><td>" + empID + "</td>";
				output += "<td>" + empName + "</td>";
				output += "<td>" + empAddress + "</td>";
				output += "<td>" + empNIC + "</td>";
				output += "<td>" + empDOB + "</td>";
				output += "<td>" + empContact + "</td>";
				
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the employee.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateEmployee(String empID, String empName, String empAddress, String empNIC, String empDOB, String empContact) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE empmanage SET empName=?,empAddress=?,empNIC=?,empDOB=?,empContact=?" + "WHERE empID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, empName);
			preparedStmt.setString(2, empAddress);
			preparedStmt.setString(3, empNIC);
			preparedStmt.setString(4, empDOB);
			preparedStmt.setString(5, empContact);
			preparedStmt.setInt(6, Integer.parseInt(empID));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the employee.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String deleteEmployee(String empID) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from empmanage where empID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(empID));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the employee.";
			System.err.println(e.getMessage());
		}

		return output;
	}

}
