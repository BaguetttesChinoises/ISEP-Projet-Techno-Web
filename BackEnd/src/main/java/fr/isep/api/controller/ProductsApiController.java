package fr.isep.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.isep.api.model.Product;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductsApiController implements ProductsApi {

    private static final Logger log = LoggerFactory.getLogger(ProductsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ProductsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Product>> productsGet(@NotNull @ApiParam(value = "Latitude component of location.", required = true) @Valid @RequestParam(value = "latitude", required = true) Double latitude, @NotNull @ApiParam(value = "Longitude component of location.", required = true) @Valid @RequestParam(value = "longitude", required = true) Double longitude) {
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
