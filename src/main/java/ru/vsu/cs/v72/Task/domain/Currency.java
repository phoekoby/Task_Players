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
@Table(name = "CURRENCY")
public class Currency implements Serializable {
    @Id
    private Long id;

//    @NotNull
    @ToString.Exclude
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", nullable = false)
    private Player playerId;

    @Column(name = "resource_id")
    private Long resourceId;

    @NotNull
    @Column(name = "name")
    private String name;

    @Min(0)
    @Column(name = "count")
    private int count;
}
