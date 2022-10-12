package com.customer.user.config;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;
@EnableSwagger2
@Configuration
public class SwaggerConfig {

	 @Bean
	    public Docket postsApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .groupName("api")
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.customer.user.controller"))
	                .paths(postPaths())
	                .build()
	                .apiInfo(apiInfo());
	    }

	    private Predicate<String> postPaths() {
//	        return or(regex("/.*")); // you can give permission to access all rest endpoints through the swagger UI.
	        return or(regex("/customerServiceUser.*")
	                );
	    }

	    private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("	Customer Servive Portal Swagger API")
	                .description("Spring boot rest API")
//	                .termsOfServiceUrl("")
	                .contact(contact())
	                //.license("")
	                //.licenseUrl("")
	                .version("1.0.0")
	                .build();
	    }

	    public Contact contact() {
	        return new Contact(" khushboo Sharma", "", "KhushbooSharma@cognizant.com");
	    }
	}