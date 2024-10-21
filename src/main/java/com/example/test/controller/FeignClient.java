package com.example.test.controller;
import com.example.test.dto.TestDTO;
import com.example.test.service.ServiceFeignClientimp;
import com.example.test.type.SortDirection;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/feign")
public class FeignClient {
 private final ServiceFeignClientimp feignClientimp;

    @GetMapping("/listProjet")
    public Page<TestDTO> searchRejetMessages(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "25") int size,
            @RequestParam(required = false) String sortField,
            @RequestParam(defaultValue = "ASC") SortDirection sortDirection) {
        return feignClientimp.searchWithCriteria(name, page, size, sortField, sortDirection);
    }

}
