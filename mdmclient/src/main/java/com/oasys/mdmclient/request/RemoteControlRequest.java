package com.oasys.mdmclient.request;

import lombok.Data;

@Data
public class RemoteControlRequest {

	private String device_id;
	private String remote_url;
	private String remote_pwd;

}