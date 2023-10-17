package com.oasys.mdmclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oasys.mdmclient.request.DeviceInfoZMQRequest;
import com.oasys.mdmclient.service.DeviceInfoZMQService;

@RestController
public class DeviceInfoZMQController {

	private static final Logger log = LoggerFactory.getLogger(DeviceInfoZMQController.class);

	@Autowired
	DeviceInfoZMQService deviceInfoZMQService;

	@PostMapping("/DeviceInfoZMQ")
	public ResponseEntity<?> deviceInfoZMQ(@RequestBody DeviceInfoZMQRequest request) throws InterruptedException {
		String resp = null;
		resp = deviceInfoZMQService.publishDeviceInfo(request);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

}
