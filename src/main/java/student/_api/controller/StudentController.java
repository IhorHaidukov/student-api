package student._api.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import student._api.dto.StudentDto;
import student._api.entity.Student;
import student._api.mapper.StudentMapper;
import student._api.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<StudentDto> getAllStudents() {

        List<Student> students = service.getAllStudents();

        List<StudentDto> dtos = new ArrayList<>();

        for (Student student : students) {
            StudentDto dto = StudentMapper.toDto(student);
            dtos.add(dto);
        }

        return dtos;
    }

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id) {

        Student student = service.getStudentById(id);

        return StudentMapper.toDto(student);
    }

    @PostMapping
    public StudentDto createStudent(@Valid @RequestBody StudentDto dto) {

        Student student = StudentMapper.toEntity(dto);

        Student savedStudent = service.createStudent(student);

        return StudentMapper.toDto(savedStudent);
    }

    @PutMapping("/{id}")
    public StudentDto updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentDto dto) {

        Student student = StudentMapper.toEntity(dto);

        Student updatedStudent = service.updateStudent(id, student);

        return StudentMapper.toDto(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }

    @GetMapping("/count")
    public long countStudents() {
        return service.countStudents();
    }
}