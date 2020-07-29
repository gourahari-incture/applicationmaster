package com.maybank.applicationmonitoring.dto;

import java.io.Serializable;

import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Status implements Serializable {

	private static final long serialVersionUID = 1016803134844659456L;

	public static final Status UNKNOWN = new Status("UNKNOWN");
	public static final Status UP = new Status("UP");
	public static final Status DOWN = new Status("DOWN");
	public static final Status OUT_OF_SERVICE = new Status("OUT_OF_SERVICE");
	private final String code;
	private final String description;

	
	public Status() {
		this("","");
	}
	public Status(String code) {
		this(code, "");
	}

	public Status(String code, String description) {
		this.description = "";
		this.code = code;
	}

	@JsonProperty("status")
	public String getCode() {
		return this.code;
	}

	@JsonInclude(Include.NON_EMPTY)
	public String getDescription() {
		return this.description;
	}

	@Override
	public String toString() {
		return this.code;
	}

	@Override
	public int hashCode() {
		return this.code.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj != null && obj instanceof Status) {
			return ObjectUtils.nullSafeEquals(this.code, ((Status) obj).code);
		}
		return false;
	}

}
