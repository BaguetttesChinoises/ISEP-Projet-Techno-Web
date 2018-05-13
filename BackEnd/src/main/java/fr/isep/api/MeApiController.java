package fr.isep.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.isep.api.model.Profile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class MeApiController implements MeApi {

    private static final Logger log = LoggerFactory.getLogger(MeApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public MeApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Profile> meGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Profile>(objectMapper.readValue("{  \"last_name\" : \"last_name\",  \"promo_code\" : \"promo_code\",  \"first_name\" : \"first_name\",  \"email\" : \"email\",  \"picture\" : \"picture\"}", Profile.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Profile>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Profile>(HttpStatus.NOT_IMPLEMENTED);
    }

}
