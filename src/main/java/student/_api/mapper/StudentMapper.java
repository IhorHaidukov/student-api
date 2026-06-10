package student._api.mapper;


import student._api.dto.StudentDto;
import student._api.entity.Student;

public class StudentMapper {

    public static StudentDto toDto(Student student) {

        return new StudentDto(
                student.getId(),
                student.getName(),
                student.getAge()
        );
    }

    public static Student toEntity(StudentDto dto) {

        Student student = new Student();

        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setAge(dto.getAge());

        return student;
    }
}