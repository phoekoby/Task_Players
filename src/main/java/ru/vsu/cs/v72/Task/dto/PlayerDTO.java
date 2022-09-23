package ru.vsu.cs.v72.Task.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import ru.vsu.cs.v72.Task.domain.Currency;
import ru.vsu.cs.v72.Task.domain.Item;
import ru.vsu.cs.v72.Task.domain.Progress;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "playerId")
public class PlayerDTO implements Serializable {
    @JsonProperty("playerId")
    private Long id;
    @NotNull
    private String nickname;

    private List<ProgressDTO> progresses;

    private List<CurrencyDTO> currencies;

    private List<ItemDTO> items;
}
