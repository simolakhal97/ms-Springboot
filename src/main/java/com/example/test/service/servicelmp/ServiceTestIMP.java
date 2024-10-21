package com.example.test.service.servicelmp;

 import com.example.test.dto.TestDTO;
 import com.example.test.entity.Test;
 import com.example.test.helper.SpecificationBuilder;
 import com.example.test.mapper.MapperTest;
 import com.example.test.repository.TestRepo;
 import com.example.test.service.ServiceTest;

 import com.example.test.type.SortDirection;

 import lombok.RequiredArgsConstructor;
 import org.springframework.data.domain.Page;
 import org.springframework.data.domain.PageRequest;
 import org.springframework.data.domain.Pageable;
 import org.springframework.data.domain.Sort;
 import org.springframework.data.jpa.domain.Specification;
 import org.springframework.stereotype.Service;

 import java.util.List;
 import java.util.Objects;
 import java.util.Optional;
 import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceTestIMP implements ServiceTest {

    private final TestRepo testRepo;

    private final MapperTest mapperTest;

    private final SpecificationBuilder<Test> specificationBuilder;

    @Override
    public TestDTO create(TestDTO testDTO) {
        Test test =mapperTest.toEntity(testDTO);
        Test saveEntiy=testRepo.save(test);

        return mapperTest.toDto(saveEntiy);
    }

    @Override
    public List<TestDTO> findAll() {

        List<Test> testList=testRepo.findAll();

        return testList.stream().map(mapperTest::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TestDTO findById(Long id) {

        Optional<Test> test=testRepo.findById(id);


        return test.map(mapperTest::toDto).orElse(null) ;
    }

    @Override
    public TestDTO update(TestDTO testDTO) {
        Optional<Test> test=testRepo.findById(testDTO.getId());
        if(test.isPresent()){
            Test test1=test.get();
            test1.setOid(testDTO.getId());
            test1.setName(testDTO.getName());
            test1.setAge(testDTO.getAge());
           Test update= testRepo.save(test1);
           return mapperTest.toDto(update);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        testRepo.deleteById(id);

    }


    @Override
    public Page<TestDTO> searchWithCriteria(String email, int page, int size, String sortField, SortDirection sortDirection) {
        Specification<Test> spec = buildSpecifications(email);
        Pageable pageable = buildPageable(page, size, sortField, sortDirection);


        Page<Test> pageResult = testRepo.findAll(spec, pageable);
        return pageResult.map(mapperTest::toDto);
    }

    private Pageable buildPageable(int page, int size, String sortField, SortDirection sortDirection) {
        Sort sort = Sort.by(Objects.equals(sortDirection.label, "desc") ? Sort.Direction.DESC : Sort.Direction.ASC, sortField);
        return PageRequest.of(page, size, sort);
    }

    private Specification<Test> buildSpecifications(String name) {
        Specification<Test> spec = Specification.where(null);
        if (name != null && !name.isEmpty()) {
            spec = spec.and(specificationBuilder.equalSpec(spec, "email", name)); // Change to "name" based on your entity


        }
        System.out.println("Specification: " + spec);
        return spec;
    }




}

