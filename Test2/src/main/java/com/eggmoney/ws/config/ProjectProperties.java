package com.eggmoney.ws.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix="test-project", ignoreUnknownFields=false)
public class ProjectProperties {
	
	private final Aws aws = new Aws();
	
	public Aws getAws() {
		return aws;
	}

	@Data public static class Aws{
		private String regions;
		private String accessKey;
		private String secretKey;
		private String bucketName;
	}
}
