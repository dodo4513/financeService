package sk.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sk.model.entity.Finance;
import sk.model.entity.StatisticReport;
import sk.model.enums.Bank;
import sk.repository.FinanceRepository;

/**
 * @author doyoung hwang on 2019-09-20
 */

@Service
@RequiredArgsConstructor
public class FinanceService {

  private final FinanceRepository financeRepository;

  public boolean saveFinanceData(String financeData) {
    String[] rows = financeData.split("\n");

    for (int i = 1; i < rows.length; i++) {
      financeRepository.save(Finance.createBy(rows[i]));
    }

    return true;
  }

  // TODO 2 getMaximumAmount 구현 (Finance::getAmount 참고)
  public int getMaximumAmount(Bank bank) {
    // List<Finance> financeList =

    return 0;
  }

  // TODO 4 getStatisticReport 구현 (StatisticReport::createBy 참고)
  public StatisticReport getStatisticReport() {
    return null;
  }
}
