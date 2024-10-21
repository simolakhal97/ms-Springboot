package com.example.test.helper;

import com.example.test.entity.Test;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class SpecificationBuilder<T> {

    public Specification<T> equalSpec(Specification<T> spec, String fieldName, Object fieldValue) {
        return spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(fieldName), fieldValue));
    }
}