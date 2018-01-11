package config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("app")
public class Properties {
	private String region,dynamoDBTablePrefix;

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDynamoDBTablePrefix() {
		return dynamoDBTablePrefix;
	}

	public void setDynamoDBTablePrefix(String dynamoDBTablePrefix) {
		this.dynamoDBTablePrefix = dynamoDBTablePrefix;
	}


}
