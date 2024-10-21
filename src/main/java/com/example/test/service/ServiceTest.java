package com.example.test.service;

import com.example.test.dto.TestDTO;
import com.example.test.entity.Test;
import com.example.test.type.SortDirection;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ServiceTest {

     TestDTO create(TestDTO testDTO);
     List<TestDTO> findAll();
     TestDTO findById(Long id);
     TestDTO update(TestDTO testDTO);
     void delete(Long id);
     Page<TestDTO> searchWithCriteria(String name, int page, int size, String sortField, SortDirection sortDirection);
}
