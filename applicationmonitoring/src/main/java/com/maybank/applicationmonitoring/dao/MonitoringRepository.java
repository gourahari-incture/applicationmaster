package com.maybank.applicationmonitoring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maybank.applicationmonitoring.entity.ApplicationMonitoringEntity;


@Repository
public interface MonitoringRepository extends JpaRepository<ApplicationMonitoringEntity, String> {

	@Transactional(readOnly = true)
	List<ApplicationMonitoringEntity> fetchDetailsByHostName(@Param("hostName") String hostName);
	
	@Transactional(readOnly = true)
	List<ApplicationMonitoringEntity> fetchDetailsByIpAddress(@Param("ipAddress") String ipAddress);

}
