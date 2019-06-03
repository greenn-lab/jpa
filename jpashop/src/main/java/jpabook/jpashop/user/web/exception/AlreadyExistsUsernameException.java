package jpabook.jpashop.user.web.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AlreadyExistsUsernameException extends RuntimeException {

  public AlreadyExistsUsernameException(String message) {
    super(message);
  }
}
