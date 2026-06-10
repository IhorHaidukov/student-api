package student._api.service;

import org.springframework.stereotype.Service;
import student._api.entity.Student;
import student._api.repository.StudentRepository;
import java.util.List;
    
@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }
    public Student createStudent(Student student){
        return repository.save(student);
    }
}