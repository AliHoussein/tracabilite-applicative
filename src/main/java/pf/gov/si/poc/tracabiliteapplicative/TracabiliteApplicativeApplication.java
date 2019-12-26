package pf.gov.si.poc.tracabiliteapplicative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class TracabiliteApplicativeApplication {

  public static void main(String[] args) {
    SpringApplication.run(TracabiliteApplicativeApplication.class, args);
  }

}
