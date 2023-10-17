package com.oasys.mdmclient.response;

import lombok.Data;

@Data
public class DeviceAllowedPackagesResponse {
	private String allowed_apk_pos;
	private String allowed_apk_ver;
	private String allowed_apk_url;
	private String allowed_apk_logo;
	private String allowed_apk_package;
	private String allowed_apk_name;
	private String allowed_apk_tab;
}
