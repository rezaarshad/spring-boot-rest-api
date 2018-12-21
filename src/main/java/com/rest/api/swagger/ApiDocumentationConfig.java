package com.rest.api.swagger;

import io.swagger.annotations.*;

@SwaggerDefinition(
        info = @Info(
                description = "RestAPi Resources",
                version = "V1.0",
                title = "RestApi Resource API",
                contact = @Contact(
                        name = "Reza Arshad",
                        email = "reza67ar@gmail.com",
                        url = "https://www.rezaarshad.github.io"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        consumes = {"application/json"},
        produces = {"application/json"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
        externalDocs = @ExternalDocs(value = "Read This For Sure", url = "https://www.rezaarshad.github.io")
)
public interface ApiDocumentationConfig {

}