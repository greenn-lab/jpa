package jpabook.jpashop.entity.auditor;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;

public class LoggedInUsernameAuditor implements AuditorAware<String> {

  @Override
  public Optional<String> getCurrentAuditor() {
    // TODO get username from spring security context
    return Optional.of("test");
  }

}
