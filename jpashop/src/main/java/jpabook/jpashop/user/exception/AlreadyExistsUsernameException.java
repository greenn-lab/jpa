package jpabook.jpashop.user.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AlreadyExistsUsernameException extends RuntimeException {

  public AlreadyExistsUsernameException(String message) {
    super(message);
  }
}
