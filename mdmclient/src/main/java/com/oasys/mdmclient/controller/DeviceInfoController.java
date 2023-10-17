package com.oasys.mdmclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oasys.mdmclient.request.DeviceInfoRequest;
import com.oasys.mdmclient.response.MDMAndroidClientResponse;
import com.oasys.mdmclient.service.DeviceInfoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
//@RequestMapping("/mdm/app")
public class DeviceInfoController {

	@Autowired
	DeviceInfoService deviceInfoService;

	@PostMapping(value = "/DeviceInfo", consumes = "application/x-www-form-urlencoded")
	public ResponseEntity<?> saveDeviceInfo(@RequestBody DeviceInfoRequest deviceInfo) throws Exception {
		MDMAndroidClientResponse response = deviceInfoService.saveDeviceInfo(deviceInfo);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
