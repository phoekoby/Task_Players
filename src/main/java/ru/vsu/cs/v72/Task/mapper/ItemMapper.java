package ru.vsu.cs.v72.Task.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.vsu.cs.v72.Task.domain.Item;
import ru.vsu.cs.v72.Task.dto.ItemDTO;

@Mapper(componentModel = "spring", uses = PlayerMapper.class)
public interface ItemMapper extends EntityMapper<ItemDTO, Item> {
    @Override
    @Mappings({
            @Mapping(target = "playerId", source = "playerId",  qualifiedByName = "toEntityWithoutDependencies")})
    Item toEntity(ItemDTO dto);
}
