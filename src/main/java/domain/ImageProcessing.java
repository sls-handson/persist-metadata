package domain;

import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "ImageProcessing")
public class ImageProcessing {
	@DynamoDBHashKey
	private String username;
	@DynamoDBAttribute
	private String faceId;
	@DynamoDBAttribute
	private String s3bucket;
	@DynamoDBAttribute
	private String s3key;
	@DynamoDBAttribute
	private Map<String, String> thumbnail;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFaceId() {
		return faceId;
	}

	public void setFaceId(String faceId) {
		this.faceId = faceId;
	}

	public String getS3bucket() {
		return s3bucket;
	}

	public void setS3bucket(String s3bucket) {
		this.s3bucket = s3bucket;
	}

	public String getS3key() {
		return s3key;
	}

	public void setS3key(String s3key) {
		this.s3key = s3key;
	}

	public Map<String, String> getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(Map<String, String> thumbnail) {
		this.thumbnail = thumbnail;
	}

}
