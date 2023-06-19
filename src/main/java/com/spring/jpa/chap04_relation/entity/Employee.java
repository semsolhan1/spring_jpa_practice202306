package com.spring.jpa.chap04_relation.entity;

import lombok.*;

import javax.persistence.*;

@Setter @Getter
//jpa연관관계 매핑에서 연관관계 데이터는 ToString에서 제외해야 한다.
@ToString(exclude = {"department"})//exclude 제외시킬것
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_emp")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "emp_id")
  private long id;

  @Column(name = "emp_name", nullable = false)
  private String name;

  //EAGER: 항상 무조건 조인을 수행
  //LAZY: 필요한 경우에만 조인을 수행(실무)
  @ManyToOne(fetch = FetchType.LAZY) //내가  N이고 얘가 1이면 (fetch = FetchType.EAGER)가 기본값이다.
  @JoinColumn(name = "dept_id") //join할 이름
  private Department department; // 단방향 연관관계(단방향 MAPPING)

  //양방향 1번째
  public void setDepartment(Department department) {
    this.department = department;//임플로이스에서도
    department.getEmployees().add(this);//디파트먼트에서도 가져오자~~?
  }
}
