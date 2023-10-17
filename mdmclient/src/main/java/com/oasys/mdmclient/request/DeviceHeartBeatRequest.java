package com.oasys.mdmclient.request;

import lombok.Data;

@Data
public class DeviceHeartBeatRequest {

	private String device_id;
	private String device_storage_used;
	private String device_lat;
	private String device_long;
	
}
