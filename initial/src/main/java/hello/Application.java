package hello;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @RequestMapping("/")
    public String home() {
        return "Hello Docker World!!!!";
    }
    
    @RequestMapping("/test")
    public String test() {
    	String url = "http://gs-spring-boot-docker:8080/";
    	HttpHeaders headers = new HttpHeaders();
    	Map<String, String> params = new HashMap<String, String>();
    	HttpEntity entity = new HttpEntity(headers);

    	RestTemplate restTemplate = new RestTemplate();
    	HttpEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, params);

        return response.getBody();
    }
    
    // gs-spring-boot-docker-1.jx
    @RequestMapping("/jx")
    public String jx() {
    	String url = "http://gs-spring-boot-docker-1.jx:8080/";
    	HttpHeaders headers = new HttpHeaders();
    	Map<String, String> params = new HashMap<String, String>();
    	HttpEntity entity = new HttpEntity(headers);

    	RestTemplate restTemplate = new RestTemplate();
    	HttpEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, params);

        return response.getBody();
    }
    
    // gs-spring-boot-docker-1.jx
    @RequestMapping("/jx2")
    public String jx2() {
    	String url = "http://gs-spring-boot-docker-1.jx.svc.cluster.local:8080/";
    	HttpHeaders headers = new HttpHeaders();
    	Map<String, String> params = new HashMap<String, String>();
    	HttpEntity entity = new HttpEntity(headers);

    	RestTemplate restTemplate = new RestTemplate();
    	HttpEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, params);

        return response.getBody();
    }
}
