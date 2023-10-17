 package com.oasys.mdmclient.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
			info = @Info(
					contact = @Contact(
							name = "Oasys",
							email = "contact@oasys.co",
							url = "https://www.oasys.co/"
							),
					description = "MDM API",
					title = "MDM Android",
					version = "1.0",
					license = @License(
							name = "License of API",
							url = "API license URL"
							),
					termsOfService = "Terms of service"
					)
			)
	public class OpenApiConfig {

	}
