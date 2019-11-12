package de.numerals.conversionbackend.configuration.spring;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.apis(RequestHandlerSelectors.any())
                .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build().apiInfo(apiEndPointsInfo())
                .tags(new Tag("Conversion", "Functions for converting numbers to Roman Numerals"),
                        new Tag("Utilities", "Service related utility functions (Service status,...)"),
                        new Tag("AuditEventController", "Get audit data")
                        //new Tag("LetterStatusTag", "Possible state for delivered letters")
                );
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Conversion Rest API")
                .description("Conversion Rest API")
                .termsOfServiceUrl("https://git2.securedocs.de")
                .contact(
                        new Contact("Christian Gläser", "https://git2.securedocs.de", "glaeser@7says.de")
                )
                .license("Proprietary License")
                .licenseUrl("https://git2.securedocs.de")
                .version("1.0.0")
                .build();
    }
}