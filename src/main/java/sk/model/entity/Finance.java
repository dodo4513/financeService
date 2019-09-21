package sk.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * @author doyoung hwang on 2019-09-20
 */
@Entity
@Setter
@Getter
public class Finance {

  @Id
  @GeneratedValue
  long financeNo;

  String year;

  String month;

  int kb;

  int shinhan;

  int woori;

  int hana;

  public static Finance createBy(String s) {
    String[] columns = s.split(",");
    Finance finance = new Finance();

    finance.setMonth(columns[0]);
    finance.setYear(columns[1]);
    finance.setKb(Integer.parseInt(columns[2]));
    finance.setShinhan(Integer.parseInt(columns[3]));
    finance.setWoori(Integer.parseInt(columns[4]));
    finance.setHana(Integer.parseInt(columns[5]));

    return finance;
  }
}
