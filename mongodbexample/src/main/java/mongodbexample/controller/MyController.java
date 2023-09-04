package mongodbexample.controller;


import mongodbexample.Services.StudentService;
import mongodbexample.models.Student;
//import mongodbexample.rep.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping("/student")
//public class MyController {
//    @Autowired
//    private StudentRepository studentRepository;
//    @PostMapping("/")
//    public ResponseEntity<?> addStudent(@RequestBody Student student){
//        Student save = this.studentRepository.save(student);
//        return ResponseEntity.ok(save);
//    }
//
//    @GetMapping("/")
//    public ResponseEntity<?> getStudent(){
//        return ResponseEntity.ok(this.studentRepository.findAll());
//    }
//
//
//
//}

@RestController
@RequestMapping("/student")
public class MyController {

    private final StudentService studentService;

    @Autowired
    public MyController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        Student savedStudent = studentService.addStudent(student);
        return ResponseEntity.ok(savedStudent);
    }

    @GetMapping("/")
    public ResponseEntity<?> getStudent() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        Student updated = studentService.updateStudent(id, updatedStudent);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student with id " + id + " has been deleted.");
    }


}

