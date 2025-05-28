package task.scaffold.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import task.scaffold.model.TrackingNumber;

public interface TrackingRepository  extends MongoRepository<TrackingNumber, String>{

	boolean existsByTrackingId(String trackingId);
}
