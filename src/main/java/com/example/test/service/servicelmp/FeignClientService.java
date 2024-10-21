package com.example.test.service.servicelmp;

import com.example.test.client.FiengClient;
import com.example.test.dto.TestDTO;
import com.example.test.service.ServiceFeignClientimp;
import com.example.test.type.SortDirection;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FeignClientService implements ServiceFeignClientimp {

    private final FiengClient fiengClient;
    @Override
    public Page<TestDTO> searchWithCriteria(String name, int page, int size, String sortField, SortDirection sortDirection) {
        Page<TestDTO> testDTOS = fiengClient.searchRejetMessages(name, page, size, sortField, sortDirection);
        return testDTOS;
    }
}