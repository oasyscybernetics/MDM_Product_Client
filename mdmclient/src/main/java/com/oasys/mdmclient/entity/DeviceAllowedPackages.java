package com.oasys.mdmclient.entity;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

//@Entity
//@Table(name = "app_allowed_packages")
//@Data
// @NoArgsConstructor
// @AllArgsConstructor
@Entity
@Table(
    name = "app_allowed_packages",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})}
)
@Data
public class DeviceAllowedPackages {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@CreationTimestamp
	@Column(name = "create_dt")
	private java.sql.Timestamp createDt;

	@Column(name = "allowed_apk_ver", length = 20)
	private String allowedApkVersion;

	@Column(name = "allowed_apk_url", length = 200)
	private String allowedApkUrl;

	@Column(name = "allowed_apk_package", length = 100)
	private String allowedApkPackage;

	@Column(name = "allowed_apk_name", length = 100)
	private String allowedApkName;

	@Column(name = "allowed_apk_tab", length = 1)
	private String allowedApkTab;

	@Column(name = "allowed_apk_pos", length = 1)
	private String allowedApkPos;

	@Column(name = "allowed_apk_status", length = 1)
	private String allowedApkStatus;

	@Column(name = "allowed_apk_logo", length = 200)
	private String allowedApkLogo;
}