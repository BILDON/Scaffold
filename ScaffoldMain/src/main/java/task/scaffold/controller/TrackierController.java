package task.scaffold.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import task.scaffold.DAO.TrackingDAO;
import task.scaffold.model.TrackingNumber;
import task.scaffold.service.TrackingService;

@RestController
@RequestMapping("/next-tracking-number")
public class TrackierController {
	
	@Autowired
	private  TrackingService service;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getTrackingNumber(@Valid TrackingDAO dto) {
        TrackingNumber tracking = service.generateTrackingNumber(dto);

        Map<String, Object> response = new HashMap<>();
        response.put("tracking_number", tracking.getTrackingId());
        response.put("created_at", tracking.getInserted_on().toString());
        response.put("customer_name", tracking.getCustomer_name().toString());

        return ResponseEntity.ok(response);
    }

}
