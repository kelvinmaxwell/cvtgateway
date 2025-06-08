package cvt.karimax.cvtgateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class GatewayCorsConfig {


    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration config = new CorsConfiguration();

        // Allow specific origins
        config.setAllowedOrigins(Arrays.asList("http://localhost:3000")); // Replace with your origins

        // Allow all HTTP methods and headers
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsWebFilter(source);
    }

//    @Bean
//    public WebFilter addCustomHeadersFilter() {
//        return (exchange, chain) -> {
//            exchange.getResponse().getHeaders().add("X-Frame-Options", "ALLOW-FROM https://web.storyhippoafrica.com");
//         //   exchange.getResponse().getHeaders().add("Content-Security-Policy", "frame-ancestors 'self' https://web.storyhippoafrica.com");
//            return chain.filter(exchange);
//        };
//    }
}

