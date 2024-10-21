    package com.example.test.mapper;

    import com.example.test.dto.TestDTO;
    import com.example.test.entity.Test;
    import org.mapstruct.Mapper;
    import org.mapstruct.Mapping;
    import org.mapstruct.factory.Mappers;

    @Mapper(componentModel = "spring")
    public interface MapperTest {


        Test toEntity(TestDTO dto);


        TestDTO toDto(Test entity);
    }
