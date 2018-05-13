package fr.isep.api;

import fr.isep.model.PriceEstimate;
import fr.isep.model.Product;
import java.util.UUID;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class EstimatesApiController implements EstimatesApi {

    private static final Logger log = LoggerFactory.getLogger(EstimatesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public EstimatesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<PriceEstimate>> estimatesPriceGet(@NotNull @ApiParam(value = "Latitude component of start location.", required = true) @Valid @RequestParam(value = "start_latitude", required = true) Double startLatitude,@NotNull @ApiParam(value = "Longitude component of start location.", required = true) @Valid @RequestParam(value = "start_longitude", required = true) Double startLongitude,@NotNull @ApiParam(value = "Latitude component of end location.", required = true) @Valid @RequestParam(value = "end_latitude", required = true) Double endLatitude,@NotNull @ApiParam(value = "Longitude component of end location.", required = true) @Valid @RequestParam(value = "end_longitude", required = true) Double endLongitude) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<PriceEstimate>>(objectMapper.readValue("[ {  \"high_estimate\" : 6.02745618307040320615897144307382404804229736328125,  \"product_id\" : \"product_id\",  \"low_estimate\" : 0.80082819046101150206595775671303272247314453125,  \"surge_multiplier\" : 1.46581298050294517310021547018550336360931396484375,  \"estimate\" : \"estimate\",  \"display_name\" : \"display_name\",  \"currency_code\" : \"currency_code\"}, {  \"high_estimate\" : 6.02745618307040320615897144307382404804229736328125,  \"product_id\" : \"product_id\",  \"low_estimate\" : 0.80082819046101150206595775671303272247314453125,  \"surge_multiplier\" : 1.46581298050294517310021547018550336360931396484375,  \"estimate\" : \"estimate\",  \"display_name\" : \"display_name\",  \"currency_code\" : \"currency_code\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<PriceEstimate>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<PriceEstimate>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Product>> estimatesTimeGet(@NotNull @ApiParam(value = "Latitude component of start location.", required = true) @Valid @RequestParam(value = "start_latitude", required = true) Double startLatitude,@NotNull @ApiParam(value = "Longitude component of start location.", required = true) @Valid @RequestParam(value = "start_longitude", required = true) Double startLongitude,@ApiParam(value = "Unique customer identifier to be used for experience customization.") @Valid @RequestParam(value = "customer_uuid", required = false) UUID customerUuid,@ApiParam(value = "Unique identifier representing a specific product for a given latitude & longitude.") @Valid @RequestParam(value = "product_id", required = false) String productId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Product>>(objectMapper.readValue("[ {  \"image\" : \"image\",  \"product_id\" : \"product_id\",  \"description\" : \"description\",  \"display_name\" : \"display_name\",  \"capacity\" : \"capacity\"}, {  \"image\" : \"image\",  \"product_id\" : \"product_id\",  \"description\" : \"description\",  \"display_name\" : \"display_name\",  \"capacity\" : \"capacity\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Product>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
