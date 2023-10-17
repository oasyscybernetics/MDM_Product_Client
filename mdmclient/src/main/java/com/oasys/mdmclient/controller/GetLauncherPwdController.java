package com.oasys.mdmclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oasys.mdmclient.request.GetLauncherPwdRequest;
import com.oasys.mdmclient.response.MDMAndroidClientResponse;
import com.oasys.mdmclient.service.GetLauncherPwdService;

@RestController
public class GetLauncherPwdController {


	@Autowired
	GetLauncherPwdService getLauncherPwdService;

//	@PostMapping("/GetLauncherPwd")
//    public ResponseEntity<?> getLauncherPwd(@RequestBody GetLauncherPwdRequest getLaunchPwdReq) {
//		GetLauncherPwdResponse resp = null;
//		resp = getLauncherPwdService.getLauncherPwd(getLaunchPwdReq);
//        return new ResponseEntity<>(resp, HttpStatus.OK);
//    }

	@PostMapping(value = "/GetLauncherPwd")
	public ResponseEntity<?> getLauncherPwd(@RequestBody GetLauncherPwdRequest getLauncherPwdRequest) throws Exception {
		MDMAndroidClientResponse resp = null;
		resp = getLauncherPwdService.getLauncherPwd(getLauncherPwdRequest);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
}
