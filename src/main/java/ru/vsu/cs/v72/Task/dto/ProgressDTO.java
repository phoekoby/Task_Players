package ru.vsu.cs.v72.Task.dto;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class ProgressDTO implements Serializable {
    private Long id;

    @ToString.Exclude
    @JsonIdentityReference(alwaysAsId = true)
    private PlayerDTO playerId;

    @NotNull
    private Long resourceId;

    @Min(0)
    private int score;

    @Min(0)
    private int maxScore;
}
