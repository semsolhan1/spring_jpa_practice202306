package com.spring.jpa.chap02_querymethod.repository;

import com.spring.jpa.chap02_querymethod.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {

  List<Student> findByName(String name);
  List<Student> findByCityAndMajor(String city, String major);

  List<Student> findByMajorContaining(String major);

  //네이티브 쿼리 사용
  @Query(value = "SELECT * FROM tbl_student WHERE stu_name = :nm", nativeQuery = true)
  Student findNameWithSQL(@Param("nm") String name);

  //JPQL
  //SELECT 별칭 FROM 엔터티클래스명 AS 별칭
  //WHERE 별칭.필드명 = ?

  // native-sql : SELECT * FROM tbl_student
  //              WHERE stu_name = ?

  // jpql: SELECT st FROM Student AS st
  //       WHERE st.name = ?

  //도시 이름으로 학생 조회
  @Query("SELECT s FROM Student s WHERE s.city = ?1")
  List<Student> getByCityWithJPQL(String City);

  @Query("SELECT st FROM Student st WHERE st.name LIKE %:nm%")
  List<Student> searchByNameWithJPQL(@Param("nm") String name);

  //JPQL로 수정 삭제 쿼리 쓰기
  @Modifying //조회가 아닌 경우에는 무조건 붙여야 함.
  @Query("DELETE FROM Student s WHERE s.name = ?1")
  void deleteByNameWithJPQL(String name);

}
