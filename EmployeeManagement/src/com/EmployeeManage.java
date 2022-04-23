package com;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML 
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

import model.Employee;

@Path("/Employee")
public class EmployeeManage {
	Employee EmployeeObj = new Employee();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readEmployee() {
		return EmployeeObj.readEmployee();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertEmployee(@FormParam("empName") String empName,			
	 @FormParam("empAddress") String empAddress,
	 @FormParam("empNIC") String empNIC,
	 @FormParam("empDOB") String empDOB,
	 @FormParam("empContact") String empContact)
	{
	 String output = EmployeeObj.insertEmployee(empName, empAddress, empNIC, empDOB, empContact);
	return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateEmployee(String empData)
	{
	//Convert the input string to a JSON object
	 JsonObject empObject = new JsonParser().parse(empData).getAsJsonObject();
	//Read the values from the JSON object
	 String empID = empObject.get("empID").getAsString();
	 String empName = empObject.get("empName").getAsString();
	 String empAddress = empObject.get("empAddress").getAsString();
	 String empNIC = empObject.get("empNIC").getAsString();
	 String empDOB = empObject.get("empDOB").getAsString();
	 String empContact = empObject.get("empContact").getAsString();
	 String output = EmployeeObj.updateEmployee(empID, empName, empAddress, empNIC, empDOB, empContact);
	return output;
	} 
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteEmployee(String empData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(empData, "", Parser.xmlParser());

	//Read the value from the element <ID>
	 String empID = doc.select("empID").text();
	 String output = EmployeeObj.deleteEmployee(empID);
	return output;
	}
}
