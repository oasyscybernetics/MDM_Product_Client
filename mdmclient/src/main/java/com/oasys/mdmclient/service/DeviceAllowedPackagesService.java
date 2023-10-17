package com.oasys.mdmclient.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oasys.mdmclient.repository.AppAllowedPackagesRepository;
import com.oasys.mdmclient.request.DeviceAllowedPackageRequest;
import com.oasys.mdmclient.response.DeviceAllowedPackagesResponse;
import com.oasys.mdmclient.response.MDMAndroidClientResponse;

//@Service
//public class DeviceAllowedPackageService {
//
//	@Autowired
//	AppAllowedPackagesRepository deviceAllowedPackagesRepository;
//
//	public DeviceAllowedPackagesResponse getDeviceAllowedPackage(DeviceAllowedPackageRequest deviceHeartBeatReq) throws Exception{
//		
//		DeviceAllowedPackagesResponse response = new DeviceAllowedPackagesResponse();
//		try {
//		if(deviceHeartBeatReq.getDevice_type().equals("OASYS")) {  
//			
//		List<Object[]> deviceAllowedPackages = deviceAllowedPackagesRepository.getDeviceAllowedPackagePos();
//		for(Object[] obj:deviceAllowedPackages) {
//			response.setAllowed_apk_pos((String)obj[0]);
//			response.setAllowed_apk_ver((String)obj[1]);
//			response.setAllowed_apk_url((String)obj[2]);
//			response.setAllowed_apk_logo((String)obj[3]);
//			response.setAllowed_apk_package((String)obj[4]);
//			response.setAllowed_apk_name((String)obj[5]);   
//			
//					}
//		}else {
//			List<Object[]> deviceAllowedPackages = deviceAllowedPackagesRepository.getDeviceAllowedPackageTab();
//			
//			for(Object[] obj : deviceAllowedPackages) {
//				response.setAllowed_apk_tab((String)obj[0]);
//				response.setAllowed_apk_ver((String)obj[1]);
//				response.setAllowed_apk_url((String)obj[2]);
//				response.setAllowed_apk_logo((String)obj[3]);
//				response.setAllowed_apk_package((String)obj[4]);
//				response.setAllowed_apk_name((String)obj[5]);
//			}
//		
//		}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		return response;
//	}
//
//}

@Service
public class DeviceAllowedPackagesService {

	@Autowired
	AppAllowedPackagesRepository deviceAllowedPackagesRepository;

	public MDMAndroidClientResponse getDeviceAllowedPackage(DeviceAllowedPackageRequest deviceHeartBeatReq)
			throws Exception {
		List<DeviceAllowedPackagesResponse> responses = new ArrayList<DeviceAllowedPackagesResponse>();
		MDMAndroidClientResponse response = null;
		try {
			if (deviceHeartBeatReq.getDevice_type().equals("OASYS")) {

				List<Object[]> deviceAllowedPackages = deviceAllowedPackagesRepository.getDeviceAllowedPackagePos();
				for (Object[] obj : deviceAllowedPackages) {
					DeviceAllowedPackagesResponse deviceAllowedPackagesResponse = new DeviceAllowedPackagesResponse();
					deviceAllowedPackagesResponse.setAllowed_apk_pos(obj[0].toString());
					deviceAllowedPackagesResponse.setAllowed_apk_ver(obj[1].toString());
					deviceAllowedPackagesResponse.setAllowed_apk_url(obj[2].toString());
//					deviceAllowedPackagesResponse.setAllowed_apk_logo(obj[3].toString());
					deviceAllowedPackagesResponse.setAllowed_apk_package(obj[4].toString());
					deviceAllowedPackagesResponse.setAllowed_apk_name(obj[5].toString());
					responses.add(deviceAllowedPackagesResponse);

				}
				if (responses != null) {
					response = new MDMAndroidClientResponse();
					response.setMsg(responses);
				}

			} else {
				List<Object[]> deviceAllowedPackages = deviceAllowedPackagesRepository.getDeviceAllowedPackageTab();

				for (Object[] obj : deviceAllowedPackages) {
					DeviceAllowedPackagesResponse deviceAllowedPackagesResponse = new DeviceAllowedPackagesResponse();
					deviceAllowedPackagesResponse.setAllowed_apk_tab(obj[0].toString());
					deviceAllowedPackagesResponse.setAllowed_apk_ver(obj[1].toString());
					deviceAllowedPackagesResponse.setAllowed_apk_url(obj[2].toString());
//					deviceAllowedPackagesResponse.setAllowed_apk_logo(obj[3].toString());
					deviceAllowedPackagesResponse.setAllowed_apk_package(obj[4].toString());
					deviceAllowedPackagesResponse.setAllowed_apk_name(obj[5].toString());
					responses.add(deviceAllowedPackagesResponse);
				}
				if (responses != null) {
					response = new MDMAndroidClientResponse();
					response.setMsg(responses);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;
	}

}
