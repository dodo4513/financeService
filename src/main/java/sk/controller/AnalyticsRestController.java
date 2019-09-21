package sk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sk.model.entity.StatisticReport;
import sk.model.enums.Bank;
import sk.service.FinanceService;

/**
 * @author doyoung hwang on 2019-09-20
 */

@RestController
@RequiredArgsConstructor
public class AnalyticsRestController {

  private final FinanceService financeService;

  @GetMapping("{bank}/maximumAmount")
  public ResponseEntity<Integer> MaximumAmountOfBank(@PathVariable Bank bank) {

    return ResponseEntity.ok(financeService.getMaximumAmount(bank));
  }

  @GetMapping("statisticReport")
  public ResponseEntity<StatisticReport> getStatisticReport() {

    return ResponseEntity.ok(financeService.getStatisticReport());
  }
}
