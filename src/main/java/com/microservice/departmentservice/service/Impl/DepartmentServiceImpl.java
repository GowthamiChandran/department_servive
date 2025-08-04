package com.microservice.departmentservice.service.Impl;

import com.microservice.departmentservice.dto.DepartmentDto;
import com.microservice.departmentservice.entity.Department;
import com.microservice.departmentservice.repository.DepartmentInterface;
import com.microservice.departmentservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentInterface departmentInterface;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto){

      Department departmentRecord= modelMapper.map(departmentDto,Department.class);
      Department savedDepartment = departmentInterface.save(departmentRecord);
        return modelMapper.map(savedDepartment,DepartmentDto.class);
    }

    @Override
   public  DepartmentDto getDepartmentById(Long id){
       Department department = departmentInterface.findById(id).get();
       return modelMapper.map(department,DepartmentDto.class);
    }

    @Override
    public List<DepartmentDto> getAllDepartments(){
      List<Department>  departmentList= departmentInterface.findAll();
      return departmentList.stream()
              .map(dept->modelMapper.map(dept,DepartmentDto.class))
              .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto departmentDto){

        Department existedDepartment = departmentInterface.findById(departmentDto.getDeptId()).get();
        existedDepartment.setDepartmentCode(departmentDto.getDepartmentCode());
        existedDepartment.setDepartmentName(departmentDto.getDepartmentName());
        existedDepartment.setDepartmentDescription(departmentDto.getDepartmentDescription());
        Department savedDepartment = departmentInterface.save(existedDepartment);
        return modelMapper.map(savedDepartment,DepartmentDto.class);
    }
}
