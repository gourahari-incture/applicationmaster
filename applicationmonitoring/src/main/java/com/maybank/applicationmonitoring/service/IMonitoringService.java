package com.maybank.applicationmonitoring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maybank.applicationmonitoring.dto.MonitoringResponse;

@Service
public interface IMonitoringService {
	
	public List<MonitoringResponse> getServerDetails(String hostaddress);

}
