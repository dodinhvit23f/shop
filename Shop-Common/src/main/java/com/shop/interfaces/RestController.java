package com.shop.interfaces;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.rest.base.BaseRestCommunication;

public interface RestController<REQ, REP> {

    @RequestMapping(value = "req" , method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> restRequest(HttpServletRequest httpRequest, @RequestHeader HttpHeaders headers,
		@RequestBody BaseRestCommunication request);

    @RequestMapping(value ="def", method = RequestMethod.GET)
    public String restChecking();

}
