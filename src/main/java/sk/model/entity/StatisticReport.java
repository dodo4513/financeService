package sk.model.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;
import sk.model.enums.Bank;

/**
 * @author doyoung hwang on 2019-09-20
 */

@Getter
@Setter
public class StatisticReport {

  private final String name = "주택금융 공급현황";
  private List<YearGroup> yearGroups = new ArrayList<>();

  @Getter
  @Setter
  private static class YearGroup {

    private String year;
    private String total_amount;
    private Map<Bank, Integer> detail_amount;

    static YearGroup createBy(List<Finance> financesByYear) {
      YearGroup yearGroup = new YearGroup();

      yearGroup.setYear(financesByYear.get(0).getYear());
      yearGroup.setTotal_amount(String.valueOf(
          financesByYear.stream()
              .mapToInt(f -> f.getKb() + f.getHana() + f.getShinhan() + f.getWoori()).sum()));

      // TODO 7 detail_amount 생성
      yearGroup.setDetail_amount(YearGroup.createDetailAmountBy(financesByYear));

      return yearGroup;
    }

    private static Map<Bank, Integer> createDetailAmountBy(List<Finance> financesByYear) {

      // TODO 8 각 financesByYear 를 순회하면서 각 은행의 총합을 구함
      int kb = 0;
      int shinhan = 0;
      int woori = 0;
      int hana = 0;

      for (Finance finance : financesByYear) {
        kb += finance.getKb();
        shinhan += finance.getShinhan();
        woori += finance.getWoori();
        hana += finance.getHana();
      }

      Map<Bank, Integer> detailAmount = new HashMap<>();
      detailAmount.put(Bank.kb, kb);
      detailAmount.put(Bank.shinhan, shinhan);
      detailAmount.put(Bank.woori, woori);
      detailAmount.put(Bank.hana, hana);

      return detailAmount;
    }
  }

  public static StatisticReport createBy(List<Finance> finances) {
    StatisticReport statisticReport = new StatisticReport();

    // TODO 5 year 기준으로 그룹핑을 한 financesByYear
    Map<String, List<Finance>> financesByYear = finances.stream()
        .collect(Collectors.groupingBy(Finance::getYear));

    // TODO 6 그룹핑 된 각 데이터를 순회하며 yearGroups를 생성
    financesByYear.values().forEach(
        financeList -> statisticReport.getYearGroups().add(YearGroup.createBy(financeList)));

    return statisticReport;
  }
}
