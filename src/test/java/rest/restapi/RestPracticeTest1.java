package rest.restapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.testng.Assert.assertTrue;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import rest.restapi.util.RestUtil;

public class RestPracticeTest1 {

	String baseUrl="https://api.github.com/users";
	
	
	@Test
	public void resouceExists() throws ClientProtocolException, IOException {

		
		
		HttpGet request=new HttpGet(baseUrl+"/nag");//
		
		
		// send the response or execute the request
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		System.out.println("Content:"+httpResponse.getEntity().getContent().toString());
		BufferedReader rd = new BufferedReader(new InputStreamReader(
				httpResponse.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }

		// Verify the response code is equal to 200
		Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(),HttpStatus.SC_OK);
	}

	
	@Test
	public void resourceDoesnotExist() throws ClientProtocolException, IOException
	{

		HttpGet request=new HttpGet(baseUrl+"/beenamuvvva");//
		
		
		// send the response or execute the request
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		System.out.println("Content:"+httpResponse.getEntity().getContent().toString());
		BufferedReader rd = new BufferedReader(new InputStreamReader(
				httpResponse.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
		// Verify the response code is equal to 200
		Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(),HttpStatus.SC_NOT_FOUND);
	}
	
	@Test
	
	public void testContentType() throws ClientProtocolException, IOException
	{
		HttpGet request=new HttpGet(baseUrl+"/nag");//
		
		
		// send the response or execute the request
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		
		String expectedContentType = "application/json";
		
		String actualContentType = RestUtil.getContentTypeValue(httpResponse);
		System.out.println("Actual:"+actualContentType);
				
		System.out.println("Content:"+httpResponse.getEntity().getContent().toString());
		BufferedReader rd = new BufferedReader(new InputStreamReader(
				httpResponse.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
		assertTrue(actualContentType.contains(expectedContentType));
		
	}
}
