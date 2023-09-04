package mongodbexample.Services;

import mongodbexample.models.Student;
import mongodbexample.rep.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(int id, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + id));

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setCity(updatedStudent.getCity());
        existingStudent.setCollege(updatedStudent.getCollege());

        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(int id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + id));

        studentRepository.delete(student);
    }


}
