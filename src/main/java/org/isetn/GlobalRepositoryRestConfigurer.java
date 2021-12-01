package org.isetn;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Configuration
public class GlobalRepositoryRestConfigurer extends RepositoryRestConfigurerAdapter {
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration repositoryRestConfiguration) {
		repositoryRestConfiguration.setReturnBodyOnCreate(true);
		repositoryRestConfiguration.setReturnBodyOnUpdate(true);

		repositoryRestConfiguration.exposeIdsFor(Etudiant.class, Formation.class);
		repositoryRestConfiguration.exposeIdsFor(Etudiant.class, Classe.class);
		repositoryRestConfiguration.getCorsRegistry()
		.addMapping("/**")
		// pour le test on met
		//.allowedOrigins("http://192.168.56.1:8080")
		//pour le test on met
		.allowedOrigins("*")
		.allowedHeaders("Access-Control-Allow-Origin", "*")
		.allowedMethods("OPTIONS","HEAD", "GET", "PUT", "POST", "DELETE", "PATCH", "Access-Control-Allow-Headers: Access-Control-Allow-Origin, Accept" );

	}

}
