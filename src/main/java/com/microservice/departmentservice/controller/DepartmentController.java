package com.microservice.departmentservice.controller;

import com.microservice.departmentservice.dto.DepartmentDto;
import com.microservice.departmentservice.entity.Department;
import com.microservice.departmentservice.service.Impl.DepartmentServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
       DepartmentDto savedDepartment= departmentService.createDepartment(departmentDto);
       return new  ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long id){
      DepartmentDto departmentDto= departmentService.getDepartmentById(id);
      return new ResponseEntity<>(departmentDto,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DepartmentDto>> getDepartmentLists(){
        List<DepartmentDto> departmentList = departmentService.getAllDepartments();
        return new ResponseEntity<>(departmentList,HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(Long id,DepartmentDto departmentDto){
        departmentDto.setDeptId(id);
        DepartmentDto updatedDepartment = departmentService.updateDepartment(departmentDto);
        return new ResponseEntity<>(updatedDepartment,HttpStatus.OK);
    }
}
