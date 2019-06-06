package jpabook.jpashop;

import jpabook.jpashop.entity.auditor.LoggedInUsernameAuditor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "loggedInUsernameAuditor")
public class JpashopApplication {

  public static void main(String[] args) {
    SpringApplication.run(JpashopApplication.class, args);
  }

  @Bean
  public LoggedInUsernameAuditor loggedInUsernameAuditor() {
    return new LoggedInUsernameAuditor();
  }

}
