# DEPLOY

	mvn clean package -Dno=xxx
	sls deploy --no xxx

	e.g. sls deploy --no a001

# Invoke

	sls invoke -f put -p event.json --no a001


# e.g.
## maven build
```
E:\workspaces\e.4.7.2\persist-metadata>mvn clean package -Dno=a001
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building aws-spring-cloud-function-maven dev
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- maven-clean-plugin:2.6.1:clean (default-clean) @ aws-spring-cloud-function-maven ---
[INFO] Deleting E:\workspaces\e.4.7.2\persist-metadata\target
～～～～～～
[INFO] Attaching shaded artifact.
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 6.978 s
[INFO] Finished at: 2018-01-10T18:04:36+09:00
[INFO] Final Memory: 87M/402M
[INFO] ------------------------------------------------------------------------

E:\workspaces\e.4.7.2\persist-metadata>
```
## serverless deploy
```
E:\workspaces\e.4.7.2\persist-metadata>sls deploy --no a001
Serverless: Packaging service...
Serverless: Creating Stack...
Serverless: Checking Stack create progress...
.....
Serverless: Stack create finished...
Serverless: Uploading CloudFormation file to S3...
Serverless: Uploading artifacts...
Serverless: Validating template...
Serverless: Updating Stack...
Serverless: Checking Stack update progress...
...............
Serverless: Stack update finished...
Service Information
service: a001-persist-metadata
stage: dev
region: us-east-1
stack: a001-persist-metadata-dev
api keys:
  None
endpoints:
  None
functions:
  put: a001-persist-metadata-dev-put

E:\workspaces\e.4.7.2\persist-metadata>
```
## Invoke
```
E:\workspaces\e.4.7.2\persist-metadata>sls invoke -f put -p event.json --no a001
{
    "userId": "johndoe",
    "s3Key": "1_happy_face.jpg",
    "s3Bucket": "wildrydes-riderphotos-johndoe",
    "collectionId": null,
    "parallelResult": [
        {
            "FaceId": "00f884e1-31d4-5b7f-bcb2-bc91a51d3713",
            "BoundingBox": {
                "Width": 0.476666659116745,
                "Height": 0.7149999737739563,
                "Left": 0.4977777898311615,
                "Top": 0.09000000357627869
            },
            "ImageId": "fbda5555-463d-5964-acef-035061fb819f",
            "ExternalImageId": "johndoe",
            "Confidence": 99.92555236816406
        },
        {
            "thumbnail": {
                "s3key": "resized-1_happy_face.jpg",
                "s3bucket": "wildrydes-riderphotos-thumbnails-johndoe"
            }
        }
    ]
}

E:\workspaces\e.4.7.2\persist-metadata>
```