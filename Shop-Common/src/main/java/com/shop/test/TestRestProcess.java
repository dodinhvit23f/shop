/*
 * package com.shop.test;
 * 
 * import java.util.Locale;
 * 
 * import javax.servlet.http.HttpServletRequest;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.MessageSource; import
 * org.springframework.http.HttpHeaders; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestHeader; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.shop.rest.BaseRestCommunication;
 * 
 * @RestController
 * 
 * @RequestMapping(value = "test") public class TestRestProcess {
 * 
 * @Autowired MessageSource message;
 * 
 * @RequestMapping(value = "send", method = RequestMethod.POST, produces =
 * "application/json") public String seeRequest(@RequestBody String json) {
 * return message.getMessage("0001", new Object[0], new Locale("_vn")); }
 * 
 * @RequestMapping(value = "req", method = RequestMethod.POST) public
 * BaseRestCommunication restRequest(HttpServletRequest
 * httpRequest, @RequestHeader HttpHeaders headers,
 * 
 * @RequestBody BaseRestCommunication request) {
 * System.out.println(httpRequest.toString());
 * System.out.println(headers.toString());
 * System.out.println(request.getBody().toString()); BaseRestCommunication
 * response = new BaseRestCommunication(); response.setBody(request.toString());
 * return null; } }
 */