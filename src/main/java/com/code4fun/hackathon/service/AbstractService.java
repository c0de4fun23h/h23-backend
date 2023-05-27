package com.code4fun.hackathon.service;

import com.code4fun.hackathon.mappers.GeneralMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public abstract class AbstractService<DTO, E, ID, R extends JpaRepository<E, ID>,
                                                  M extends GeneralMapper<DTO, E>> implements GeneralService<DTO, ID> {
    private final R repository;
    private final M mapper;

    public AbstractService(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DTO> findAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public DTO findById(ID id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }

    @Override
    public DTO create(DTO dto) {
        E entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public DTO update(ID id, DTO dto) {
        if (repository.findById(id).isPresent()) {
            E entity = mapper.toEntity(dto);
            entity = repository.save(entity);
            return mapper.toDto(entity);
        }
        return null;
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }


}
