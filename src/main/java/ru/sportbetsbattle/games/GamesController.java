package ru.sportbetsbattle.games;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/parse")
public class GamesController {


    private GamesRepository gamesRepository;

    @Autowired
    public GamesController(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    @PostMapping("/update")
    public HttpStatus updateGame(@RequestBody String jsonStr) throws ParseException {

        JSONArray weather = handleJSON(jsonStr);

        System.out.println(weather);

        for (Object o : weather) {
            JSONObject jsonObj = (JSONObject) o;
            System.out.println(jsonObj.get("team_first"));
            System.out.println(jsonObj.get("team_second"));
            System.out.println(jsonObj.get("score_first"));
            System.out.println(jsonObj.get("score_second"));

            Games game = new Games("Football", "Чемпионат Испании. Примера", (String) jsonObj.get("team_first"), (String) jsonObj.get("team_second"));
            gamesRepository.save(game);
        }

        gamesRepository.findFirstByTeamFirst("Барселона").forEach(bauer -> {
            System.out.println(bauer.getTeamSecond());
        });

        return HttpStatus.OK;
    }

    private JSONArray handleJSON(String json) throws ParseException {
        JSONParser parser = new JSONParser();
        Object object = parser.parse(json);
        return (JSONArray) object;
    }

}
