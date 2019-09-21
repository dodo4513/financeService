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

  // TODO 2 "signup"
  @PostMapping("signup")
  public ResponseEntity<Boolean> signUp(HttpServletResponse response,
      @RequestBody SignRequest request
  ) {
    // 회원 가입
    String token = authenticationService.saveUser(request);

    // 토큰 header에 세팅
    response.setHeader(AUTH_HEADER, token);

    return ResponseEntity.ok(true);
  }

  // TODO 6 "signin" AuthenticationService::login 참고
}
