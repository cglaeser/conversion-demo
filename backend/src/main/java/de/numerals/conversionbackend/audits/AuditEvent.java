package de.numerals.conversionbackend.audits;

import de.numerals.conversionbackend.conversion.ConversionResultDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.UUID;

/**
 * The audit event contains the current time, the http result code and the conversion result dto, which contains the requested conversion method, the value it was converted to (if any)
 */
@Api
public class AuditEvent {
    @ApiModelProperty(position = 1, dataType = "string", example = "b9039394-83e8-45aa-a97c-70b9468a3698", notes = "The audit event uuid")
    private UUID id;
    @ApiModelProperty(position = 2, dataType = "int", example = "200", notes = "The http status as defined in RFC7231")
    private int httpStatus;
    @ApiModelProperty(position = 3, notes = "The time the event took place")
    private Date timestamp;
    @ApiModelProperty(position = 4, notes = "The conversion")
    private ConversionResultDTO conversionResult;

    /**
     * Default constructor
     */
    public AuditEvent() {
        id = UUID.randomUUID();
        timestamp = new Date();
    }

    /**
     * @param conversionResult The conversion result that was returned
     */
    public AuditEvent(ConversionResultDTO conversionResult) {
        this();
        this.conversionResult = conversionResult;
    }

    public AuditEvent(HttpStatus httpStatus, ConversionResultDTO conversionResult) {
        this(conversionResult);
        this.httpStatus = httpStatus.value();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public ConversionResultDTO getConversionResult() {
        return conversionResult;
    }

    public void setConversionResult(ConversionResultDTO conversionResult) {
        this.conversionResult = conversionResult;
    }


    @Override
    public String toString() {
        return "AuditEvent{" +
                "id=" + id +
                ", httpStatus=" + httpStatus +
                ", timestamp=" + timestamp +
                ", conversionResult=" + conversionResult +
                '}';
    }
}
