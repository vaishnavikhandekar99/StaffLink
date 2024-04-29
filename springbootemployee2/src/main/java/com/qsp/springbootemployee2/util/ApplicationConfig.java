package com.qsp.springbootemployee2.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfig    //documentation
{
		@Bean
	     public Docket getDocket()
	     {
	    	 Contact contact = new Contact("Qspider","https://qspider.com" , "qspidergmail.com");
	    	 List <VendorExtension> list = new ArrayList<VendorExtension>();
	    	 ApiInfo apiInfo =  new ApiInfo("Employee Management", "used to manage the details of employee", "version 1.0", "1 year of free service", contact," www.ems.com", " www.ems.com",list);
	    	 
	    	 return new Docket(DocumentationType.SWAGGER_2).select()
	    			 .apis(RequestHandlerSelectors.basePackage("com.qsp.springbootemployee2"))
	    			 .build().apiInfo(apiInfo)
	    			 .useDefaultResponseMessages(false);
	     }
}
