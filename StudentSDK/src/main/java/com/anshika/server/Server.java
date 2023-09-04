package com.anshika.server;


import com.anshika.StudentRequest;
import com.anshika.StudentResponse;
import com.anshika.StudentServiceGrpc;
import io.grpc.stub.StreamObserver;
import mongodbexample.models.Student;
import mongodbexample.Services.StudentService;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@GRpcService
public class Server extends StudentServiceGrpc.StudentServiceImplBase {

    private final StudentService studentService;

    @Autowired
    public Server(StudentService studentService) {
        this.studentService = studentService;
    }

    public void getStudent(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        List<Student> student = studentService.getAllStudents();

        StudentResponse studentResponse = StudentResponse.newBuilder()
                .setId(student.get(0).getId())
                .setName(student.get(0).getName())
                .setCity(student.get(0).getCity())
                .setCollege(student.get(0).getCollege())
                .build();

        responseObserver.onNext(studentResponse);
        responseObserver.onCompleted();
    }
}
