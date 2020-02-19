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

	public static void validateSpace(String string) {
		string.trim().replaceAll("\\s+", " ");
	}

	public static String remove(String str, char[] character, boolean single) {
		/**
		 * remove single charecter or mutil characters out of range
		 */
		int number = character.length;
		int last;
		if (!single && number % 2 != 0)
			return str;
		else
			last = number - 1;
		StringBuilder buildString = new StringBuilder(str);

		for (int index = 0; index < buildString.length(); index++) {
			char temp = buildString.charAt(index);
			for (int j = 0; j < number; j++) {
				if (single) {
					if (Character.compare(temp, character[j]) == 0) {
						buildString.deleteCharAt(index--);
						break;
					}
				} else {
					if (j < last && (Character.compare(temp, character[j]) < 0
							|| Character.compare(temp, character[j + 1]) > 0)) {
						buildString.deleteCharAt(index--);
						break;
					}
				}
			}

		}

		return buildString.toString();
	}

	public static String validateString(String string) {
		if (string == null || string.isEmpty()) {
			return "";
		}

		validateSpace(string);

		return string;
	}

	public static byte[] stringToByte(String string) {
		if (string == null || string.isEmpty()) {
			string = "";
		} else {
			validateSpace(string);
		}

		return string.getBytes(Charset.forName(Constants.Charset.UTF8));
	}

	public static String stringToBase64(String string) {
		return Base64.getEncoder().encodeToString(stringToByte(string));
	}

	public static String base64ToString(String string) {
		byte[] data = Base64.getDecoder().decode(string);
		if (data == null) {
			return "";
		}

		return new String(data, Charset.forName(Constants.Charset.UTF8));
	}

	public static void initializeClass(Class<?> clazz) throws InstantiationException, IllegalAccessException {
		clazz.newInstance();
	}

	public static void main(String[] args) {
		String string = "a@b2-_   caaaa";
		String remove = "Az";
		System.out.println(remove(string, remove.toCharArray(), false));
	}
}
