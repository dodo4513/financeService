package sk.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import sk.service.JwtService;

/**
 * @author doyoung hwang on 2019-09-21
 */

@Component
@RequiredArgsConstructor
public class AuthenticationInterceptor implements HandlerInterceptor {

  private static final String HEADER_AUTH = "authorizatiOn";

  private final JwtService jwtService;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    final String token = request.getHeader(HEADER_AUTH);

    if (token != null && jwtService.isUsable(token)) {
      return true;
    } else {
      throw new IllegalAccessException();
    }
  }
}
