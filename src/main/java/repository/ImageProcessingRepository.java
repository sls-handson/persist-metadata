package repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import domain.ImageProcessing;

@EnableScan
public interface ImageProcessingRepository extends CrudRepository<ImageProcessing, String> {

}
