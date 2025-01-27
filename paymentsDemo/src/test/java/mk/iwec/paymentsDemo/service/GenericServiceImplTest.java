package mk.iwec.paymentsDemo.service;

import jakarta.persistence.EntityNotFoundException;
import mk.iwec.paymentsDemo.TestDTO;
import mk.iwec.paymentsDemo.TestEntity;
import mk.iwec.paymentsDemo.infrastructure.mapper.GeneralMapper;
import mk.iwec.paymentsDemo.infrastructure.service.impl.GenericServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class GenericServiceImplTest {

    @Mock
    private GeneralMapper<TestDTO, TestEntity> mapper;

    @Mock
    private JpaRepository<TestEntity, UUID> repository;

    @InjectMocks
    private GenericServiceImpl<TestDTO, TestEntity, UUID> service;

    private UUID testId;
    private TestDTO testDTO;
    private TestEntity testEntity;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        testId = UUID.randomUUID();
        testDTO = new TestDTO(testId);
        testEntity = new TestEntity(testId);

    }
    @Test
    void testFindById_Success(){
        when(repository.findById(testId)).thenReturn(Optional.of(testEntity));
        when(mapper.entityToDto(testEntity)).thenReturn(testDTO);

        TestDTO result = service.findById(testId);


        assertNotNull(result);
        assertEquals(testDTO, result);
        verify(repository).findById(testId);
        verify(mapper).entityToDto(testEntity);
    }
    @Test
    void testFindById_NotFound() {

        when(repository.findById(testId)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> service.findById(testId));
        verify(repository).findById(testId);
        verifyNoInteractions(mapper);
    }
    @Test
    void testFindAll() {
        Pageable pageable = PageRequest.of(0, 2);
        List<TestEntity> entities = List.of(testEntity, new TestEntity(UUID.randomUUID()));
        Page<TestEntity> entityPage = new PageImpl<>(entities, pageable, entities.size());

        List<TestDTO> dtos = List.of(testDTO, new TestDTO(UUID.randomUUID()));
        Page<TestDTO> dtoPage = new PageImpl<>(dtos, pageable, dtos.size());

        when(repository.findAll(pageable)).thenReturn(entityPage);
        when(mapper.entityToDto(testEntity)).thenReturn(testDTO);
        when(mapper.entityToDto(any(TestEntity.class))).thenReturn(new TestDTO(UUID.randomUUID()));

        Page<TestDTO> result = service.findAll(pageable);

        assertNotNull(result);
        assertEquals(2, result.getContent().size());
        assertEquals(dtoPage.getContent(), result.getContent());

        verify(repository).findAll(pageable);
        verify(mapper, times(2)).entityToDto(any(TestEntity.class));
    }
    @Test
    void testSave() {

        when(mapper.dtoToEntity(testDTO)).thenReturn(testEntity);
        when(repository.save(testEntity)).thenReturn(testEntity);
        when(mapper.entityToDto(testEntity)).thenReturn(testDTO);

        TestDTO result = service.save(testDTO);

        assertNotNull(result);
        assertEquals(testDTO, result);
        verify(mapper).dtoToEntity(testDTO);
        verify(repository).save(testEntity);
        verify(mapper).entityToDto(testEntity);
    }
    @Test
    void testDeleteById() {

        service.deleteById(testId);


        verify(repository).deleteById(testId);
    }
}
