package com.maybank.applicationmonitoring.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class MonitoringResponse {

	private String ipAddress;
	private String hostName;
	private String port;
	private String application;
	private String status;
	
	@JsonIgnore
	private String URL;

	public MonitoringResponse() {
	}

	
	@JsonIgnore
	public String getURL() {
		return URL;
	}


	@JsonIgnore
	public void setURL(String uRL) {
		URL = uRL;
	}



	public String getApplication() {
		return application;
	}


	public void setApplication(String application) {
		this.application = application;
	}


	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}
