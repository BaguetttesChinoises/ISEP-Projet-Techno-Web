package fr.isep.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.isep.api.model.Activities;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

@Controller
public class HistoryApiController implements HistoryApi {

    private static final Logger log = LoggerFactory.getLogger(HistoryApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public HistoryApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Activities> historyGet(@ApiParam(value = "Offset the list of returned results by this amount. Default is zero.") @Valid @RequestParam(value = "offset", required = false) Integer offset, @ApiParam(value = "Number of items to retrieve. Default is 5, maximum is 100.") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Activities>(objectMapper.readValue("{  \"offset\" : 0,  \"limit\" : 6,  \"count\" : 1,  \"history\" : [ {    \"uuid\" : \"uuid\"  }, {    \"uuid\" : \"uuid\"  } ]}", Activities.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Activities>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Activities>(HttpStatus.NOT_IMPLEMENTED);
    }

}
