package com.oasys.mdmclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oasys.mdmclient.request.RemoteDetailsRequest;
import com.oasys.mdmclient.response.MDMAndroidClientResponse;
import com.oasys.mdmclient.service.RemoteDetailsService;

@RestController
public class RemoteDetailsController {

	@Autowired
	RemoteDetailsService remoteDetailsService;

	@PostMapping(value = "/RemoteDetails")
	public ResponseEntity<?> getRemoteSession(@RequestBody RemoteDetailsRequest remoteDetailsRequest) throws Exception {

		MDMAndroidClientResponse response = null;

		response = remoteDetailsService.getRemoteSession(remoteDetailsRequest);

		return new ResponseEntity<>(response, HttpStatus.OK);

	}
}
