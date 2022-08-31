package com.example.rec.config;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private final String contactName;
    private final String contactUrl;
    private final String contactEmail;
    private final String projectTitle;
    private final String projectDescription;
    private final String projectVersion;

    public SwaggerConfig(@Value("${spring.contact.name}") String contactName,
                         @Value("${spring.contact.url}") String contactUrl,
                         @Value("${spring.contact.email}") String contactEmail,
                         @Value("${spring.project.title}") String projectTitle,
                         @Value("${spring.project.description}") String projectDescription,
                         @Value("${spring.project.version}") String projectVersion) {
        this.contactName = contactName;
        this.contactUrl = contactUrl;
        this.contactEmail = contactEmail;
        this.projectTitle = projectTitle;
        this.projectDescription = projectDescription;
        this.projectVersion = projectVersion;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .forCodeGeneration(true)
                .securityContexts(Lists.newArrayList(securityContext()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo getApiInfo() {
        Contact contact = new Contact(contactName, contactUrl, contactEmail);

        return new ApiInfoBuilder()
                .title(projectTitle)
                .description(projectDescription)
                .version(projectVersion)
                .contact(contact)
                .build();
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", null);
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("JWT", authorizationScopes));
    }
}
