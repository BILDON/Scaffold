package task.scaffold.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Document(collection = "trackingNumber")
@Data
@Builder
public class TrackingNumber {
	
	@Id
    private String id;

    private String trackingId;

    private String created_at;

    private String origin_country_id;
    private String destination_country_id;
    private BigDecimal weight;
    private UUID customer_id;
    private String customer_name;
    private String customer_slug;
    private String inserted_on ;
   

}
