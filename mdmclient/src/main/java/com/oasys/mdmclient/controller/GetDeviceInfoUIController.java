package com.oasys.mdmclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oasys.mdmclient.request.GetDeviceInfoUIRequest;
import com.oasys.mdmclient.response.GenericResponse;
import com.oasys.mdmclient.service.GetDeviceInfoUIService;

@RestController
public class GetDeviceInfoUIController {

	private static final Logger log = LoggerFactory.getLogger(GetDeviceInfoUIController.class);

	@Autowired
	GetDeviceInfoUIService getDeviceInfoUIService;

	@PostMapping(value = "/getDeviceInfoUI")
	public ResponseEntity<?> getDeviceInfoUI(@RequestBody GetDeviceInfoUIRequest getDeviceInfoUIRequest)
			throws Exception {
		log.info("<-- Starts GetDeviceInfoUIController.getDeviceInfoUI-->");
		GenericResponse resp = null;
		resp = getDeviceInfoUIService.getDeviceInfoUI(getDeviceInfoUIRequest);
		log.info("<-- Ends GetDeviceInfoUIController.getDeviceInfoUI-->");
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
}
