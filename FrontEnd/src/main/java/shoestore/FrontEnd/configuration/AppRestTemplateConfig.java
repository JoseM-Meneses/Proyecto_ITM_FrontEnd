package shoestore.FrontEnd.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppRestTemplateConfig {

    /**
     * Define el bean de RestTemplate para que pueda ser inyectado
     * en cualquier clase de la aplicación.
     */
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
