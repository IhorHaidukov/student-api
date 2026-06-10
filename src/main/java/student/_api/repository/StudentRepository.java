package student._api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student._api.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}