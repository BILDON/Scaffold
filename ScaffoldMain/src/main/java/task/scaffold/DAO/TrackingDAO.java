package task.scaffold.DAO;

import java.math.BigDecimal;
import java.util.UUID;

import org.hibernate.validator.constraints.NotBlank;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class TrackingDAO {
	 @NotBlank
	 @Pattern(regexp = "^[A-Z]{2}$", message = "provide Origin country in ISO 3166-1 alpha-2 code")
	    private String origin_country_id;

	    @NotBlank
	    @Pattern(regexp = "^[A-Z]{2}$", message = "provide destination country in ISO 3166-1 alpha-2 code")
	    private String destination_country_id;

	    @Digits(integer = 5, fraction = 3)
	    private BigDecimal weight;

	    @NotBlank
	    private String created_at;

	    @NotNull
	    private UUID customer_id;

	    @NotBlank
	    private String customer_name;

	    @NotBlank
	    @Pattern(
	            regexp = "^[a-z0-9]+(-[a-z0-9]+)*$",
	            message = "customer_slug must be in slug-case ")
	    private String customer_slug;

}
