package student._api.service;

import org.springframework.stereotype.Service;
import student._api.entity.Student;
import student._api.repository.StudentRepository;
import student._api.exception.StudentNotFoundException;
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

    public String testService() {
        return "People works";
    }

    public long countStudents() {
        return repository.count();
    }

    public Student createStudent(Student student) {
        return repository.save(student);
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    public Student updateStudent(Long id, Student student) {
        Student existingStudent = repository.findById(id).orElseThrow(
                () -> new StudentNotFoundException(
                        "Student with id " + id + " not found"
                )
        );

        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());

        return repository.save(existingStudent);
    }

    public Student getStudentById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new StudentNotFoundException(
                        "Student with id " + id + " not found"
                )
        );
    }
}