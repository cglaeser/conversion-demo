package de.numerals.conversionbackend.utilities;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * This class grants access to some properties of the compiled thinkprint jar.
 *
 * @author lru
 */
@Service
public class PropertyUtilities {

    @Autowired
    BuildProperties buildProperties;

    public ZonedDateTime getUTCBuildDate() {
        ZonedDateTime zonedDateTime;
        zonedDateTime = buildProperties.getTime().atZone(ZoneId.systemDefault());

        return zonedDateTime;
    }

    public String getVersion() {
        String version;
        version = buildProperties.getVersion();
        return version;
    }

    public String getArtifactId() {
        String artifactId;
        artifactId = buildProperties.getArtifact();
        return artifactId;
    }

}
