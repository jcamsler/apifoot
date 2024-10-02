package fr.amsler_consulting.ogcn_rest_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = PageSerializationMode.VIA_DTO)
public class OgcnRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OgcnRestApiApplication.class, args);
	}

}
