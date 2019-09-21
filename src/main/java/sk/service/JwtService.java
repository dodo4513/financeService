package sk.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author doyoung hwang on 2019-09-21
 */

@Service
@Slf4j
public class JwtService {


  private static final byte[] SECRETS_KEY = "dodo".getBytes(StandardCharsets.UTF_8);

  // https://jwt.io/
  <T> String createToken(String key, T data) {
    return Jwts.builder()
        .setHeaderParam("typ", "JWT")
        .setHeaderParam("regDate", System.currentTimeMillis())
        .claim(key, data)
        .signWith(SignatureAlgorithm.HS256, SECRETS_KEY)
        .compact();
  }

  public boolean isUsable(String token) {
    try {
      Jws<Claims> claims = Jwts.parser()
          .setSigningKey(SECRETS_KEY)
          .parseClaimsJws(token);

      log.info(claims.toString());

      return true;

    } catch (Exception e) {
      e.printStackTrace();

      return false;
    }
  }
}
