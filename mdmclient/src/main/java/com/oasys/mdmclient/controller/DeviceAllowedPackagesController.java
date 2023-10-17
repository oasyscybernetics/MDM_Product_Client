package com.oasys.mdmclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oasys.mdmclient.request.DeviceAllowedPackageRequest;
import com.oasys.mdmclient.response.MDMAndroidClientResponse;
import com.oasys.mdmclient.service.DeviceAllowedPackagesService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

//@RestController
//public class DeviceAllowedPackageController {
//
//	@Autowired
//	DeviceAllowedPackageService deviceAllowedPackageService;
//
////	@PostMapping("/DeviceAllowedPackage")
//	@PostMapping(value = "/DeviceAllowedPackage", consumes = "application/x-www-form-urlencoded")
//	public ResponseEntity<?> deviceAllowedPackage(@RequestBody DeviceAllowedPackageRequest devAllowedPackageRequest)
//			throws Exception {
//
//		return ResponseEntity.ok(deviceAllowedPackageService.getDeviceAllowedPackage(devAllowedPackageRequest));
//
//	}
//}

@RestController
public class DeviceAllowedPackagesController {

	@Autowired
	DeviceAllowedPackagesService devicwAllowedPackagesService;

	@PostMapping(value = "/DeviceAllowedPackage", consumes = "application/x-www-form-urlencoded")
	// @PostMapping(value="/DeviceAllowedPackage")
	public ResponseEntity<?> getDeviceAllowedPackage(@RequestBody DeviceAllowedPackageRequest deviceHeartBeatReq)
			throws Exception {

		MDMAndroidClientResponse response = null;

		response = devicwAllowedPackagesService.getDeviceAllowedPackage(deviceHeartBeatReq);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}