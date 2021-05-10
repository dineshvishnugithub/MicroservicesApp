package springboot.microservices.SpringCloudConfigServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class App 
{
    public static void main( String[] args )
    {
    	//https://www.youtube.com/watch?v=tljuDMmfJz8
    	//https://github.com/Java-Techie-jt/spring-cloud-gatway-hystrix/blob/master/
    	//Spring cloud Config server (centralised config setup)
    	SpringApplication.run(App.class, args);
    }
}
