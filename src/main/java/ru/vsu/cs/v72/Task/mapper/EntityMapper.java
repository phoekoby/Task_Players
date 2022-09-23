package ru.vsu.cs.v72.Task.mapper;

import java.util.List;

public interface EntityMapper<D,E>{
    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> entityList);
}
