package com.oasys.mdmclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oasys.mdmclient.request.EnrollDeviceRequest;
import com.oasys.mdmclient.response.DeviceMasterResponse;
import com.oasys.mdmclient.service.EnrollDeviceService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class EnrollDeviceController {

//	private static final Logger log = LoggerFactory.getLogger(EnrollDeviceController.class);

	@Autowired
	EnrollDeviceService enrollDeviceService;

	// used to insert the information about the device in device_master table
	@PostMapping(value = "/EnrollDevice", consumes = "application/x-www-form-urlencoded")
	public ResponseEntity<DeviceMasterResponse> saveDeviceMaster(@RequestBody EnrollDeviceRequest enrollDevice) throws Exception {
		DeviceMasterResponse response = enrollDeviceService.saveDeviceMaster(enrollDevice);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
                 	
}