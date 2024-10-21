package com.example.test.client;
import com.example.test.dto.TestDTO;
import com.example.test.type.SortDirection;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "signature-embedder", url = "${spring.service.url}")
public interface FiengClient {
    @GetMapping(value = "/api/v1/test/listProjet", consumes = MediaType.APPLICATION_JSON_VALUE)
    Page<TestDTO> searchRejetMessages(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "25") int size,
            @RequestParam(required = false) String sortField,
            @RequestParam(defaultValue = "ASC") SortDirection sortDirection);
}
