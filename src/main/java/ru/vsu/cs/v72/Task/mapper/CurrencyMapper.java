package ru.vsu.cs.v72.Task.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.vsu.cs.v72.Task.domain.Currency;
import ru.vsu.cs.v72.Task.dto.CurrencyDTO;

@Mapper(componentModel = "spring", uses = PlayerMapper.class)
public interface CurrencyMapper extends EntityMapper<CurrencyDTO, Currency> {
    @Override
    @Mappings({
            @Mapping(target = "playerId", source = "playerId",  qualifiedByName = "toEntityWithoutDependencies")})
    Currency toEntity(CurrencyDTO dto);
}
