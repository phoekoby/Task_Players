package ru.vsu.cs.v72.Task.service;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;
import ru.vsu.cs.v72.Task.domain.Player;
import ru.vsu.cs.v72.Task.dto.PlayerDTO;
import ru.vsu.cs.v72.Task.mapper.PlayerMapper;
import ru.vsu.cs.v72.Task.repository.PlayerRepository;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlayerService {
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final PlayerRepository playerRepository;

    @PostConstruct
    public void fillDataBase() {
        List<Player> players;
        try {
            players = parseJsonFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        playerRepository.saveAll(players);
    }

    @Transactional
    public void getAllPlayersIntoJson() {
        List<Player> players = playerRepository.findAll();
        File jsonFile;
        try {
            jsonFile = new File("/home/phoekoby/Documents/education/java-language/Task_Players/src/main/resources/players-from-db.json");
            FileOutputStream fileOutputStream = new FileOutputStream(jsonFile);
            ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
            objectWriter.writeValue(fileOutputStream, players);
            fileOutputStream.close();
            log.info("Writing has ended");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Player> parseJsonFile() throws IOException {
        String jsonFileName = "players.json";
        File jsonFile = ResourceUtils.getFile("classpath:" + jsonFileName);
        return objectMapper.readValue(jsonFile, objectMapper.getTypeFactory().constructCollectionType(List.class, Player.class));
    }

}
