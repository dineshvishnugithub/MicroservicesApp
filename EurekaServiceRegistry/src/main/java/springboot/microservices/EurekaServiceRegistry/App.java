package springboot.microservices.EurekaServiceRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *  Eureka: http://localhost:8761/
 */
@SpringBootApplication
@EnableEurekaServer
public class App 
{
    public static void main( String[] args )
    {
    	//https://www.youtube.com/watch?v=tljuDMmfJz8
    	//https://github.com/Java-Techie-jt/spring-cloud-gatway-hystrix/blob/master/
    	//Eureka Server (Service registry)
        SpringApplication.run(App.class, args);
    }
}
