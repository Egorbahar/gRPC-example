package com.example.gRPC.example;

import com.example.gRPC.example.constants.Role;
import com.example.gRPC.example.employee.EmployeeRequest;
import com.example.gRPC.example.employee.EmployeeResponse;
import com.example.gRPC.example.employee.EmployeeServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.UUID;


@GrpcService
public class EmployeeService extends EmployeeServiceGrpc.EmployeeServiceImplBase {

    /**
     * Unary operation to get the employee based on employee id
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void getEmployee(EmployeeRequest request,
                            StreamObserver<EmployeeResponse> responseObserver) {

        //call repository to load the data from database
        //we have added static data for example
        EmployeeResponse empResp = EmployeeResponse
                .newBuilder()
                .setEmpId(UUID.randomUUID().toString())
                .setEmpName(request.getEmpName())
                .setRole(Role.ADMIN)
                .build();


        //set the response object
        responseObserver.onNext(empResp);

        //mark process is completed
        responseObserver.onCompleted();
    }
    public void nothing()
    {
        System.out.println("No");
    }
}
