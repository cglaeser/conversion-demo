package de.numerals.conversionbackend.conversion;

import de.numerals.conversionbackend.audits.AuditEvent;
import de.numerals.conversionbackend.audits.AuditEventRepository;
import de.numerals.conversionbackend.conversion.common.ConversionObject;
import de.numerals.conversionbackend.conversion.common.exceptions.ArgumentOutOfRangeException;
import de.numerals.conversionbackend.conversion.common.exceptions.ConverterInvalidSelection;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for converting values to roman numerals
 */
@Api(value = "convert", tags = {"Conversion"})
@RestController    // This means that this class is a Controller
@RequestMapping(path = "convert") // This means URL's start with /demo (after Application path)
@CrossOrigin(origins = "*", maxAge = 3600)
public class ConversionController {
    Logger logger = LoggerFactory.getLogger(ConversionController.class);

    @Autowired
    private AuditEventRepository auditEventDataRepository;

    @Autowired
    private ServiceSelector serviceSelector;

    /**
     * @param conversionObject The input object which shall be converted
     * @return The result as a json object and additionally, a httpStatus Code
     */

    @PostMapping(path = "/convert")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Conversion was successful"),
            @ApiResponse(code = 416, message = "Conversion outside of range of roman numbers"),
            @ApiResponse(code = 400, message = "The request was malformed")})
    public @ResponseBody
    ResponseEntity<ConversionResultDTO> convertValueToRomanNumeral(@RequestBody ConversionObject conversionObject) {
        ConversionResultDTO conversionResult = new ConversionResultDTO();
        conversionResult.setInputValue(conversionObject.getValue());
        conversionResult.setConversion(conversionObject.getMethod());
        HttpStatus httpStatus;
        try {
            String romanValue = serviceSelector.getConverter(conversionObject.getMethod()).setRadix(conversionObject.getRadix()).convert(conversionObject.getValue());
            conversionResult.setResult(romanValue);
            httpStatus = HttpStatus.OK;
        } catch (ArgumentOutOfRangeException ex) {
            conversionResult.setErrorMessage("The passed number is not valid");
            httpStatus = HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE;
        } catch (NumberFormatException ex) {
            conversionResult.setErrorMessage("The number is not valid for a conversion with the requested method: " + conversionObject.getMethod());
            httpStatus = HttpStatus.BAD_REQUEST;
        } catch (ConverterInvalidSelection converterInvalidSelection) {
            conversionResult.setErrorMessage("Your selected converted is invalid: " + conversionObject.getMethod());
            httpStatus = HttpStatus.EXPECTATION_FAILED;
        }
        saveAuditEvent(httpStatus, conversionResult);
        return new ResponseEntity<>(conversionResult, httpStatus);
    }

    /**
     * @param conversionResult The conversion result to be persisted
     */
    private void saveAuditEvent(HttpStatus httpStatus, ConversionResultDTO conversionResult) {
        AuditEvent auditEvent = new AuditEvent(httpStatus, conversionResult);
        logger.info(auditEvent.toString());
        auditEventDataRepository.save(auditEvent);
    }


}
