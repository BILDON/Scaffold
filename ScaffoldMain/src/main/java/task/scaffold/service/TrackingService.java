package task.scaffold.service;

import java.security.SecureRandom;
import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import task.scaffold.DAO.TrackingDAO;
import task.scaffold.model.TrackingNumber;
import task.scaffold.repository.TrackingRepository;

@Service
public class TrackingService {
	@Autowired
	private  TrackingRepository repository;

    private static final String TRACKING_REGEX = "^[A-Z0-9]{1,16}$";
    private final SecureRandom random = new SecureRandom();

	public TrackingNumber generateTrackingNumber(@Valid TrackingDAO dto) {
		String trackingNumber;

        // Generate until unique
        do {
            trackingNumber = generateRandomCode(12);  // Adjust length if needed
        } while (repository.existsByTrackingId(trackingNumber));

        TrackingNumber tracking = TrackingNumber.builder()
                .trackingId(trackingNumber)
                .created_at(dto.getCreated_at())
                .origin_country_id(dto.getOrigin_country_id())
                .destination_country_id(dto.getDestination_country_id())
                .weight(dto.getWeight())
                .customer_id(dto.getCustomer_id())
                .customer_name(dto.getCustomer_name())
                .customer_slug(dto.getCustomer_slug())
                .inserted_on(OffsetDateTime.now().toString())
                .build();

        return repository.save(tracking);
	}

	private String generateRandomCode(int length) {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
	}

}
