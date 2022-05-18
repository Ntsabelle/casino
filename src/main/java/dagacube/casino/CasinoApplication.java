package dagacube.casino;

import dagacube.casino.entity.Player;
import dagacube.casino.repo.IPlayerRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CasinoApplication {

	public static void main(String[] args) {


		ConfigurableApplicationContext configurableApplicationContext =
	SpringApplication.run(CasinoApplication.class, args);

		IPlayerRepo playerRepository = configurableApplicationContext.getBean(IPlayerRepo.class);
	}

}
