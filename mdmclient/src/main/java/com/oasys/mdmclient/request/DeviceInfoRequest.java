package com.oasys.mdmclient.request;

import lombok.Data;

@Data
public class DeviceInfoRequest {
	private String device_id;
	private String device_model;
	private String device_internal_storage;
	private String device_external_storage;
	private Integer device_user_app_count;
	private Integer device_sys_app_count;
	private String device_battery_level;
	private String device_temprature;
	private String device_ram;
	private String device_storage_used;
	private String device_manufacturer;
	private String device_os_version;
	private String device_ip;
	private String device_mac;
	private String device_lat;
	private String device_long;
	private String time;
	private String device_Sim1_IMEI;
	private String device_Sim2_IMEI;
	private String device_sno;
	private String device_sim1_no;
	private String device_sim2_no;
	private String signal_strength;
	private String internet_connection;
	private String battery_plugged;
	private String battery_health;
	private String battery_technology;
	
}

