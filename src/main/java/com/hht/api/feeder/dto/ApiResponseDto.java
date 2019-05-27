<<<<<<< HEAD
/**
 * 
 */
package com.hht.api.feeder.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jorge De Los Santos
 * @Version 1.1
 * @Since May 5, 2019 
 */

public class ApiResponseDto implements Serializable{

	
	private static final long serialVersionUID = -1984763249441316964L;

	/** The data. */
	private transient List<? extends DataDto> data = new ArrayList<>();
	
	/** The errors. */
	private transient List<Object> errors  = new ArrayList<>();
	
	/**
	 * Instantiates a new ApiResponseDto.
	 */
	public ApiResponseDto() {}
	
	
	/**
	 * Instantiates a new ApiResponseDto.
	 *
	 * @param dataDtos the data dtos
	 */
	public ApiResponseDto( List<? extends DataDto> dataDtos ) {
		this.data = dataDtos;
	}
	
	/**
	 * Instantiates a new ApiResponseDto.
	 *
	 * @param error the error
	 */
	public ApiResponseDto( ErrorDto<?> error ) {
		this.errors.add( error );
	}
		
	

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public List<? extends DataDto> getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(List<? extends DataDto> data) {
		this.data = data;
	}

	/**
	 * Gets the errors.
	 *
	 * @return the errors
	 */
	public List<Object> getErrors() {
		return errors;
	}

	/**
	 * Sets the errors.
	 *
	 * @param list the new errors
	 */
	public void setErrors(List<Object> list) {
		this.errors = list;
	}
	
	/**
	 * Adds the error.
	 *
	 * @param error the error
	 */
	public void addError( ErrorDto<?> error ) {
		this.errors.add( error );
	}

}
=======
/**
 * 
 */
package com.hht.api.feeder.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jorge De Los Santos
 * @Version 1.1
 * @Since May 5, 2019 
 */

public class ApiResponseDto implements Serializable{

	
	private static final long serialVersionUID = -1984763249441316964L;

	/** The data. */
	private transient List<? extends DataDto> data = new ArrayList<>();
	
	/** The errors. */
	private transient List<Object> errors  = new ArrayList<>();
	
	/**
	 * Instantiates a new ApiResponseDto.
	 */
	public ApiResponseDto() {}
	
	
	/**
	 * Instantiates a new ApiResponseDto.
	 *
	 * @param dataDtos the data dtos
	 */
	public ApiResponseDto( List<? extends DataDto> dataDtos ) {
		this.data = dataDtos;
	}
	
	/**
	 * Instantiates a new ApiResponseDto.
	 *
	 * @param error the error
	 */
	public ApiResponseDto( ErrorDto<?> error ) {
		this.errors.add( error );
	}
		
	

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public List<? extends DataDto> getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(List<? extends DataDto> data) {
		this.data = data;
	}

	/**
	 * Gets the errors.
	 *
	 * @return the errors
	 */
	public List<Object> getErrors() {
		return errors;
	}

	/**
	 * Sets the errors.
	 *
	 * @param list the new errors
	 */
	public void setErrors(List<Object> list) {
		this.errors = list;
	}
	
	/**
	 * Adds the error.
	 *
	 * @param error the error
	 */
	public void addError( ErrorDto<?> error ) {
		this.errors.add( error );
	}

}
>>>>>>> branch 'master' of https://eLMatru@bitbucket.org/horizon-h-t/api_feeder.git
