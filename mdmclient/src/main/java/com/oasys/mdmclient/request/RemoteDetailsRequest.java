package com.oasys.mdmclient.request;

import lombok.Data;

@Data
public class RemoteDetailsRequest {

	private String device_id;
	private String remotesession_id;
	private String remote_pwd;

}
