package com.oasys.mdmclient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.oasys.mdmclient.entity.DeviceInfo;

public interface DeviceInfoRepository extends JpaRepository<DeviceInfo, Integer> {

	DeviceInfo findByDeviceId(String device_id);

	@Query(value = "SELECT di.device_id,di.device_model,di.device_internal_storage,di.device_external_storage,di.device_battery_level,di.device_manufacturer,di.device_os_version,di.device_lat,di.device_long,di.device_Sim1_IMEI,di.device_Sim2_IMEI,di.device_sim1_no,di.device_sim2_no,di.signal_strength,di.internet_connection, di.battery_plugged,di.battery_technology,DATE_FORMAT(di.created_dt,'%Y-%m-%d %T') AS created_dt, TIMESTAMPDIFF(MINUTE,di.created_dt,CURRENT_TIMESTAMP)AS minute_diff FROM device_master dm LEFT JOIN device_info di ON di.device_id=dm.device_id WHERE di.device_id= :deviceId", nativeQuery = true)
	List<Object[]> deviceInfoZMQ(String deviceId);

	@Query(value = "SELECT device_id,device_model,device_internal_storage,device_external_storage,device_user_app_count,device_battery_level,device_temprature,device_ram,device_storage_used,device_manufacturer,device_os_version,device_ip,device_mac,device_lat,device_long,device_Sim1_IMEI,device_Sim2_IMEI,device_sno,device_sim1_no,device_sim2_no,DATE_FORMAT(created_dt,'%d-%m-%Y %T') AS created_dt, TIMESTAMPDIFF(MINUTE,created_dt,CURRENT_TIMESTAMP)AS minute_diff FROM device_info WHERE device_id= :deviceId", nativeQuery = true)
	List<Object[]> getDeviceInfoUI(String deviceId);

//	DeviceInfo findByDeviceId(String deviceId);

	@Query(value = "SELECT di.device_id,di.device_model,di.device_internal_storage,di.device_external_storage,di.device_battery_level,di.device_manufacturer,di.device_os_version,di.device_lat,di.device_long,di.device_Sim1_IMEI,di.device_Sim2_IMEI,di.device_sim1_no,di.device_sim2_no,di.signal_strength,di.internet_connection, di.battery_plugged,di.battery_technology,DATE_FORMAT(di.created_dt,'%Y-%m-%d %T') AS created_dt, TIMESTAMPDIFF(MINUTE,di.created_dt,CURRENT_TIMESTAMP)AS minute_diff FROM device_master dm LEFT JOIN device_info di ON di.device_id=dm.device_id WHERE di.device_id= :deviceId", nativeQuery = true)
	List<Object[]> findByZMQDeviceId(String deviceId);

}
