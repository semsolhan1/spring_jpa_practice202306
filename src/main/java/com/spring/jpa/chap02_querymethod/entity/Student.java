package com.spring.jpa.chap02_querymethod.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Setter // 실무적 픅면에서 setter는 신중하게 만들것.
@Getter
@ToString @EqualsAndHashCode(of = "id") //id 같으면 같은 객체로 인식. 여러개 줄때는 {"name", "id"}안에 넣는다.
@NoArgsConstructor
@AllArgsConstructor
@Builder // 생성자 객체를 만들어준다.
@Entity
@Table(name = "tbl_student")
public class Student {

  @Id
  @Column(name = "stu_id") //컬럼을 쓸 필요는 없다 stuId면
  @GeneratedValue(generator = "uid")
  @GenericGenerator(strategy = "uuid", name = "uid") //UUID를 받으려면 제너릭제너레이터를 뽑아 줘야 한다.
  private String id;

  @Column(name = "stu_name", nullable = false)
   private String name;

  private String city;

  private String major;

}
