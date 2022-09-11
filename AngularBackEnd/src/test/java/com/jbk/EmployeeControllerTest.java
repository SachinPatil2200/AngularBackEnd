package com.jbk;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class EmployeeControllerTest {
	
	@Test
	public void getEmployeeByIdTest() throws URISyntaxException{
		RestTemplate r =new RestTemplate();
		URI u= new URI("http://localhost:8080/employee/getEmployeeById/1");
		ResponseEntity<String> result=r.getForEntity(u,String.class );
		System.out.println(result);
		Assertions.assertEquals(302, result.getStatusCodeValue());
	}

}
