package com.example.helloworldrevservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceInvoker {

	
	@Autowired
    RestTemplate restTemplate;
     
    public JsonMessage getMessage() 
    {
    	JsonMessage response = null;
    	ResponseEntity<JsonMessage> responseEntity = null;
		try {
			responseEntity = restTemplate.exchange("http://helloworld-service:8098/message", HttpMethod.GET,
					null, JsonMessage.class);
		} catch(RestClientException ex) {
			ex.printStackTrace();
		}
		
		 if(null != responseEntity && null != responseEntity.getBody()){
	            response = responseEntity.getBody();
	        }
    	
//        String response = restTemplate.exchange("http://localhost:8080/getStudentDetailsForSchool/{schoolname}",HttpMethod.GET, null, new ParameterizedTypeReference<String>() {},schoolname).getBody();
//         
//        System.out.println("Response Received as " + response + " -  " + new Date());
// 
//        return "School Name -  " + schoolname + " :::  Student Details " + response + " -  " + new Date();
		 return response;
    }
     
    
    @Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
