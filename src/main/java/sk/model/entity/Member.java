package sk.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import sk.model.model.SignRequest;

/**
 * @author doyoung hwang on 2019-09-20
 */
@Entity
@Getter
@Setter
public class Member {

  @Id
  @GeneratedValue
  long memberNo;

  String id;

  String password;

  public static Member createBy(SignRequest request) {
    Member member = new Member();

    member.setId(request.getId());
    member.setPassword(request.getPassword());

    return member;
  }
}
