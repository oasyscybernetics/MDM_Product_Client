package com.oasys.mdmclient.request;

import lombok.Data;

@Data
public class EnrollDeviceRequest {

	private String device_id;
	private String device_name;
	private String device_status;
	private String branch;
	private String mobileNumber;

}