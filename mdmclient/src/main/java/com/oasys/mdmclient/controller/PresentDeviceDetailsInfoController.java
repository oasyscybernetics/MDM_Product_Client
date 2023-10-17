package com.oasys.mdmclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oasys.mdmclient.request.PresentDeviceDetailsInfoRequest;
import com.oasys.mdmclient.response.DeviceHeartBeatResponse;
import com.oasys.mdmclient.service.PresentDeviceDetailsInfoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class PresentDeviceDetailsInfoController {

//	@Autowired
//	PresentDeviceDetailsInfoService presentDeviceDetailsInfoService;
//
////	@PostMapping(value = "/DeviceDetailsInfo", consumes = "application/x-www-form-urlencoded")
//	@PostMapping(value = "/DeviceDetailsInfo")
//	public ResponseEntity<?> getDeviceDetailsInfo(@RequestBody PresentDeviceDetailsInfoRequest perDetailsInfoRequest)
//			throws Exception {
//
//		DeviceHeartBeatResponse response = null;
//
//		response = presentDeviceDetailsInfoService.getDeviceDetailsInfo(perDetailsInfoRequest);
//   
//		return new ResponseEntity<>(response, HttpStatus.OK);
//
//	}
}
