package sk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sk.model.entity.Member;
import sk.model.model.SignRequest;
import sk.repository.MemberRepository;

/**
 * @author doyoung hwang on 2019-09-21
 */

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final JwtService jwtService;
  private final MemberRepository memberRepository;

  public String saveUser(SignRequest signRequest) {
    // TODO 3 기존 가입된 유저를 찾기 위해 id로 select
    Member member = memberRepository.********(signRequest.getId());

    if (member != null) {
      throw new IllegalArgumentException("이미 가입한 유저 입니다.");
    }

    // TODO 4 가입 안된 유저를 확인 했으니 저장
    member = memberRepository.****(Member.createBy(signRequest));

    // TODO 5 JWT 를 이용한 token 생성
    return jwtService.createToken("member", member);
  }

  public String login(SignRequest signRequest) throws IllegalAccessException {
    Member member = memberRepository.findById(signRequest.getId());

    if (member == null) {
      throw new IllegalAccessException("존재하지 않는 유저입니다.");
    }

    if (!member.getPassword().equals(signRequest.getPassword())) {
      throw new IllegalAccessException("잘못된 패스워드입니다.");
    }

    // TODO 7 JWT 를 이용한 token 생성
    return jwtService.createToken("member", member);
  }
}
