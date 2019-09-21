package sk.controller;

import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sk.model.model.SignRequest;
import sk.service.AuthenticationService;

/**
 * @author doyoung hwang on 2019-09-20
 */

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  private static final String AUTH_HEADER = "authentication";

  @PostMapping("signup")
  public ResponseEntity<Boolean> signUp(HttpServletResponse response,
      @RequestBody SignRequest request
  ) {
    String token = authenticationService.saveUser(request);
    response.setHeader(AUTH_HEADER, token);

    return ResponseEntity.ok(true);
  }

  @PostMapping("signin")
  public ResponseEntity<Boolean> signIn(HttpServletResponse response,
      @RequestBody SignRequest request) throws IllegalAccessException {

    String token = authenticationService.login(request);
    response.setHeader(AUTH_HEADER, token);

    return ResponseEntity.ok(true);
  }
}
