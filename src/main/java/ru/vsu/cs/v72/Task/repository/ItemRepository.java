package ru.vsu.cs.v72.Task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.v72.Task.domain.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
}
