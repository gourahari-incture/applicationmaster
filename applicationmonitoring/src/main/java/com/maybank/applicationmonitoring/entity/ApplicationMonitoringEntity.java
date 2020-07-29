package com.maybank.applicationmonitoring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "APPLICATION_MONITORING")
@NamedQueries({
		@NamedQuery(name = "ApplicationMonitoringEntity.fetchDetailsByHostName", query = "SELECT am FROM ApplicationMonitoringEntity am where am.hostName= :hostName "),
		@NamedQuery(name = "ApplicationMonitoringEntity.fetchDetailsByIpAddress", query = "SELECT am FROM ApplicationMonitoringEntity am where am.ipAddress= :ipAddress ") })

public class ApplicationMonitoringEntity implements Serializable {

	private static final long serialVersionUID = 1700334915680720115L;

	public static final String FETCH_SERVER_BY_IP = "FETCH_SERVER_BY_IP";
	public static final String FETCH_SERVER_BY_NAME = "FETCH_SERVER_BY_NAME";

	@Id
	@GeneratedValue
	@Column(name = "MONITORING_ID")
	private String monitoringId;

	@Column(name = "PROTOCOL ")
	private String protocol;

	@Column(name = "SERVER_HOST_NAME")
	private String hostName;

	@Column(name = "SERVER_IP_ADDRESS ")
	private String ipAddress;

	@Column(name = "PORT")
	private String port;

	@Column(name = "CONTEXT_ROOT")
	private String contextRoot;

	public ApplicationMonitoringEntity() {
	}

	public ApplicationMonitoringEntity(String monitoringId, String protocol, String hostName, String ipAddress,
			String port, String contextRoot) {
		super();
		this.monitoringId = monitoringId;
		this.protocol = protocol;
		this.hostName = hostName;
		this.ipAddress = ipAddress;
		this.port = port;
		this.contextRoot = contextRoot;
	}

	public String getMonitoringId() {
		return monitoringId;
	}

	public void setMonitoringId(String monitoringId) {
		this.monitoringId = monitoringId;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getContextRoot() {
		return contextRoot;
	}

	public void setContextRoot(String contextRoot) {
		this.contextRoot = contextRoot;
	}

	@Override
	public String toString() {
		return "ApplicationMonitoringEntity [monitoringId=" + monitoringId + ", protocol=" + protocol + ", hostName="
				+ hostName + ", ipAddress=" + ipAddress + ", port=" + port + ", contextRoot=" + contextRoot + "]";
	}

}
