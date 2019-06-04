package com.pichincha;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DevOpsSpringRestController {

    protected static final String STATIC_REST_API_KEY = "2f5ae96c-b558-4c7b-a590-a501ae1c3f6c";
    private Logger log = LoggerFactory.getLogger(DevOpsSpringRestController.class);

    @RequestMapping(path = "/DevOps", method= RequestMethod.POST)
    public ResponseEntity<GenericResponseMessage> genericMessageInformation(@RequestBody GenericPostMessageInformation genericMessageInformation, @RequestHeader(value="X-Parse-REST-API-Key") String restApiKey) {
        GenericResponseMessage genericResponseMessage =
                new GenericResponseMessage("Hello "
                        + genericMessageInformation.getTo()
                        + " your message will be send");
        if (!restApiKey.isEmpty() && restApiKey.compareTo(STATIC_REST_API_KEY) == 0) {
            return new ResponseEntity<>(genericResponseMessage, HttpStatus.OK);
        }
        else {
            genericResponseMessage = new GenericResponseMessage("ERROR");
            return new ResponseEntity<>(genericResponseMessage, HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(path = "/DevOps", method= RequestMethod.GET)
    public ResponseEntity<GenericResponseMessage> getMethodErrorMessage() {
        return getErrorMessageForOtherHttpMethods();
    }

    @RequestMapping(path = "/DevOps", method= RequestMethod.DELETE)
    public ResponseEntity<GenericResponseMessage> deleteMethodErrorMessage() {
        return getErrorMessageForOtherHttpMethods();
    }

    @RequestMapping(path = "/DevOps", method= RequestMethod.PUT)
    public ResponseEntity<GenericResponseMessage> putMethodErrorMessage() {
        return getErrorMessageForOtherHttpMethods();
    }

    private ResponseEntity<GenericResponseMessage> getErrorMessageForOtherHttpMethods() {
        GenericResponseMessage genericResponseMessage = new GenericResponseMessage("ERROR");
        return new ResponseEntity<>(genericResponseMessage, HttpStatus.OK);
    }
}

