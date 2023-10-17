package com.oasys.mdmclient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.oasys.mdmclient.entity.DeviceMaster;

public interface DeviceMasterRepository extends JpaRepository<DeviceMaster, Integer> {

	@Query(value = "SELECT launcher_pwd FROM device_master WHERE device_id= :deviceId", nativeQuery = true)
	List<Object[]> getLauncherPwd(String deviceId);

	DeviceMaster findByDeviceId(String device_id);
	
	DeviceMaster findLauncherPwdByDeviceId(String device_id);

}