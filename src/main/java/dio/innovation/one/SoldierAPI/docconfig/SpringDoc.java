package dio.innovation.one.SoldierAPI.docconfig;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDoc {
    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("REST API Soldier para Cadastro de Soldados").version("4.0.0")
                        .description("Digital Innovation: Expert class - Cadastro de Soldados do Senhor dos Aneis utilizando API REST")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringDoc for Documentation - springdoc-openapi")
                        .url("https://springdoc.org/#Introduction"));
    }
}
