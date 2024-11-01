package org.example.ge.instrastructure.common.mapper;

public interface Mapper<D, E, P> {
    E toEntity(D dto, P params);
    D toDto(E entity, P params);
}
