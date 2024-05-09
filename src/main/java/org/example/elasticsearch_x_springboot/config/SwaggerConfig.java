//package org.example.elasticsearch_x_springboot.config;
//
//
//import io.swagger.v3.oas.models.OpenAPI;
//import org.springframework.context.annotation.Bean;
//
//import io.swagger.v3.oas.models.info.Contact;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.info.License;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SwaggerConfig {
//    @Bean
//    public OpenAPI apiInfo() {
//        return new OpenAPI().info(new Info().title("Spring Data Elasticsearch Example")
//                .description("Spring Data Elasticsearch")
//                .version("v0.0.1")
//                .contact(getContactDetails())
//                .license(getLicenseDetails()));
//    }
//
//    private Contact getContactDetails() {
//        return new Contact().name("Li Xiang Yi")
//                .email("")
//                .url("");
//    }
//    private License getLicenseDetails() {
//        return new License().name("GNU General Public License v3.0")
//                .url("");
//    }
//}
