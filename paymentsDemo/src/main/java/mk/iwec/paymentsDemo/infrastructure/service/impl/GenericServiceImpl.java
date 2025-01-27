package mk.iwec.paymentsDemo.infrastructure.service.impl;

import jakarta.persistence.EntityNotFoundException;

import jakarta.transaction.Transactional;
import mk.iwec.paymentsDemo.infrastructure.mapper.GeneralMapper;
import mk.iwec.paymentsDemo.infrastructure.service.GenericService;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public class GenericServiceImpl<D,E,UUID> implements GenericService<D,UUID> {

    private final JpaRepository<E, UUID> repository;
    private final GeneralMapper<D, E> mapper;


    public GenericServiceImpl(JpaRepository<E, UUID> repository, GeneralMapper<D, E> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public D findById(UUID uuid) {
        Optional<E> entity = repository.findById(uuid);
        return entity.map(mapper::entityToDto).orElseThrow(()->
                new EntityNotFoundException("Entity not found"));
    }

    @Override
    public Page<D> findAll(Pageable pageable) {
        Page<E> entities = repository.findAll(pageable);
        return entities.map(mapper::entityToDto);
    }

    @Override
    @Transactional
    public D save(D dto) {
        E entity = mapper.dtoToEntity(dto);
        E savedEntity = repository.save(entity);
        return mapper.entityToDto(savedEntity);

    }

    @Override
    @Transactional
    public D update(UUID uuid, D dto) {
        E entity = repository.findById(uuid).orElseThrow(() ->
                new EntityNotFoundException("Entity not found"));
        mapper.dtoToEntity(dto);
        E updatedEntity = repository.save(entity);
        return mapper.entityToDto(updatedEntity);
    }

    @Override
    @Transactional
    public void deleteById(UUID uuid) {
        if(!repository.existsById(uuid)) {
            throw new EntityNotFoundException("Entity not found");
        }
        repository.deleteById(uuid);
    }




}
