package ru.vsu.cs.v72.Task.dto;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.Data;
import lombok.ToString;
import ru.vsu.cs.v72.Task.domain.Player;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class CurrencyDTO implements Serializable {
    private Long id;

    @ToString.Exclude
    @JsonIdentityReference(alwaysAsId = true)
    private PlayerDTO playerId;

    private Long resourceId;

    @NotNull
    private String name;

    @Min(0)
    private int count;
}
