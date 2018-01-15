package functions;

import java.util.List;
import java.util.Map;

import domain.ImageProcessing;
import functions.Function.Input;
import repository.ImageProcessingRepository;

public class Function implements java.util.function.Function<Input, Input> {

	private final ImageProcessingRepository repository;

	public Function(ImageProcessingRepository repository) {
		this.repository = repository;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Input apply(final Input t) {
		//	    const dynamoItem = {
		//	            Username: event.userId,
		//	            s3key: event.s3Key,
		//	            s3bucket: event.s3Bucket
		//	        };
		//
		//	        var indexDetails = event['parallelResult'][0];
		//	        var thumbnailDetails = event['parallelResult'][1];
		//	        dynamoItem['faceId'] = indexDetails['FaceId'];
		//	        dynamoItem['thumbnail'] = thumbnailDetails['thumbnail'];
		//	        docClient.put({
		//	            TableName: tableName,
		//	            Item: dynamoItem
		//	            // uncomment below if you want to disallow overwriting if the user is already in the table
		//	            //   ,ConditionExpression: 'attribute_not_exists (Username)'
		//	        }).promise().then(data => {
		//	            callback(null, data);
		//	        }).catch(err => {
		//	            callback(err);
		//	        })
		final ImageProcessing dynamoItem = new ImageProcessing();
		dynamoItem.setUsername(t.getUserId());
		dynamoItem.setS3key(t.getS3Key());
		dynamoItem.setS3bucket(t.getS3Bucket());
		final Map<String, Object> indexDetails = t.getParallelResult().get(0);
		final Map<String, Object> thumbnailDetails = t.getParallelResult().get(1);
		dynamoItem.setFaceId(String.valueOf(indexDetails.get("FaceId")));
		dynamoItem.setThumbnail((Map<String, String>) thumbnailDetails.get("thumbnail"));
		repository.save(dynamoItem);
		return t;
	}

	public static final class Input {
		private String userId, s3Key, s3Bucket, collectionId;
		private List<Map<String, Object>> parallelResult;

		public String getS3Key() {
			return s3Key;
		}

		public void setS3Key(String s3Key) {
			this.s3Key = s3Key;
		}

		public String getS3Bucket() {
			return s3Bucket;
		}

		public void setS3Bucket(String s3Bucket) {
			this.s3Bucket = s3Bucket;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public List<Map<String, Object>> getParallelResult() {
			return parallelResult;
		}

		public void setParallelResult(List<Map<String, Object>> parallelResult) {
			this.parallelResult = parallelResult;
		}

		public String getCollectionId() {
			return collectionId;
		}

		public void setCollectionId(String collectionId) {
			this.collectionId = collectionId;
		}

	}

}
