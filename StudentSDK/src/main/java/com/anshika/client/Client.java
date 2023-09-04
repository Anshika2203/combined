package com.anshika.client;


import com.anshika.StudentRequest;
import com.anshika.StudentServiceGrpc;
import com.anshika.StudentsResponse;
import org.springframework.stereotype.Service;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Service
public class Client {

    private final StudentServiceGrpc.StudentServiceBlockingStub studentStub;

    Logger logger = LoggerFactory.getLogger(Client.class);

    public Client() {
        Channel channel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();
        studentStub = StudentServiceGrpc.newBlockingStub(channel);
    }

    public StudentsResponse getStudentById(int id) {
        StudentRequest request = StudentRequest.newBuilder()
                .setId(id)
                .build();

        return studentStub.getStudents(request);
    }
}

//public class Client {
//    static Logger logger = LoggerFactory.getLogger(Client.class);
//    public static void main(String[] args) {
//
//        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();
//        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);
//
//        public StudentResponse getStudentById(int id) {
//            StudentRequest request = StudentRequest.newBuilder()
//                    .setId(id)
//                    .build();
//            return blockingStub.getStudent(request);
//
//        StudentResponse studentResponse = blockingStub.getStudent(StudentRequest.newBuilder().setId(1).build());
//
//        logger.info("response ="+ studentResponse.getName()+" "+studentResponse.getCity());
//
//    }
//}
