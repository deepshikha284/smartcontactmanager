package com.smart.dao;

import com.smart.entities.Contact;
import com.smart.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("from Student as s where s.user.id =:userId")
    public List<Student> findStudentByUserId(@Param("userId") int userId);
}
