package ru.vsu.cs.v72.Task.dto;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.Data;
import lombok.ToString;
import ru.vsu.cs.v72.Task.domain.Player;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;


@Data
public class ItemDTO implements Serializable {
    private Long id;

    @ToString.Exclude
    @JsonIdentityReference(alwaysAsId = true)
    private PlayerDTO playerId;

    private int resourceId;

    @Min(0)
    private int count;

    @Min(0)
    private int level;
}
