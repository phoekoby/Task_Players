package ru.vsu.cs.v72.Task.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import ru.vsu.cs.v72.Task.domain.Player;
import ru.vsu.cs.v72.Task.dto.PlayerDTO;

@Mapper(componentModel = "spring")
public interface PlayerMapper extends EntityMapper<PlayerDTO, Player> {
    @Named("toEntityWithoutDependencies")
    @Mappings({
            @Mapping(target = "progresses", expression = "java(null)"),
            @Mapping(target = "currencies", expression = "java(null)"),
            @Mapping(target = "items", expression = "java(null)"),
    })
    Player toEntityWithoutDependencies(PlayerDTO playerDTO);

}
