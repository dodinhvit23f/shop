package com.shop.test;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.shop.common.Utility;
import com.shop.rest.RestHeader;
import com.shop.rest.base.BaseRestCommunication;
import com.shop.rest.base.BaseRestRequest;

/**
 * @author ManhNT - 05/09/2019
 */
public class TestRestClient {
    public static void main(String[] args) throws InterruptedException {
	TestRestClient client = new TestRestClient();
	client.test();
    }

    public void test() {
	// for(int i =0 ; i<1000 ;i++)
	try {
	    HttpHeaders headers = new HttpHeaders();

	    headers.setContentType(MediaType.APPLICATION_JSON);

	    /*
	     * RestHeader restHeader = new RestHeader();
	     * restHeader.setClientAddress("127.0.0.1");
	     * restHeader.setClientRequestId("1234567");
	     * restHeader.setDeviceId("abc-123-def-456"); restHeader.setChannelCode("SDK");
	     * //restHeader.setLanguage(Constants.Languages.VIETNAMESE);
	     * restHeader.setPlatform("local"); restHeader.setSdkId("123");
	     */

//			Location location = new Location();
//			location.setLatitude("3");
//			location.setLongitude("4");
//			restHeader.setLocation(location);

	    RestHeader restHeader = new RestHeader();

	    BaseRestRequest request = new BaseRestRequest();
	    request.setReceiTime(1l);

	    String json = Utility.toJson(request);

	    // tạo request
	    BaseRestCommunication requestObject = new BaseRestCommunication();
	    requestObject.setBody(Utility.stringToBase64(json));
	    requestObject.setHeader(restHeader);

	    String restRequestValue = Utility.toJson(requestObject);

	    HttpEntity<String> requestclient = new HttpEntity<String>(restRequestValue, headers);

	    String url = "http://localhost:7777/product/req";

	    RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
	    restTemplateBuilder.setConnectTimeout(Duration.ofSeconds(30));
	    restTemplateBuilder.setReadTimeout(Duration.ofSeconds(30));

	    RestTemplate restTemplate = restTemplateBuilder.build();

	    // String restResponseValue = restTemplate.postForObject(url, request,
	    // String.class);
	    // System.out.println(restResponseValue);
	    // DefaultRestResponse response = JsonUtility.fromJson(restResponseValue,
	    // DefaultRestResponse.class);

	    ResponseEntity<BaseRestCommunication> response = restTemplate.postForEntity(url, requestclient,
		    BaseRestCommunication.class);
	    BaseRestCommunication defaultResponse = response.getBody();
	    System.out.println(defaultResponse.getBody());

	    String decodedBody = Utility.base64ToString(defaultResponse.getBody());
	    System.out.println(decodedBody);
	    // AreaResponse restResponse = JsonUtility.fromJson(decodedBody,
	    // AreaResponse.class);
	    // ParamResponse restResponse = JsonUtility.fromJson(decodedBody,
	    // ParamResponse.class);
	    // ProviderResponse restResponse = JsonUtility.fromJson(decodedBody,
	    // ProviderResponse.class);
	    // BranchResponse restResponse = JsonUtility.fromJson(decodedBody,
	    // BranchResponse.class);
	    // System.out.println(" \n Ket qua: " +restResponse.getParamCache().toString());
	    // System.out.println(" \n Ket qua: " + restResponse.toString());

	    // Thread.sleep(500);
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }
}
