package sk.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author doyoung hwang on 2019-09-21
 */

@Configuration
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {

  private static final String[] EXCLUDE_PATHS = {"/signin", "/signup"};

  private final AuthenticationInterceptor authenticationInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(authenticationInterceptor)
        .addPathPatterns("/**")
        .excludePathPatterns(EXCLUDE_PATHS);
  }
}
