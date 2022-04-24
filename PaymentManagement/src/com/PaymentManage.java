package com;

import model.Payment;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML 
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Payment")
public class PaymentManage {
	Payment PaymentObj = new Payment();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readPayment() {
		return PaymentObj.readPayment();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPayment(@FormParam("pAccNo") String pAccNo, 
			@FormParam("pCus") String pCus,
			@FormParam("pDate") String pDate,
			@FormParam("pAmount") String pAmount) {
		String output = PaymentObj.insertPayment(pAccNo,pCus, pDate, pAmount);
		return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)

	public String updatePayment(String paymentData) {
		// Convert the input string to a JSON object
		JsonObject PayObject = new JsonParser().parse(paymentData).getAsJsonObject();

		// Read the values from the JSON object
		String pID = PayObject.get("pID").getAsString();
		String pAccNo = PayObject.get("pAccNo").getAsString();
		String pCus = PayObject.get("pCus").getAsString();
		String pDate = PayObject.get("pDate").getAsString();
		String pAmount = PayObject.get("pAmount").getAsString();
		
		String output = PaymentObj.updatePayment(pID, pAccNo, pCus, pDate, pAmount);
		return output;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePayment(String paymentData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(paymentData, "", Parser.xmlParser());

		// Read the value from the element
		String pID = doc.select("pID").text();
		String output = PaymentObj.deletePayment(pID);
		return output;
	}
}
