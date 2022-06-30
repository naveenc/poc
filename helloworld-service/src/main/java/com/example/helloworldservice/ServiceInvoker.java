package com.example.helloworldservice;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceInvoker {

	
	@Autowired
    RestTemplate restTemplate;
     
    public String callStudentServiceAndGetData(String schoolname) 
    {
        System.out.println("Consul Demo - Getting School details for " + schoolname);
 
        String response = restTemplate.exchange("http://localhost:8080/getStudentDetailsForSchool/{schoolname}",                                       HttpMethod.GET, null, new ParameterizedTypeReference<String>() {},                                                schoolname).getBody();
         
        System.out.println("Response Received as " + response + " -  " + new Date());
 
        return "School Name -  " + schoolname + " :::  Student Details " + response + " -  " + new Date();
    }
     
    
    @Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
