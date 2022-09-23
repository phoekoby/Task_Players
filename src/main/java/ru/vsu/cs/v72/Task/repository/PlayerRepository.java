package ru.vsu.cs.v72.Task.repository;

import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.v72.Task.domain.Player;
import ru.vsu.cs.v72.Task.dto.PlayerDTO;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {
}
