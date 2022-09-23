package ru.vsu.cs.v72.Task.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "PLAYER")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "playerId")
public class Player implements Serializable {

    @Id
    @JsonProperty("playerId")
    private Long id;
    //    private int playerId;
    @NotNull
    @Column(name = "nickname")
    private String nickname;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "playerId", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    private List<Progress> progresses;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "playerId", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    private List<Currency> currencies;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "playerId", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    private List<Item> items;
}
