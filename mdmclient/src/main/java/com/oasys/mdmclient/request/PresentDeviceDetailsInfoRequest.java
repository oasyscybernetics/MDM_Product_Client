package com.oasys.mdmclient.request;

import lombok.Data;

@Data
public class PresentDeviceDetailsInfoRequest {

	private String deviceId;
	private String deviceInternalStorage;
	private String deviceExternalStorage;
	private Integer deviceUserAppCount;
	private Integer deviceSysAppCount;
	private String deviceBatteryLevel;
	private String deviceTemperature;
	private String deviceLatitude;
	private String deviceLongitude;

}
