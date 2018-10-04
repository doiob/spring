package com.acme.acmetrade.endpoints;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.acme.acmetrade.TradeApplication;

import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = { TradeApplication.class })
public class SecurityEndpointTest {

	@LocalServerPort
	private int serverPort;

	@Before
	public void init() {
		RestAssured.port = serverPort;

	}
	
	@Test
	public void getAllSecurites() {
		
	}


}
