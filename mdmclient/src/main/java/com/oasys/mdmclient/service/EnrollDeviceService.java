package com.oasys.mdmclient.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oasys.mdmclient.entity.DeviceMaster;
import com.oasys.mdmclient.repository.DeviceMasterRepository;
import com.oasys.mdmclient.request.EnrollDeviceRequest;
import com.oasys.mdmclient.response.DeviceMasterResponse;

@Service
public class EnrollDeviceService {

	@Autowired
	DeviceMasterRepository deviceMasterRpository;

	public DeviceMasterResponse saveDeviceMaster(EnrollDeviceRequest enrollDevice) {

		DeviceMasterResponse response = new DeviceMasterResponse();
		DeviceMaster existingDevice = deviceMasterRpository.findByDeviceId(enrollDevice.getDevice_id());

		try {
			Optional<DeviceMaster> optionalDeviceInfo = Optional.ofNullable(existingDevice);
			if (optionalDeviceInfo.isPresent()) {
				// existingDevice = optionalDeviceInfo.get();
				// response.setDeviceId(existingDevice.getDeviceId());
				response.setMsg("Already Registered");
			} else {
				DeviceMaster deviceMaster = new DeviceMaster();
				deviceMaster.setDeviceStatus(1);
				deviceMaster.setDeviceId(enrollDevice.getDevice_id());
				deviceMaster.setDeviceName(enrollDevice.getDevice_name());
				deviceMaster.setBranch(enrollDevice.getBranch());
				deviceMaster.setMobileNumber(enrollDevice.getMobileNumber());
				deviceMasterRpository.save(deviceMaster);
				response.setMsg("Success");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;
	}
}
