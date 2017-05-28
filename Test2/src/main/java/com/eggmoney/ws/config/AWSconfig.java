package com.eggmoney.ws.config;

import org.springframework.stereotype.Component;

@Component
public class AWSconfig {
	private final ProjectProperties projectProperties;

	public AWSconfig(ProjectProperties projectProperties) {
		this.projectProperties = projectProperties;
	}
	
	String regions;
	String accessKey;
	String secretKey;
	String bucketName;

	public ProjectProperties getProjectProperties() {
		return projectProperties;
	}

	public String getRegions() {
		return regions;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public String getBucketName() {
		return bucketName;
	}
}
