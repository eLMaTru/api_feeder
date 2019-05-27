<<<<<<< HEAD
/**
 * 
 */
package com.hht.api.feeder.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author Jorge De Los Santos
 * @Version 1.1
 * @Since May 5, 2019 
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class ErrorDto<T> implements Serializable {

    /**
     * The constant serialVersionUID.
     */
    private transient static final long serialVersionUID = -7969117070576432807L;

    /**
     * The status.
     */
    private transient String status;

    /**
     * The code.
     */
    private transient String code;

    /**
     * The title.
     */
    private transient String title;

    /**
     * The detail.
     */
    private transient T detail;

    /**
     * The resource.
     */
    private transient String resource;

    /**
     * Constructor
     */
    public ErrorDto() {
    }

    /**
     * Constructor
     */
    public ErrorDto(String status, String code, String title, T detail, String resource) {
        this.status = status;
        this.code = code;
        this.title = title;
        this.detail = detail;
        this.resource = resource;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the code.
     *
     * @param code the new code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the detail.
     *
     * @return the detail
     */
    public T getDetail() {
        return detail;
    }

    /**
     * Sets the detail.
     *
     * @param detail the new detail
     */
    public void setDetail(T detail) {
        this.detail = detail;
    }

    /**
     * Gets the resource.
     *
     * @return the resource
     */
    public String getResource() {
        return resource;
    }

    /**
     * Sets the resource.
     *
     * @param resource the new resource
     */
    public void setResource(String resource) {
        this.resource = resource;
    }

}
=======
/**
 * 
 */
package com.hht.api.feeder.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author Jorge De Los Santos
 * @Version 1.1
 * @Since May 5, 2019 
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class ErrorDto<T> implements Serializable {

    /**
     * The constant serialVersionUID.
     */
    private transient static final long serialVersionUID = -7969117070576432807L;

    /**
     * The status.
     */
    private transient String status;

    /**
     * The code.
     */
    private transient String code;

    /**
     * The title.
     */
    private transient String title;

    /**
     * The detail.
     */
    private transient T detail;

    /**
     * The resource.
     */
    private transient String resource;

    /**
     * Constructor
     */
    public ErrorDto() {
    }

    /**
     * Constructor
     */
    public ErrorDto(String status, String code, String title, T detail, String resource) {
        this.status = status;
        this.code = code;
        this.title = title;
        this.detail = detail;
        this.resource = resource;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the code.
     *
     * @param code the new code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the detail.
     *
     * @return the detail
     */
    public T getDetail() {
        return detail;
    }

    /**
     * Sets the detail.
     *
     * @param detail the new detail
     */
    public void setDetail(T detail) {
        this.detail = detail;
    }

    /**
     * Gets the resource.
     *
     * @return the resource
     */
    public String getResource() {
        return resource;
    }

    /**
     * Sets the resource.
     *
     * @param resource the new resource
     */
    public void setResource(String resource) {
        this.resource = resource;
    }

}
>>>>>>> branch 'master' of https://eLMatru@bitbucket.org/horizon-h-t/api_feeder.git
