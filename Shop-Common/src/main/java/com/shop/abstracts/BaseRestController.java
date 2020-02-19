package com.shop.abstracts;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shop.common.Utility;
import com.shop.interfaces.RestController;
import com.shop.rest.RestHeader;
import com.shop.rest.base.BaseRestCommunication;
import com.shop.rest.base.BaseRestRequest;
import com.shop.rest.base.BaseRestRespond;

public abstract class BaseRestController<REQ extends BaseRestRequest, REP extends BaseRestRespond>
		implements RestController<REQ, REP> {
	private Class<REQ> clazzRequest;
	private Class<REP> clazzResponse;

	@Autowired
	private MessageSource message;

	public BaseRestController(Class<REQ> clazzRequest, Class<REP> clazzResponse) {
		this.clazzRequest = clazzRequest;
		this.clazzResponse = clazzResponse;
	}

	public abstract boolean validateRequest(REQ restRequest, REP response);

	public abstract REP process(REQ restRequest, RestHeader header);

	private REQ buildRequest(String string) {
		String afterDecode = Utility.base64ToString(string);

		REQ restRequest = null;
		try {
			restRequest = Utility.fromJson(afterDecode, this.clazzRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return restRequest;
	}

	private BaseRestCommunication buildResponse(REP response, RestHeader header, long start) {
		BaseRestCommunication restResponse = new BaseRestCommunication();
		String endcode = null;
		response.setReplyTime(System.currentTimeMillis() - start);

		try {
			endcode = Utility.stringToBase64(Utility.toJson(response));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		restResponse.setBody(endcode);
		restResponse.setHeader(header);
		return restResponse;
	}

	private RestHeader buildHeader() {
		RestHeader header = new RestHeader();
		header.setLanguage("VN");
		return header;
	}

	public String getMassageDesc(String code, String country) {
		if (country == null || country.isEmpty()) {
			country = "vn";
		}
		String desc = null;
		try {
			desc = this.message.getMessage(code, new Object[0], new Locale(country));
		} catch (Exception e) {
			desc = "";
		}
		return desc;
	}

	@Override
	public String restChecking() {
		return " API is WORKKING";
	}

	@RequestMapping(value = "req", method = RequestMethod.POST)
	public ResponseEntity<BaseRestCommunication> restRequest(HttpServletRequest httpRequest,
			@RequestHeader HttpHeaders headers, @RequestBody BaseRestCommunication request) {

		long start = System.currentTimeMillis();

		return this.baseProcess(headers, request, start);
	}

	@RequestMapping(value = "send", method = RequestMethod.POST, produces = "application/json")
	public String seeRequest(String json) {
		return json;
	}

	private ResponseEntity<BaseRestCommunication> baseProcess(HttpHeaders headers, BaseRestCommunication request,
			long start) {
		// HttpServletRequest show we httpRequest send by json or xml
		// HttpHeaders show we watch many kinds of charset
		BaseRestCommunication restResponse = null;
		REP response = null;
		try {
			response = clazzResponse.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		// iniliazed rest Request
		REQ restRequest = this.buildRequest(request.getBody());
		// iniliazed rest header to response 
		RestHeader header = this.buildHeader();

		if (restRequest == null) {
			response.setResponseCode("0001");
			response.setResponseDesc(this.getMassageDesc("0001", "vn"));
			restResponse = this.buildResponse(response, header, start);
			return new ResponseEntity<BaseRestCommunication>(restResponse, HttpStatus.BAD_REQUEST);
		}

		if (!this.validateRequest(restRequest, response)) {
			response.setResponseCode("0001");
			response.setResponseDesc(this.getMassageDesc("0001", "vn"));
			restResponse = this.buildResponse(response, header, start);
			return new ResponseEntity<BaseRestCommunication>(restResponse, HttpStatus.BAD_REQUEST);
		}

		response = this.process(restRequest, header);

		restResponse = this.buildResponse(response, header, start);
		return new ResponseEntity<BaseRestCommunication>(restResponse, HttpStatus.OK);

	}
}
