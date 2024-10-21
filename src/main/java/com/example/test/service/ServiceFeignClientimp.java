package com.example.test.service;

import com.example.test.dto.TestDTO;
import com.example.test.type.SortDirection;
import org.springframework.data.domain.Page;

public interface ServiceFeignClientimp {

     Page<TestDTO> searchWithCriteria(String name, int page, int size, String sortField, SortDirection sortDirection);

    }
