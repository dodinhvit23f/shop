package com.shop.common;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Base64;

import com.fasterxml.jackson.annotation.JsonInclude.Include;	
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Utility {
    private static ObjectMapper mapper;

    public static String toJson(Object object) throws JsonProcessingException {
	if (object == null) {
	    return "";
	}
	if (mapper == null) {
	    setMapper();
	}
	return mapper.writeValueAsString(object);
    }

    public static <DATA> DATA fromJson(String jsonString, Class<DATA> classFormat)
	    throws Exception, JsonMappingException, IOException {
	if (jsonString == null || classFormat == null) {
	    return null;
	}
	if (mapper == null) {
	    setMapper();
	}
	return mapper.readValue(jsonString, classFormat);
    }

    public static void setMapper() {
	mapper = new ObjectMapper();
	/**
	 * ignore unknown fields
	 */
	mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	/**
	 * ignore null fields
	 */
	mapper.setSerializationInclusion(Include.NON_NULL);
	/**
	 * ignore if beans is empty
	 */
	mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }
    
    public static void  validateSpace(String string) {
	string.trim().replaceAll("\\s+"," ");
    }
    
    public static byte[] stringToByte(String string) {
	if(string ==  null || string.isEmpty()) {
	    string = "";
	} else {
	    validateSpace(string);
	}	
	
	return string.getBytes(Charset.forName(Constants.Charset.UTF8));
    }
    
    public static String stringToBase64(String string) {
	return  Base64.getEncoder().encodeToString(stringToByte(string));
    }
    
    public static String base64ToString (String string) {
	byte[] data = Base64.getDecoder().decode(string);
	if(data == null) {
	    return "";
	}
	
	return  new String(data,Charset.forName(Constants.Charset.UTF8));
    }
    
    public static void initializeClass( Class<?> clazz) throws InstantiationException, IllegalAccessException {
	clazz.newInstance();
    }
}
