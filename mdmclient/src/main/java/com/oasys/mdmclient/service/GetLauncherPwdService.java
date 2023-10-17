package com.oasys.mdmclient.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oasys.mdmclient.entity.DeviceMaster;
import com.oasys.mdmclient.repository.DeviceMasterRepository;
import com.oasys.mdmclient.request.GetLauncherPwdRequest;
import com.oasys.mdmclient.response.GetLauncherPwdResponse;
import com.oasys.mdmclient.response.MDMAndroidClientResponse;

@Service
public class GetLauncherPwdService {

	@Autowired
	DeviceMasterRepository deviceMasterRepository;

	public MDMAndroidClientResponse getLauncherPwd(GetLauncherPwdRequest getLaunchPwdReq) {

		MDMAndroidClientResponse response = null;

		try {
			List<GetLauncherPwdResponse> responses = new ArrayList<GetLauncherPwdResponse>();
			DeviceMaster deviceMaster = deviceMasterRepository
					.findLauncherPwdByDeviceId(getLaunchPwdReq.getDevice_id());
			Optional<DeviceMaster> optionalDeviceInfo = Optional.ofNullable(deviceMaster);
			if (optionalDeviceInfo.isPresent()) {
				deviceMaster = optionalDeviceInfo.get();
				GetLauncherPwdResponse getLauncherPwdResponse = new GetLauncherPwdResponse();
				getLauncherPwdResponse.setLauncher_pwd(deviceMaster.getLauncherPwd());
				responses.add(getLauncherPwdResponse);
				if (responses != null) {
					response = new MDMAndroidClientResponse();
					response.setMsg(responses);
				}
			} else {
				response = new MDMAndroidClientResponse();
				response.setMsg("Failed");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;
	}

}
