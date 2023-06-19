package com.spring.jpa.chap05_practice.dto;

import lombok.*;

@Getter @Setter
@ToString @EqualsAndHashCode
@AllArgsConstructor
@Builder
// 요청 부분만 한다.
public class PageDTO {


  private int page;
  private int size;

  public PageDTO() {
    this.page = 1;
    this.size = 10;
  }
}
