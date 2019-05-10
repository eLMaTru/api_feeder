
package com.hht.api.feeder.utils;

import java.io.StringReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.xml.sax.InputSource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hht.api.feeder.dto.ErrorDto;

/**
 * @author Jorge De Los Santos
 * @Version 1.1
 * @Since May 5, 2019
 */
public class Utils {

	/**
	 * The constant logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);

	/** The resource. */
	private static String resource;

	/**
	 * Constructor
	 */
	private Utils() {
	}

	/**
	 * Parses a string with XML format to validate if format is correct.
	 *
	 * @param xmlString the string to be tested.
	 * @return true if the string matches the XML format; false otherwise.
	 */
	public static boolean matchesXMLFormat(String xmlString) {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilderFactory.newDocumentBuilder().parse(new InputSource(new StringReader(xmlString)));
			return true;
		} catch (Exception exception) {
			LOGGER.warn(exception.getMessage());
		}
		return false;
	}

	/**
	 * Method that returns a list of errors from a ConstraintViolations set with
	 * descriptions
	 * 
	 * @param constraintViolations, the violations
	 * @param <T>, the generic element
	 * @param resource, the resource
	 * @return <T> List<ErrorDto>
	 */
	public static <T> List<ErrorDto<?>> getErrorsFromConstraintViolations(
			Set<ConstraintViolation<?>> constraintViolations, String resource) {
		Utils.resource = resource;

		return constraintViolations.stream().map(Utils::getErrorsFromConstraintViolation).collect(Collectors.toList());
	}

	/**
	 * Method that returns an error from a ConstraintViolation object
	 * 
	 * @param constraintViolation, the violation
	 * @param <T>, the generic element
	 * @return <T> ErrorDto
	 */
	public static <T> ErrorDto<String> getErrorsFromConstraintViolation(ConstraintViolation<T> constraintViolation) {
		String fieldName = Utils.getNameFromJsonProperty(constraintViolation);
		String fieldValue = constraintViolation.getInvalidValue() != null
				? constraintViolation.getInvalidValue().toString()
				: "";

		return new ErrorDto<String>(HttpStatus.BAD_REQUEST.name(), HttpStatus.BAD_REQUEST.toString(),
				"Invalid URI path variable value", "Invalid URI path variable (" + fieldName + ") with value ("
						+ fieldValue + ")" + constraintViolation.getMessage(),
				resource);

	}

	/**
	 * Generic method responsible for obtaining the name of the field through the
	 * json property.
	 * 
	 * @param constraintViolation, the violation
	 * @param <T>, generic element
	 * @return <T> String
	 */
	public static <T> String getNameFromJsonProperty(ConstraintViolation<T> constraintViolation) {
		return Utils.getNameFromJsonProperty(constraintViolation.getLeafBean().getClass(),
				constraintViolation.getPropertyPath().toString());
	}

	/**
	 * Method responsible for obtaining the name of the field through the json
	 * property.
	 * 
	 * @param object, the object
	 * @param fieldName, the field name
	 * @return String
	 */
	@SuppressWarnings("rawtypes")
	public static String getNameFromJsonProperty(Class object, String fieldName) {
		String name = fieldName;
		try {

			String[] path = fieldName.split("\\.");

			if (path.length > NumberUtils.INTEGER_ONE) {
				name = path[NumberUtils.INTEGER_ONE];
			}
			Field field = object.getClass().getDeclaredField(name);
			Annotation annotation = field.getAnnotation(JsonProperty.class);
			if (annotation != null && annotation instanceof JsonProperty) {
				JsonProperty jsonProperty = (JsonProperty) annotation;
				name = jsonProperty.value();

			}

		} catch (NoSuchFieldException e) {

			LOGGER.error("Exception: ", e);
		}

		return name;
	}

}
