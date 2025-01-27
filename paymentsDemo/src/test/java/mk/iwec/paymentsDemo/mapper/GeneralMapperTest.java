package mk.iwec.paymentsDemo.mapper;

import mk.iwec.paymentsDemo.TestDTO;
import mk.iwec.paymentsDemo.TestEntity;
import mk.iwec.paymentsDemo.infrastructure.mapper.GeneralMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
 class GeneralMapperTest {
    private GeneralMapper<TestDTO, TestEntity> mapper;
    UUID uuid = UUID.randomUUID();

    @BeforeEach
    void setUp() {
        mapper = new TestMapper();
    }
    @Test
    void testEntityToDto() {

        TestEntity entity = new TestEntity(uuid);

        TestDTO dto = mapper.entityToDto(entity);
        assertNotNull(dto);
        assertEquals(uuid, dto.id());

    }

    @Test
    void testDtoToEntity() {

        TestDTO dto = new TestDTO(uuid);

        TestEntity entity = mapper.dtoToEntity(dto);

        assertNotNull(entity);
        assertEquals(uuid, entity.getId());

    }
    @Test
    void testEntityToDto_Null() {

        TestDTO dto = mapper.entityToDto(null);
        assertNull(dto);
    }
    @Test
    void testDtoToEntity_Null() {

        TestEntity entity = mapper.dtoToEntity(null);
        assertNull(entity);
    }
}
