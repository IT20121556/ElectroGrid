package com;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML 
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

import model.Customer;

@Path("/Customer")
public class CustomerManage {
	Customer CustomerObj = new Customer();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readCustomer() {
		return CustomerObj.readCustomer();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertCustomer(@FormParam("cusName") String cusName,			
	 @FormParam("cusAddress") String cusAddress,
	 @FormParam("cusNIC") String cusNIC,
	 @FormParam("cusEmail") String cusEmail,
	 @FormParam("cusPno") String cusPno)
	{
	 String output = CustomerObj.insertCustomer(cusName, cusAddress, cusNIC, cusEmail, cusPno);
	return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateCustomer(String custData)
	{
	//Convert the input string to a JSON object
	 JsonObject cusObject = new JsonParser().parse(custData).getAsJsonObject();
	//Read the values from the JSON object
	 String cusID = cusObject.get("cusID").getAsString();
	 String cusName = cusObject.get("cusName").getAsString();
	 String cusAddress = cusObject.get("cusAddress").getAsString();
	 String cusNIC = cusObject.get("cusNIC").getAsString();
	 String cusEmail = cusObject.get("cusEmail").getAsString();
	 String cusPno = cusObject.get("cusPno").getAsString();
	 String output = CustomerObj.updateCustomer(cusID, cusName, cusAddress, cusNIC, cusEmail, cusPno);
	return output;
	} 
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteCustomer(String custData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(custData, "", Parser.xmlParser());

	//Read the value from the element <ID>
	 String cusID = doc.select("cusID").text();
	 String output = CustomerObj.deleteCustomer(cusID);
	return output;
	}
}
