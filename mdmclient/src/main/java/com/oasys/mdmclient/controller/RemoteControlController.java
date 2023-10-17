package com.oasys.mdmclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oasys.mdmclient.request.RemoteControlRequest;
import com.oasys.mdmclient.service.RemoteControlService;

@RestController
public class RemoteControlController {

    @Autowired
	private RemoteControlService remoteControlService;

    @PostMapping("/RemoteControlZMQ")
	public String remoteControlZMQ(@RequestBody RemoteControlRequest request) {
        return remoteControlService.processRemoteControl(request);
    }
}
