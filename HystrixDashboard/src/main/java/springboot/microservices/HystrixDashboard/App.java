package springboot.microservices.HystrixDashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Hello world!
 *  // use url to launch: http://localhost:8086/hystrix and type in the actuator/hystrix.stream url
 */
@SpringBootApplication
@EnableHystrixDashboard
public class App 
{
    public static void main( String[] args )
    {
    	//https://www.youtube.com/watch?v=tljuDMmfJz8
    	//https://github.com/Java-Techie-jt/spring-cloud-gatway-hystrix/blob/master/
    	//Hystrix dashboard (to monitor streams)
        SpringApplication.run(App.class, args);
    }
}
