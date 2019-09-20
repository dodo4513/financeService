package sk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sk.service.FinanceService;

/**
 * @author doyoung hwang on 2019-09-20
 */

@RestController
@RequiredArgsConstructor
public class CollectorRestController {

  private final FinanceService financeService;

  @PostMapping("/financeData")
  public ResponseEntity<Boolean> saveFinanceData(@RequestBody String financeData) {

    return ResponseEntity.ok(financeService.saveFinanceData(financeData));
  }
}
