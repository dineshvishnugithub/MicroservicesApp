package springboot.microservices.GatewayService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 * to test hystrix stream : http://localhost:8085/actuator/hystrix.stream
 */
@SpringBootApplication
@ComponentScan(basePackages= {"com.spring"})
@EnableEurekaClient
@EnableHystrix
public class App 
{
    public static void main( String[] args )
    {
    	//https://www.youtube.com/watch?v=tljuDMmfJz8
    	//https://github.com/Java-Techie-jt/spring-cloud-gatway-hystrix/blob/master/
    	//Gateway Service (for registering fallback)
    	SpringApplication.run(App.class, args);
    }
}
