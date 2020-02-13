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
import java.util.Date;

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

        sortRequest(jsonStr);

        return HttpStatus.OK;
    }


    private JSONArray handleJSON(String json) throws ParseException {
        JSONParser parser = new JSONParser();
        Object object = parser.parse(json);
        return (JSONArray) object;
    }

    private void sortRequest(String jsonStr) throws ParseException, NullPointerException {

        JSONArray json = handleJSON(jsonStr);

        System.out.println(json);

        for (Object o : json) {

            JSONObject jsonObj = (JSONObject) o;

            System.out.println(jsonObj.get("team_first"));
            System.out.println(jsonObj.get("team_second"));
            System.out.println(jsonObj.get("score_first"));
            System.out.println(jsonObj.get("score_second"));

            if (!jsonObj.get("team_second").toString().equals("") && !jsonObj.get("team_first").toString().equals("")) {

               Games game = gamesRepository.findByTeamFirstAndTeamSecond(jsonObj.get("team_first").toString(), jsonObj.get("team_second").toString());

                if (game != null) {

                    game.setLastUpdated(new Date());
                    gamesRepository.save(game);

                } else {

                    Games games = new Games("Football", "Чемпионат Испании. Примера", (String) jsonObj.get("team_first"), (String) jsonObj.get("team_second"), new Date(), new Date() );
                    gamesRepository.save(games);
                }

//                gamesRepository.findByTeamFirstAndTeamSecond(jsonObj.get("team_first").toString(), jsonObj.get("team_second").toString()).forEach(bauer -> {
//
//                    System.out.println(bauer.getTeamSecond());
//
//
//
//                });

            }

        }
    }



}
