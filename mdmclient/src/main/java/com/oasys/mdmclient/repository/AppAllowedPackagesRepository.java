package com.oasys.mdmclient.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oasys.mdmclient.entity.DeviceAllowedPackages;

//public interface AppAllowedPackagesRepository extends JpaRepository<DeviceAllowedPackages, Integer> {
//
//	@Query(value = "SELECT a.allowedApkPos,a.allowedApkVersion,a.allowedApkUrl,a.allowedApkLogo,a.allowedApkPackage,a.allowedApkName FROM DeviceAllowedPackages a where a.allowedApkPos=1")
////	@Query(value = "SELECT a.allowed_apk_pos,a.allowed_apk_ver,a.allowed_apk_url,a.allowed_apk_logo,a.allowed_apk_package,a.allowed_apk_name FROM app_allowed_packages a where a.allowed_apk_pos=1",nativeQuery = true)
//	List<Object[]> getDeviceAllowedPackagePos();
//
//	@Query(value = "SELECT a.allowedApkPos,a.allowedApkVersion,a.allowedApkUrl,a.allowedApkLogo,a.allowedApkPackage,a.allowedApkName FROM DeviceAllowedPackages a where a.allowedApkPos=1")
////	@Query(value = "SELECT a.allowed_apk_pos,a.allowed_apk_ver,a.allowed_apk_url,a.allowed_apk_logo,a.allowed_apk_package,a.allowed_apk_name FROM app_allowed_packages a where a.allowed_apk_pos='1'", nativeQuery = true)
//	List<Object[]> getDeviceAllowedPackageTab();
//	
//}

@Repository
public interface AppAllowedPackagesRepository extends JpaRepository<DeviceAllowedPackages, Integer> {

	//@Query(value = "SELECT a.allowedApkPos,a.allowedApkVersion,a.allowedApkUrl,a.allowedApkLogo,a.allowedApkPackage,a.allowedApkName FROM DeviceAllowedPackages a where a.allowedApkPos=1")
	@Query(value = "SELECT a.allowed_apk_pos,a.allowed_apk_ver,a.allowed_apk_url,a.allowed_apk_logo,a.allowed_apk_package,a.allowed_apk_name FROM app_allowed_packages a where a.allowed_apk_pos='1'",nativeQuery = true)
	List<Object[]> getDeviceAllowedPackagePos();
	
	//@Query(value = "SELECT a.allowedApkTab,a.allowedApkVersion,a.allowedApkUrl,a.allowedApkLogo,a.allowedApkPackage,a.allowedApkName FROM DeviceAllowedPackages a where a.allowedApkTab=1")
	@Query(value = "SELECT a.allowed_apk_tab,a.allowed_apk_ver,a.allowed_apk_url,a.allowed_apk_logo,a.allowed_apk_package,a.allowed_apk_name FROM app_allowed_packages a where a.allowed_apk_tab='1'", nativeQuery = true)
	List<Object[]> getDeviceAllowedPackageTab();

//	@Query(value = "SELECT allowed_apk_tab,allowed_apk_ver,allowed_apk_url,allowed_apk_logo,allowed_apk_package,allowed_apk_name FROM app_allowed_packages where allowed_apk_tab=1", nativeQuery = true)
//	List<Object[]> getDeviceAllowedPackageTab();

	
}
 