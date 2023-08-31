package com.sample.customer.controller;

//import com.sample.customer.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
// import com.example.demo3.requests.Customer;

@RestController
@RequestMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
public class studentController {


//    @Autowired
//    private StudentService studentService;
//    @PostMapping(value ="/addStudent")
//    public Customer addStudent(@RequestBody Customer stu){
//
//        return studentService.addStudent(stu);
//    }
//
//    @GetMapping(value = "/{studentID}")
//    public Customer getStudent(@PathVariable("studentID") int studentID){
//
//        return studentService.getStu(studentID);
//    }

    @PostMapping("/createStu")
    public String createStudent(@RequestBody String studentInfo, @RequestHeader(name = "Authorization") String auth, @RequestParam(name = "name",
            required = false /* by default the key param its required so setting to false will make it not required*/ ) String val){
        return studentInfo + val;
    }
    @PutMapping("/editStu/{studentID}")
    public String editStudent(@RequestBody String studentInfo){

        return studentInfo;
    }

    @DeleteMapping("/deleteStu")
    public String deleteStudent(@RequestBody String studentInfo){
        studentInfo = "";
        return studentInfo;
    }

}
