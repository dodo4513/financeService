package sk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.model.entity.Member;

/**
 * @author doyoung hwang on 2019-09-20
 */
public interface MemberRepository extends JpaRepository<Member, Long> {

  Member findById(String id);
}
