package jammazwan.xbq;

import org.apache.camel.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("META-INF/spring/camel-context.xml")
public class BarebonesspringbootcamelApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarebonesspringbootcamelApplication.class, args);
	}

	@Bean
	public CommandLineRunner go() throws Exception {
		return (args) -> {
			Main main = new Main();
//			main.addRouteBuilder(new XbqRoutes());
			main.run();
		};
	}

}