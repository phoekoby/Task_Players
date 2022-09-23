package ru.vsu.cs.v72.Task.domain;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "PROGRESS")
public class Progress implements Serializable {
    @Id
    private Long id;

    @ToString.Exclude
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", nullable = false)
    private Player playerId;

    @NotNull
    @Column(name = "resource_id")
    private Long resourceId;

    @Min(0)
    @Column(name = "score")
    private int score;

    @Min(0)
    @Column(name = "max_score")
    private int maxScore;
}
