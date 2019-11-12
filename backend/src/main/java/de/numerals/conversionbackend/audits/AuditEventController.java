package de.numerals.conversionbackend.audits;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(path = "auditEvent")
@Api(value = "auditEvent", tags = {"AuditEventController"})
public class AuditEventController {
    private static final Logger logger = LoggerFactory.getLogger(AuditEventController.class);

    @Autowired
    private AuditEventRepository auditEventDataRepository;

    @ApiOperation(value = "Return all audit events",
            response = AuditEvent.class,
            responseContainer = "List")
    @GetMapping(path = "/all", produces = "application/json")
    public @ResponseBody
    Iterable<AuditEvent> getAllAuditEvents() {
        // This returns a JSON or XML with the inputData elements
        return auditEventDataRepository.findAll();
    }

    @ApiOperation(value = "Return an audit event with an id",
            response = AuditEvent.class)
    @GetMapping(path = "/", produces = "application/json")
    public ResponseEntity<AuditEvent> getAuditEventById(String uuid) {
        //This returns the input Data object.
        AuditEvent auditEvent = auditEventDataRepository.findById(UUID.fromString(uuid));
        if (auditEvent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(auditEvent, HttpStatus.OK);
        }
    }


}
