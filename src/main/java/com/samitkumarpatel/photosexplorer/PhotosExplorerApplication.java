package com.samitkumarpatel.photosexplorer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootApplication
public class PhotosExplorerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotosExplorerApplication.class, args);
	}

}

@Configuration
@Slf4j
class Routers {
	@Bean
	public RouterFunction router(Handelers handelers) {
		return RouterFunctions.route()
				.path("/album", builder -> builder
						.POST("/", RequestPredicates.accept(MediaType.APPLICATION_JSON), request -> ServerResponse.ok().body("", String.class))
						.GET("/", RequestPredicates.accept(MediaType.APPLICATION_JSON), request -> ServerResponse.ok().body("", String.class)))
				.path("/photo", builder -> builder
						.POST("/", RequestPredicates.accept(MediaType.APPLICATION_JSON), request -> ServerResponse.ok().body("", String.class))
						.GET("/", RequestPredicates.accept(MediaType.APPLICATION_JSON), request -> ServerResponse.ok().body("", String.class)))
				.build();
	}
}

@Configuration
@Slf4j
class Handelers {

}

@Service
@Slf4j
class Services {

}