package com.oasys.mdmclient.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oasys.mdmclient.entity.DeviceInfo;
import com.oasys.mdmclient.entity.DeviceMaster;
import com.oasys.mdmclient.entity.PresentDeviceDetailsInfo;
import com.oasys.mdmclient.repository.DeviceInfoRepository;
import com.oasys.mdmclient.repository.DeviceMasterRepository;
import com.oasys.mdmclient.repository.PresentDeviceDetailsInfoRepository;
import com.oasys.mdmclient.request.DeviceHeartBeatRequest;
import com.oasys.mdmclient.response.DeviceHeartBeatResponse;

import jakarta.transaction.Transactional;

@Service
public class DeviceHeartBeatService {

	@Autowired
	DeviceInfoRepository deviceInfoRepository;

	@Autowired
	DeviceMasterRepository deviceMasterRepoisitory;
	
	@Autowired
	PresentDeviceDetailsInfoRepository presentDeviceDetailsInfoRepository;

	@Transactional
	public DeviceHeartBeatResponse getDeviceHeartBeat(DeviceHeartBeatRequest deviceHeartBeatReq) {
		DeviceHeartBeatResponse response = new DeviceHeartBeatResponse();
		DeviceInfo deviceInfoMaster = deviceInfoRepository.findByDeviceId(deviceHeartBeatReq.getDevice_id());
		DeviceInfo result=null;
		try {
			Optional<DeviceInfo> optionalDeviceInfo = Optional.ofNullable(deviceInfoMaster);
			if (optionalDeviceInfo.isPresent()) {
				deviceInfoMaster = optionalDeviceInfo.get();
				deviceInfoMaster.setDeviceId(deviceHeartBeatReq.getDevice_id());
				deviceInfoMaster.setDeviceLatitude(deviceHeartBeatReq.getDevice_lat());
				deviceInfoMaster.setDeviceLongitude(deviceHeartBeatReq.getDevice_long());
				deviceInfoMaster.setDeviceStorageUsed(deviceHeartBeatReq.getDevice_storage_used());
			    result = deviceInfoRepository.save(deviceInfoMaster);
				if (result.getDeviceId() == deviceHeartBeatReq.getDevice_id()) {
					response.setMsg("Success");
					DeviceMaster deviceMaster = deviceMasterRepoisitory
							.findByDeviceId(deviceHeartBeatReq.getDevice_id());
					response.setLauncher_pwd(deviceMaster.getLauncherPwd());
				} else {
					response.setMsg("Failed");
				}

			}
			PresentDeviceDetailsInfo presentDeviceDetailsInfo = new PresentDeviceDetailsInfo();
			
			presentDeviceDetailsInfo.setDeviceId(result.getDeviceId());
			presentDeviceDetailsInfo.setDeviceLatitude(result.getDeviceLatitude());
			presentDeviceDetailsInfo.setDeviceLongitude(result.getDeviceLongitude());
			presentDeviceDetailsInfo.setDeviceInternalStorage(result.getDeviceInternalStorage());
			presentDeviceDetailsInfo.setDeviceExternalStorage(result.getDeviceExternalStorage());
			presentDeviceDetailsInfo.setDeviceBatteryLevel(result.getDeviceBatteryLevel());
			presentDeviceDetailsInfo.setDeviceSysAppCount(result.getDeviceSysAppCount());
			presentDeviceDetailsInfo.setDeviceTemperature(result.getDeviceTemperature());
			presentDeviceDetailsInfo.setDeviceUserAppCount(result.getDeviceUserAppCount());
			presentDeviceDetailsInfo.setCreatedDate(result.getCreatedDate());
//			PresentDeviceDetailsInfo result = presentDeviceDetailsInfoRepository.save(presentDeviceDetailsInfo);
			presentDeviceDetailsInfoRepository.save(presentDeviceDetailsInfo);
//			if (result.getDeviceId() == deviceHeartBeatReq.getDevice_id()) {
//				response.setMsg("Success");
//			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			response = new DeviceHeartBeatResponse();
			response.setMsg("Failed");
		}
		return response;
	}
}
