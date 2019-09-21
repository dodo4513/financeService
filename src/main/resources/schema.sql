CREATE TABLE finance
(
  finance_no BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  year       char(4)                           NOT NULL,
  month      VARCHAR(2)                        NOT NULL,
  kb         int                               NOT NULL,
  shinhan    int                               not null,
  woori      int                               not null,
  hana       int                               not null
);

CREATE TABLE member
(
  member_no BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  id        varchar(20)                       NOT NULL,
  password  VARCHAR(20)                       NOT NULL
);
