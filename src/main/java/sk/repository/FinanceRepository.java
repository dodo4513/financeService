package sk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.model.entity.Finance;

/**
 * @author doyoung hwang on 2019-09-20
 */
public interface FinanceRepository extends JpaRepository<Finance, Long> {

}
