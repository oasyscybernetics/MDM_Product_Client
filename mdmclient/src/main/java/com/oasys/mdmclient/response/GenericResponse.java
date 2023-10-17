package com.oasys.mdmclient.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class GenericResponse implements Serializable {

	private static final long serialVersionUID = 1L;

//	private String status;
//	private String errorDescription;
//	private String errorCode;
	private String userDisplayMesg;
	private Object Data;
//	private String deviceStatus;

	// private Long recordCount;
	// List<?> responseContents;
	// Object responseContent;

//	public String getDeviceStatus() {
//		return deviceStatus;
//	}
//
//	public void setDeviceStatus(String deviceStatus) {
//		this.deviceStatus = deviceStatus;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	public String getErrorCode() {
//		return errorCode;
//	}
//
//	public void setErrorCode(String errorCode) {
//		this.errorCode = errorCode;
//	}

	public String getUserDisplayMesg() {
		return userDisplayMesg;
	}

	public void setUserDisplayMesg(String userDisplayMesg) {
		this.userDisplayMesg = userDisplayMesg;
	}

	public Object getData() {
		return Data;
	}

	public void setData(Object data) {
		Data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static GenericResponse getSuccessfulResponse(Object obj) throws Exception {
		GenericResponse GenericResponse = new GenericResponse();
		GenericResponse.setData(obj);
//		GenericResponse.setErrorCode("0");
//		GenericResponse.setStatus("S");
		GenericResponse.setUserDisplayMesg("Success");

		return GenericResponse;
	}

	public static GenericResponse getFailureResponse(String errorCode, String errorMsg) throws Exception {
		GenericResponse GenericResponse = new GenericResponse();
		GenericResponse.setData(null);
//		GenericResponse.setErrorCode(errorCode);
//		GenericResponse.setStatus("F");
		GenericResponse.setUserDisplayMesg(errorMsg);

		return GenericResponse;
	}

	public static GenericResponse setNoRecordFoundResponse(String status, String errorCode, String errorMsg)
			throws Exception {
		GenericResponse GenericResponse = new GenericResponse();
		GenericResponse.setData(null);
//		GenericResponse.setErrorCode(errorCode);
//		GenericResponse.setStatus(status);
		GenericResponse.setUserDisplayMesg(errorMsg);

		return GenericResponse;
	}

}
