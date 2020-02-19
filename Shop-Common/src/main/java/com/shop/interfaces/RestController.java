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

    @RequestMapping(value = "info" , method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> restRequest(HttpServletRequest httpRequest, @RequestHeader HttpHeaders headers,
		@RequestBody BaseRestCommunication request);

    @RequestMapping(value ="def", method = RequestMethod.GET)
    public String restChecking();
    
    @RequestMapping(value ="add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> restRequestInsert (HttpServletRequest httpRequest, @RequestHeader HttpHeaders headers,
    		@RequestBody BaseRestCommunication request);
    
    @RequestMapping(value ="change", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> restRequestUpdate (HttpServletRequest httpRequest, @RequestHeader HttpHeaders headers,
    		@RequestBody BaseRestCommunication request);
    
    @RequestMapping(value ="remove", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> restRequestDelete (HttpServletRequest httpRequest, @RequestHeader HttpHeaders headers,
    		@RequestBody BaseRestCommunication request);

}
