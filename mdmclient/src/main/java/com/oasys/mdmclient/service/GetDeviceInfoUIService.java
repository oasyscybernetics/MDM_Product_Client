package com.oasys.mdmclient.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oasys.mdmclient.repository.DeviceInfoRepository;
import com.oasys.mdmclient.request.GetDeviceInfoUIRequest;
import com.oasys.mdmclient.response.GenericResponse;
import com.oasys.mdmclient.response.GetDeviceInfoUIResponse;

@Service
public class GetDeviceInfoUIService {

	private static final Logger log = LoggerFactory.getLogger(GetDeviceInfoUIService.class);

	@Autowired
	DeviceInfoRepository deviceInfoRepository;

	public GenericResponse getDeviceInfoUI(GetDeviceInfoUIRequest getDeviceInfoUIRequest) {
		log.info("<--Starts GetDeviceInfoUIService.getDeviceInfoUI-->");
		GenericResponse response = null;
		try {
			List<Object[]> result = deviceInfoRepository.getDeviceInfoUI(getDeviceInfoUIRequest.getDeviceId());
			List<GetDeviceInfoUIResponse> responses = new ArrayList<GetDeviceInfoUIResponse>();
			for (Object[] obj : result) {
				GetDeviceInfoUIResponse getDeviceInfoUIResponse = new GetDeviceInfoUIResponse();
				getDeviceInfoUIResponse.setDeviceId((obj[0]).toString());
				getDeviceInfoUIResponse.setDeviceModel((obj[1]).toString());
				getDeviceInfoUIResponse.setDeviceInternalStorage((obj[2]).toString());
				getDeviceInfoUIResponse.setDeviceExternalStorage((obj[3]).toString());
				getDeviceInfoUIResponse.setDeviceUserAppCount(((Integer) obj[4]));
				getDeviceInfoUIResponse.setDeviceBatteryLevel((obj[5]).toString());
				getDeviceInfoUIResponse.setDeviceTemprature((obj[6]).toString());
				getDeviceInfoUIResponse.setDeviceRam((obj[7]).toString());
				getDeviceInfoUIResponse.setDeviceStorageUsed((obj[8]).toString());
				getDeviceInfoUIResponse.setDeviceManufacturer((obj[9]).toString());
				getDeviceInfoUIResponse.setDeviceOsVersion((obj[10]).toString());
				getDeviceInfoUIResponse.setDeviceIp((obj[11]).toString());
				getDeviceInfoUIResponse.setDeviceMac((obj[12]).toString());
				getDeviceInfoUIResponse.setDeviceLat((obj[13]).toString());
				getDeviceInfoUIResponse.setDeviceLong((obj[14]).toString());
				getDeviceInfoUIResponse.setDeviceSim1IMEI((obj[15]).toString());
				getDeviceInfoUIResponse.setDeviceSim2IMEI((obj[16]).toString());
				getDeviceInfoUIResponse.setDeviceSno((obj[17]).toString());
				getDeviceInfoUIResponse.setDeviceSim1No((obj[18]).toString());
				getDeviceInfoUIResponse.setDeviceSim2No((obj[19]).toString());
//				getDeviceInfoUIResponse.setLocationName(String.valueOf(obj[18]));
				getDeviceInfoUIResponse.setCreatedDate((obj[20]).toString());
				getDeviceInfoUIResponse.setMinuteDiff(((Long) obj[21]).longValue());

				responses.add(getDeviceInfoUIResponse);
			}
			if (responses != null) {
				response = new GenericResponse();
				response.setData(responses);
				response.setUserDisplayMesg("Success");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		log.info("<--Ends GetDeviceInfoUIService.getDeviceInfoUI-->");
		return response;
	}
}
