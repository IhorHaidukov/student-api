package student._api.controller;

import org.springframework.web.bind.annotation.*;
import student._api.dto.StudentDto;
import student._api.mapper.StudentMapper;
import student._api.service.StudentService;
import student._api.entity.Student;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/students")
    public String getStudents() {
        return service.testService();
    }

    @GetMapping("/count")
    public long countStudents() {
        return service.countStudents();
    }

    @GetMapping("/all")
    public List<StudentDto> getAllStudents() {

        List<Student> students = service.getAllStudents();

        List<StudentDto> dtos = new ArrayList<>();

        for (Student student : students) {

            StudentDto dto = StudentMapper.toDto(student);

            dtos.add(dto);
        }

        return dtos;
    }

    @PostMapping("/students")
    public StudentDto createStudent(@Valid @RequestBody StudentDto dto) {

        Student student = StudentMapper.toEntity(dto);

        Student savedStudent = service.createStudent(student);

        return StudentMapper.toDto(savedStudent);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }

    @GetMapping("/students/{id}")
    public StudentDto getStudentById(@PathVariable Long id) {

        Student student = service.getStudentById(id);

        return StudentMapper.toDto(student);
    }
    @PutMapping("/students/{id}")
    public StudentDto updateStudent(

            @PathVariable Long id,
            @Valid
            @RequestBody StudentDto dto) {

        Student student = StudentMapper.toEntity(dto);

        Student updatedStudent =
                service.updateStudent(id, student);

        return StudentMapper.toDto(updatedStudent);
    }

}