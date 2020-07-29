package com.maybank.applicationmonitoring.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maybank.applicationmonitoring.dto.MonitoringResponse;
import com.maybank.applicationmonitoring.service.IMonitoringService;

@RestController
public class ApplicationMonitoringController {

	private static final Logger LOGGER = LogManager.getLogger(ApplicationMonitoringController.class);
	
	


	@Autowired
	IMonitoringService monitoringService;

	@GetMapping(path = "/HostNameOrAddress/{serverAddress}")
	@ResponseBody
	public List<MonitoringResponse> serverUp(@PathVariable String serverAddress) {
		LOGGER.info(String.format("Input server details  is %s ", serverAddress));

		return monitoringService.getServerDetails(serverAddress);

	}

	@GetMapping(path = "/HostName")
	@ResponseBody
	public String test() {
		LOGGER.info(String.format("Input server details  is %s ", "test"));

		return "test Has been hit!!!!!!!!!!";

	}

}
