package mk.iwec.paymentsDemo.mapper;

import mk.iwec.paymentsDemo.TestDTO;
import mk.iwec.paymentsDemo.TestEntity;
import mk.iwec.paymentsDemo.infrastructure.mapper.GeneralMapper;

public class TestMapper implements GeneralMapper<TestDTO, TestEntity> {
    @Override
    public TestDTO entityToDto(TestEntity entity) {
        if (entity == null) return null;
        return new TestDTO(entity.getId());
    }

    @Override
    public TestEntity dtoToEntity(TestDTO dto) {
        if (dto == null) return null;
        return new TestEntity(dto.id());
    }
}
