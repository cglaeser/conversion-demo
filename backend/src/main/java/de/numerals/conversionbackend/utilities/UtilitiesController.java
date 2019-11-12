package de.numerals.conversionbackend.utilities;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

/**
 * Get information regarding the application (this file was added from a previous project to include a useful backend)
 *
 * @author cgl
 */
@RestController
@Api(value = "Utilities", tags = {"Utilities"})
public class UtilitiesController {

    @Value("${server.port}")
    private String SERVER_PORT;

    @Autowired
    PropertyUtilities propertyUtilities;

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<String> index() {
        StringBuilder responseString = new StringBuilder();
        responseString.append("<h1>The conversion backend is up and running on port " + SERVER_PORT + "</h1>");
        responseString.append("<p>Build date: " + propertyUtilities.getUTCBuildDate() + "</p>");
        responseString.append("<p>Version: " + propertyUtilities.getVersion() + "</p>");
        responseString.append("<p>Artifact: " + propertyUtilities.getArtifactId() + "</p>");
        responseString.append("<p>Go to <a href=\"./swagger-ui.html\">API</a></p>");
        ResponseEntity<String> response = new ResponseEntity<String>(responseString.toString(), HttpStatus.OK);
        return response;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/info/port")
    public ResponseEntity<String> port() {
        return new ResponseEntity<String>(SERVER_PORT, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/info/version")
    public ResponseEntity<String> version() {
        String version;
        version = propertyUtilities.getVersion();
        return new ResponseEntity<String>(version, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/info/build")
    public ResponseEntity<String> build() {
        ZonedDateTime zonedDateTime;
        zonedDateTime = propertyUtilities.getUTCBuildDate();
        return new ResponseEntity<String>(zonedDateTime.toString(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/info/artifact")
    public ResponseEntity<String> artifact() {
        String artifactId;
        artifactId = propertyUtilities.getArtifactId();
        return new ResponseEntity<String>(artifactId.toString(), HttpStatus.OK);
    }

}
