package springboot.microservices.OrderService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan(basePackages= {"com.spring"})
@EntityScan("com.spring.entity")
@EnableJpaRepositories("com.spring.repository")
@EnableEurekaClient
public class App 
{
    public static void main( String[] args )
    {
    	//https://www.youtube.com/watch?v=tljuDMmfJz8
    	//https://github.com/Java-Techie-jt/spring-cloud-gatway-hystrix/blob/master/
    	//Order Service
        SpringApplication.run(App.class, args);
    }
    
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
    	return new RestTemplate();
    }
}
