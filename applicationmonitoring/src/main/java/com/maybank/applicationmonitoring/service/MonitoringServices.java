package com.maybank.applicationmonitoring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.maybank.applicationmonitoring.dao.MonitoringRepository;
import com.maybank.applicationmonitoring.dto.MonitoringResponse;
import com.maybank.applicationmonitoring.dto.Status;
import com.maybank.applicationmonitoring.entity.ApplicationMonitoringEntity;
import com.maybank.applicationmonitoring.exception.InputNotFoundException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@Service
public class MonitoringServices implements IMonitoringService {
	
	public  ExtentReports report;
	public  ExtentTest test;

	private static final String IPV4_REGEX = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
			+ "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
			+ "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

	private static final Pattern IPv4_PATTERN = Pattern.compile(IPV4_REGEX);

	@Autowired
	MonitoringRepository monitoringRepository;
	
	
	@Transactional
	@Override
	public List<MonitoringResponse> getServerDetails(String hostaddress) {

		report = new ExtentReports("D:\\BranchWorkspace_02Feb\\monitoring.html");
		test=report.startTest("Application  Monitoring Status");
		List<ApplicationMonitoringEntity> monitoringEntities = new ArrayList<>();
		List<MonitoringResponse> responses= new ArrayList<MonitoringResponse>();
		if (isValidInet4Address(hostaddress)) {

			monitoringEntities = monitoringRepository.fetchDetailsByIpAddress(hostaddress);
		} else {
			if (hostaddress.startsWith("MBB")) {

				monitoringEntities = monitoringRepository.fetchDetailsByHostName(hostaddress);
			} else {
				throw new InputNotFoundException(String.format("host Details %s", hostaddress));
			}

		}
		List<MonitoringResponse> listOfCallableURL = listOfMonitoringResponse(monitoringEntities);
		if(!listOfCallableURL.isEmpty()) {
			listOfCallableURL.forEach(res->{
				MonitoringResponse monitoringResponse = new MonitoringResponse();
				try {
					
					ResponseEntity<Status> responseEntity = new RestTemplate().getForEntity(res.getURL(), Status.class);
					Status response = responseEntity.getBody();
					monitoringResponse.setHostName(res.getHostName());
					monitoringResponse.setIpAddress(res.getIpAddress());
					monitoringResponse.setPort(res.getPort());
					monitoringResponse.setApplication(res.getApplication());
					monitoringResponse.setStatus(response.getCode());
					
					test.log(LogStatus.PASS,"Host Name : " 
					+ res.getHostName() +" | " +"Ip Address: " + res.getIpAddress()
					+ " | "+"Port :" + res.getPort()+ " | "
					+ "Application Name  :" 
					+ res.getApplication()  +" | " +"Application Status : " + response.getCode());
				
					
					
					System.out.println("response" + response.getCode());
				}catch(Exception ex) {
					monitoringResponse.setHostName(res.getHostName());
					monitoringResponse.setIpAddress(res.getIpAddress());
					monitoringResponse.setPort(res.getPort());
					monitoringResponse.setApplication(res.getApplication());
					monitoringResponse.setStatus("DOWN");
					
					test.log(LogStatus.FAIL,"Host Name : " 
							+ res.getHostName() +" | " +"Ip Address: " + res.getIpAddress()
							+ " | "+"Port :" + res.getPort()+ " | "
							+ "Application Name  :" 
							+ res.getApplication()  +" | " +"Application Status :" + "DOWN");
					
					
				}
				responses.add(monitoringResponse);
			});
			

		}else {
			throw new InputNotFoundException(String.format("Request URI as %s is %s" ,hostaddress,"incorrect" ));
		}
		System.out.println("Test...");
		report.endTest(test);
		report.flush();
		return responses;
	}

	private List<MonitoringResponse> listOfMonitoringResponse(List<ApplicationMonitoringEntity> monitoringEntities) {
		List<MonitoringResponse> listOfUrls = new ArrayList<>();
		if (!monitoringEntities.isEmpty()) {
			monitoringEntities.forEach(it -> {
				MonitoringResponse response= new MonitoringResponse();
				String url = it.getProtocol().concat("://").concat(it.getIpAddress()).concat(":").concat(it.getPort())
						.concat(!Objects.isNull(it.getContextRoot()) ? "/" + it.getContextRoot()+"/" : "/")
						.concat("actuator/health");
				response.setHostName(it.getHostName());
				response.setIpAddress(it.getIpAddress());
				response.setPort(it.getPort());
				response.setApplication(it.getContextRoot());
				response.setURL(url);
				listOfUrls.add(response);
			});
		}

		return listOfUrls;
	}

	public static boolean isValidInet4Address(String ip) {
		if (ip == null) {
			return false;
		}

		Matcher matcher = IPv4_PATTERN.matcher(ip);

		return matcher.matches();
	}

}
