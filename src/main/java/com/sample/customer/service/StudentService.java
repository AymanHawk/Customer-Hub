//
//
//package com.sample.customer.service;
//import com.example.demo3.requests.Customer;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.concurrent.CopyOnWriteArrayList;
//
//@Component
//public class StudentService {
//
//     private int studentIdCount = 1;
//    private List<Customer> studentList = new CopyOnWriteArrayList<>();
//
//    public Customer addStudent(Customer stu){
//        studentList.add(stu);
//        studentList.add(stu);
//        studentIdCount++;
//        return stu;
//    }
//
//    public List<Customer> getStud(){
//        return studentList;
//    }
//
//    public Customer getStu(int stuID){
//
//        return studentList
//                .stream()
//                .filter(c -> c.getStudentID() == stuID)
//                .findFirst()
//                .get();
//    }
//
//    public Customer updateStudent(int sID, Customer stuParam){
//        studentList
//                .stream()
//                .forEach(c-> {
//                    if(c.getStudentID() == sID){
//                        c.setName(Customer.getName());
//                        c.setStudentID(Customer.getStudentID());
//                        c.setMajor(Customer.getMajor());
//                    }
//                });
//
//        return studentList
//                .stream()
//                .filter(c-> c.getStudentID() == sID)
//                .findFirst()
//                .get();
//
//    }
//
//    public void deleteCustomer(int sID){
//        studentList
//                .stream()
//                .forEach(c -> {
//                    if(c.getStudentID() == sID){
//                        studentList.remove(c);
//                    }
//                });
//    }
//
//}
