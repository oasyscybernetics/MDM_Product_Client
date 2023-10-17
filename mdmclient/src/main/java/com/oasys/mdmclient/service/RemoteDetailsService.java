package com.oasys.mdmclient.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oasys.mdmclient.entity.DeviceMaster;
import com.oasys.mdmclient.repository.DeviceMasterRepository;
import com.oasys.mdmclient.request.RemoteDetailsRequest;
import com.oasys.mdmclient.response.MDMAndroidClientResponse;

import jakarta.transaction.Transactional;

@Service
public class RemoteDetailsService {

	@Autowired
	DeviceMasterRepository deviceMasterRepository;

	@Transactional
	public MDMAndroidClientResponse getRemoteSession(RemoteDetailsRequest remoteDetailsRequest) {
		MDMAndroidClientResponse response = new MDMAndroidClientResponse();
		try {
			DeviceMaster deviceMaster = deviceMasterRepository.findByDeviceId(remoteDetailsRequest.getDevice_id());
			Optional<DeviceMaster> optionalDeviceMaster = Optional.ofNullable(deviceMaster);
			if (optionalDeviceMaster.isPresent()) {
				deviceMaster = optionalDeviceMaster.get();
//				deviceMaster.setDeviceId(remoteDetailsRequest.getDevice_id());
				deviceMaster.setRemoteSessionId(remoteDetailsRequest.getRemotesession_id());

				deviceMaster.setRemotePwd(remoteDetailsRequest.getRemote_pwd());

				DeviceMaster result = deviceMasterRepository.save(deviceMaster);
				if (result.getDeviceId() != null) {
					response.setMsg("Success");
//					DeviceMaster deviceMaster = deviceMasterRepoisitory.findByDeviceId(remoteDetailsRequest.getDevice_id());
				} else {
					response.setMsg("Failed");
				}

			}

		} catch (Exception ex) {
			ex.printStackTrace();
			response = new MDMAndroidClientResponse();
			response.setMsg("Failed");
		}
		return response;
	}

}