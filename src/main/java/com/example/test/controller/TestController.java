package com.example.test.controller;

import com.example.test.dto.TestDTO;
import com.example.test.exeption.ApiRequestException;
import com.example.test.service.ServiceTest;
import com.example.test.type.SortDirection;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/test")
public class TestController {

    private final ServiceTest serviceTest;
@PostMapping("/add")
    public ResponseEntity<TestDTO> createTest(@RequestBody TestDTO testDTO) {
    try {
        TestDTO testDTO1= serviceTest.create(testDTO);
    return new  ResponseEntity<>(testDTO1, HttpStatus.CREATED);
    } catch (ApiRequestException e) {
        throw new ApiRequestException("Oops! Cannot create test.");
    }
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<TestDTO>> findAllTest() {
        try {
            List<TestDTO> testDTOList = serviceTest.findAll();
            return new ResponseEntity<>(testDTOList, HttpStatus.OK);
        } catch (Exception e) {
            throw new ApiRequestException("Oops! Cannot get all data.");
        }
}
    @GetMapping("/findId/{id}")
    public ResponseEntity<TestDTO> findTestById(@PathVariable Long id) {
        try {
        TestDTO testDTO= serviceTest.findById(id);
        return new ResponseEntity<>(testDTO, HttpStatus.OK);
    } catch (Exception e) {
        throw new ApiRequestException("Oops! Cannot get test by id  .");
    }
    }
@PutMapping("/update/{id}")
    public ResponseEntity<TestDTO> updateTest(@PathVariable Long id, @RequestBody TestDTO testDTO) {
    try {
        testDTO.setId(id);
        TestDTO testDTO1= serviceTest.update(testDTO);
      return new ResponseEntity<>(testDTO1, HttpStatus.OK);
    } catch (Exception e) {
        throw new ApiRequestException("Oops! Cannot update test.");
       }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTest(@PathVariable Long id) {
try {
    serviceTest.delete(id);
    return new ResponseEntity<>("Test deleted", HttpStatus.OK);
}catch (ApiRequestException e) {
    throw new ApiRequestException("Oops! Cannot delete test.");
}
    }
 //   @GetMapping("/listProjet")
  //  public Page<TestDTO> searchRejetMessages(
 //           @RequestParam(required = false) String name,
  //          @RequestParam(defaultValue = "0") int page,
  //          @RequestParam(defaultValue = "25") int size,
  //          @RequestParam(required = false) String sortField,
  //          @RequestParam(defaultValue = "ASC") SortDirection sortDirection) {
  //      return serviceTest.searchWithCriteria(name, page, size, sortField, sortDirection);
  //  }
}
