package ru.vsu.cs.v72.Task.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.vsu.cs.v72.Task.domain.Progress;
import ru.vsu.cs.v72.Task.dto.ProgressDTO;

@Mapper(componentModel = "spring", uses = PlayerMapper.class)
public interface ProgressMapper extends EntityMapper<ProgressDTO, Progress> {
    @Override
    @Mappings({
            @Mapping(target = "playerId",source = "playerId", qualifiedByName = "toEntityWithoutDependencies")})
    Progress toEntity(ProgressDTO dto);
}
