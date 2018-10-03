package com.acme.acmetrade.endpoints;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.acme.acmetrade.TradeApplication;
import com.acme.acmetrade.domain.Sector;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = { TradeApplication.class })
public class MarketSectorEndpointTest {

	@LocalServerPort
	private int serverPort;

	@Before
	public void init() {
		RestAssured.port = serverPort;
	}

	@Test
	@Sql(scripts= {"classpath:/schema.sql", "classpath:/data.sql"})
	public void allSectorsReturned() {
		Response response =  given().accept(MediaType.APPLICATION_JSON_VALUE)
		.when().get("/sectors")
		.then().statusCode(HttpStatus.SC_OK)
		.and().extract().response(); 
		
		Sector[] jsonResponse = response.as(Sector[].class); 
		assertThat(jsonResponse.length, equalTo(2));
	}

}