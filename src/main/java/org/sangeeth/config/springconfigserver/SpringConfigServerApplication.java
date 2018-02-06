package org.sangeeth.config.springconfigserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigServer
public class SpringConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigServerApplication.class, args);
	}
}

@RestController
class Controller{
	
	@Value("${my.password}")
	String password;
	
	@Value("${my.otherValue}")
	String otherValue;
	
	@RequestMapping(value="/other")
	public String geOther(){
		return otherValue;
	}
	
	@RequestMapping(value="/pass")
	public String getPassword(){
		return password;
	}
}