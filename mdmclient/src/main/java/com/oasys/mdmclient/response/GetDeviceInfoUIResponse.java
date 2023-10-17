package com.oasys.mdmclient.response;

import lombok.Data;

@Data
public class GetDeviceInfoUIResponse {

	private String deviceId;
	private String deviceModel;
	private String deviceInternalStorage;
	private String deviceExternalStorage;
	private int deviceUserAppCount;
	private String deviceBatteryLevel;
	private String deviceTemprature;
	private String deviceRam;
	private String deviceStorageUsed;
	private String deviceManufacturer;
	private String deviceOsVersion;
	private String deviceIp;
	private String deviceMac;
	private String deviceLat;
	private String deviceLong;
	private String deviceSim1IMEI;
	private String deviceSim2IMEI;
	private String deviceSno;
	private String deviceSim1No;
	private String deviceSim2No;
	private String createdDate;
	private Long minuteDiff;
}
