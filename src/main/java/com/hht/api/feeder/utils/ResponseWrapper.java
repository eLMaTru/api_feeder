package com.hht.api.feeder.utils;

import com.fasterxml.jackson.annotation.JsonValue;
import com.hht.api.feeder.dto.DataDto;

/**
 * ResponseWrapper Class is responsible for wrapping the response entities if they do not inherit from DataDto
 *
 * @author Jorge De Los Santos
 * @Version 1.1
 * @Since May 5, 2019 
 *
 *
 * @param <T> the type to wrap
 *
 * <p>takes the root of the wrapped object when serializes it</p>
 *
 * <code>
 *  {
 *   "field1" : "value"
 *   ...
 *  }
 * </code>
 *
 * */
public class ResponseWrapper<T> extends DataDto {

	private static final long serialVersionUID = -7729188607721049982L;
	
	/**
     * The Wrapped entity
     *
     * */
    private T wrapped;


    /**
     * Private Default Constructor
     *
     * */
    private ResponseWrapper() {}

    /**
     * Private Constructor
     * @param t wrapped entity
     * */
    private ResponseWrapper(T t) {
        wrapped = t;
    }

    /**
     * Return an Instance of ResponseWrapper without any wrapped value
     * @return ResponseWrapper
     * */
    public static <T>ResponseWrapper<T> of() {
        return new ResponseWrapper<T>();
    }

    /**
     * Returns an Instance of ResponseWrapper with a wrapped value
     * @return ResponseWrapper
     * */
    public static <T> ResponseWrapper<T> of(T t){
        return new ResponseWrapper<T>(t);
    }

    /**
     * Gets the Wrapped value
     * @return T
     * */
    @JsonValue
    public T getWrapped() {
        return wrapped;
    }

    /**
     * Sets the Wrapped value
     * @param wrapped
     * */
    public void setWrapped(T wrapped) {
        this.wrapped = wrapped;
    }


    /**
     * toString method
     * @return String
     * */
    @Override
    public String toString() {
        return "ResponseWrapper{" +
                "wrapped=" + wrapped +
                '}';
    }
}
