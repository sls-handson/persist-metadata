package config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.cloud.function.context.FunctionScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.TableNameOverride;

@FunctionScan
@Configuration
@EnableDynamoDBRepositories(basePackages = "repository", dynamoDBMapperConfigRef = "dynamoDBMapperConfig")
public class Config {

	private final Properties properties;

	public Config(Properties properties) {
		//this.credentialsProvider = credentialsProvider;
		this.properties = properties;
	}

	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		final AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder
				.standard()
				.withRegion(this.properties.getRegion())
				.build();
		return amazonDynamoDB;
	}

	@Bean
	public DynamoDBMapperConfig dynamoDBMapperConfig(TableNameOverride tableNameOverrider) {
		// Create basic DynamoDBMapperConfig builder
		DynamoDBMapperConfig.Builder builder = new DynamoDBMapperConfig.Builder();
		// Inject the table name overrider bean
		builder.setTableNameOverride(tableNameOverrider);
		return builder.build();
	}

	@Bean
	public TableNameOverride tableNameOverrider() {
		return TableNameOverride.withTableNamePrefix(this.properties.getDynamoDBTablePrefix());

	}
}
