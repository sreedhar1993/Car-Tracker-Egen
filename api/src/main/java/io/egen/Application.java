package io.egen;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Sreedhar on 6/29/2017.
 */
@Configuration
@ComponentScan
@EnableWebMvc
public class Application extends WebMvcConfigurerAdapter {

}
