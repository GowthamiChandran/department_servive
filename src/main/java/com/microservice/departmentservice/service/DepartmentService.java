package com.microservice.departmentservice.service;

import com.microservice.departmentservice.dto.DepartmentDto;
import com.microservice.departmentservice.entity.Department;

import java.util.List;

public interface DepartmentService {

    public DepartmentDto createDepartment(DepartmentDto departmentDto);

    public   DepartmentDto getDepartmentById(Long id);

    public List<DepartmentDto> getAllDepartments();

    public DepartmentDto updateDepartment(DepartmentDto departmentDto);

}
