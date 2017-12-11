/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cabletv.app.serviceaccess;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.PropertySource;
import com.cabletv.app.service.api.*;
import com.cabletv.service.wrappers.*;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import com.google.gson.Gson;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import org.apache.http.client.ClientProtocolException;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
/**
 *
 * @author Kumaran
 */
@Component("cableTvServiceAccess")
@Service
@PropertySource("classpath:/config/serviceaccess/common_serviceaccess.properties")
public class CableTvServiceAccess {
    
    @Value("${hostportname}")
    private String hostportname;
    
    @Value("${endpoint}")
    private String endpoint;
    
    Gson gson = new Gson();
    
   // @Autowired
   // private CustomerService customerService;
    
   //  CustomerService customerService ; //= new CustomerService();
    public String  getAllCust() {
        
              ObjectMapper mapper = new ObjectMapper();String n=null;
        System.out.println("com.cabletv.app.serviceaccess.CableTvServiceAccess.getAllCust()"+hostportname);
       try {
       URL url = new URL("http://localhost:8080/CableTvServiceApp/customerServiceRest/custapp/getcustall.json");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
                
                CustomerServiceResponseList obj = mapper.readValue(br, CustomerServiceResponseList.class);//gson.fromJson(br, CustomerServiceResponseList.class);
		System.out.println("Output from Server .... \n"+ obj.getCustomer().get(0).getCustomerName());
//		e.printStackTrace();
n = obj.getCustomer().get(0).getCustomerName();

	  } catch (IOException e) {

		e.printStackTrace();

	  }
       return n;
    }
    
    
 
}
