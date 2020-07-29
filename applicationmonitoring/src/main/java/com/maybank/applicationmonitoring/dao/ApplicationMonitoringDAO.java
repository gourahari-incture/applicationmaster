//package com.maybank.monitoring.dao;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
//
//import com.maybank.carisma.scriptworkflow.entity.ReportingTableMaster;
//import com.maybank.monitoring.dto.MonitoringResponse;
//import com.maybank.monitoring.entity.ApplicationMonitoringEntity;
//
//@Repository
//public class ApplicationMonitoringDAO implements IApplicationMonitoringDAO {
//
//	@Override
//	public List< ApplicationMonitoringEntity > getServerDetailsList(String hostdetails) {
//		List<ApplicationMonitoringEntity> monitoringResponses = new ArrayList<>();
//		monitoringResponses = .createNamedQuery("FETCH_USER_DETAILS", ApplicationMonitoringEntity.class)
//				.setParameter("reportId", reportId).getResultList();
//
//		System.out.println(tableMasters);
//		return tableMasters;
//		return null;
//	}
//}
