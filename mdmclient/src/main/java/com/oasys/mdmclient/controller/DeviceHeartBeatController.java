package com.oasys.mdmclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oasys.mdmclient.request.DeviceHeartBeatRequest;
import com.oasys.mdmclient.response.DeviceHeartBeatResponse;
import com.oasys.mdmclient.service.DeviceHeartBeatService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class DeviceHeartBeatController {

	@Autowired
	DeviceHeartBeatService deviceHeartBeatService;

	@PostMapping(value = "/DeviceHeartBeat", consumes = "application/x-www-form-urlencoded")
	public ResponseEntity<?> getDeviceHeartBeat(@RequestBody DeviceHeartBeatRequest deviceHeartBeatReq)
			throws Exception {

		DeviceHeartBeatResponse response = null;

		response = deviceHeartBeatService.getDeviceHeartBeat(deviceHeartBeatReq);
   
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
}
