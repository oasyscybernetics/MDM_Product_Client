package com.oasys.mdmclient.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oasys.mdmclient.entity.DeviceInfo;
import com.oasys.mdmclient.entity.DeviceMaster;
import com.oasys.mdmclient.repository.DeviceInfoRepository;
import com.oasys.mdmclient.repository.DeviceMasterRepository;
import com.oasys.mdmclient.request.DeviceInfoRequest;
import com.oasys.mdmclient.response.MDMAndroidClientResponse;

@Service
public class DeviceInfoService {

	@Autowired
	DeviceInfoRepository deviceInfoRepository;

	@Autowired
	DeviceMasterRepository deviceMasterRepository;

	// used to insert the information about the device in device_info table
	public MDMAndroidClientResponse saveDeviceInfo(DeviceInfoRequest deviceInfo) {
		MDMAndroidClientResponse response = new MDMAndroidClientResponse();
		DeviceInfo deviceInfoMaster = deviceInfoRepository.findByDeviceId(deviceInfo.getDevice_id());

		DeviceMaster deviceMaster = deviceMasterRepository.findByDeviceId(deviceInfo.getDevice_id());
		try {
			if (deviceMaster.getDeviceStatus() == 1) {
				Optional<DeviceInfo> optionalDeviceInfo = Optional.ofNullable(deviceInfoMaster);
				if (optionalDeviceInfo.isPresent()) {
					deviceInfoMaster = optionalDeviceInfo.get();
					// Perform operations with 'deviceId'
					deviceInfoMaster.setDeviceLatitude(deviceInfo.getDevice_lat());
					deviceInfoMaster.setDeviceLongitude(deviceInfo.getDevice_long());
					deviceInfoMaster.setDeviceInternalStorage(deviceInfo.getDevice_internal_storage());
					deviceInfoMaster.setDeviceBatteryLevel(deviceInfo.getDevice_battery_level());
//				deviceInfoMaster.setCreatedDate(new Timestamp(System.currentTimeMillis()));
					deviceInfoMaster.setDeviceTemperature(deviceInfo.getDevice_temprature());
					deviceInfoMaster.setSignalStrength(deviceInfo.getSignal_strength());
					deviceInfoMaster.setInternetConnection(deviceInfo.getInternet_connection());
					deviceInfoMaster.setBatteryHealth(deviceInfo.getBattery_health());
					deviceInfoMaster.setBatteryTechnology(deviceInfo.getBattery_technology());
					deviceInfoMaster.setBatteryPlugged(deviceInfo.getBattery_plugged());
					deviceInfoMaster.setDeviceSim1IMEI(deviceInfo.getDevice_Sim1_IMEI());
					deviceInfoMaster.setDeviceSim2IMEI(deviceInfo.getDevice_Sim2_IMEI());
					deviceInfoMaster.setDeviceSim1Number(deviceInfo.getDevice_sim1_no());
					deviceInfoMaster.setDeviceSim2Number(deviceInfo.getDevice_sim2_no());
					deviceInfoMaster.setDeviceOSVersion(deviceInfo.getDevice_os_version());
					deviceInfoRepository.save(deviceInfoMaster);
					response.setMsg("Updated");
				} else {
					deviceInfoMaster = new DeviceInfo();
					deviceInfoMaster.setDeviceId(deviceInfo.getDevice_id());
					deviceInfoMaster.setDeviceModel(deviceInfo.getDevice_model());
					deviceInfoMaster.setDeviceInternalStorage(deviceInfo.getDevice_internal_storage());
					deviceInfoMaster.setDeviceExternalStorage(deviceInfo.getDevice_external_storage());
					deviceInfoMaster.setDeviceUserAppCount(deviceInfo.getDevice_user_app_count());
					deviceInfoMaster.setDeviceSysAppCount(deviceInfo.getDevice_sys_app_count());
					deviceInfoMaster.setDeviceBatteryLevel(deviceInfo.getDevice_battery_level());
					deviceInfoMaster.setDeviceTemperature(deviceInfo.getDevice_temprature());
					deviceInfoMaster.setDeviceRAM(deviceInfo.getDevice_ram());
					deviceInfoMaster.setDeviceStorageUsed(deviceInfo.getDevice_storage_used());
					deviceInfoMaster.setDeviceManufacturer(deviceInfo.getDevice_manufacturer());
					deviceInfoMaster.setDeviceOSVersion(deviceInfo.getDevice_os_version());
					deviceInfoMaster.setDeviceIP(deviceInfo.getDevice_ip());
					deviceInfoMaster.setDeviceMAC(deviceInfo.getDevice_mac());
					deviceInfoMaster.setDeviceLatitude(deviceInfo.getDevice_lat());
					deviceInfoMaster.setDeviceLongitude(deviceInfo.getDevice_long());
					// deviceInfoMaster.setCreatedDate(deviceInfo.getTime());
					deviceInfoMaster.setDeviceSim1IMEI(deviceInfo.getDevice_Sim1_IMEI());
					deviceInfoMaster.setDeviceSim2IMEI(deviceInfo.getDevice_Sim2_IMEI());
					deviceInfoMaster.setDeviceSerialNo(deviceInfo.getDevice_sno());
					deviceInfoMaster.setDeviceSim1Number(deviceInfo.getDevice_sim1_no());
					deviceInfoMaster.setDeviceSim2Number(deviceInfo.getDevice_sim2_no());
					deviceInfoMaster.setSignalStrength(deviceInfo.getSignal_strength());
					deviceInfoMaster.setInternetConnection(deviceInfo.getInternet_connection());
					deviceInfoMaster.setBatteryPlugged(deviceInfo.getBattery_plugged());
					deviceInfoMaster.setBatteryHealth(deviceInfo.getBattery_health());
					deviceInfoMaster.setBatteryTechnology(deviceInfo.getBattery_technology());

					deviceInfoRepository.save(deviceInfoMaster);
					response.setMsg("Success");
				}
			} else if (deviceMaster.getDeviceStatus() == 0) {
				response.setMsg("UnAuthorized Device");
			} else if (deviceMaster.getDeviceStatus() == 2) {
				response.setMsg("Device is DeRegistered");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;
	}
}