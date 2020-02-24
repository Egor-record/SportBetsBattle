package ru.sportbetsbattle.games;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.sportbetsbattle.scores.Scores;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/games")
public class GamesController {


    private GamesRepository gamesRepository;

    @Autowired
    public GamesController(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    @PostMapping("/update")
    public HttpStatus updateGame(@RequestBody String jsonStr) throws ParseException {

        System.out.println(jsonStr);

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

            String teamFirst = jsonObj.get("teamFirst").toString();
            String teamSecond = jsonObj.get("teamSecond").toString();
            String betName = jsonObj.get("betName").toString();
            int scoreFirstTeam = Integer.parseInt( jsonObj.get("scoreFirstTeam").toString() );
            int scoreSecondTeam = Integer.parseInt( jsonObj.get("scoreSecondTeam").toString() );

            System.out.println(teamFirst);
            System.out.println(teamSecond);
            System.out.println(scoreFirstTeam);
            System.out.println(scoreSecondTeam);

            if (!teamFirst.equals("") && !teamSecond.equals("")) {

               Games game = gamesRepository.findByTeamFirstAndTeamSecond(teamFirst, teamSecond);

                if (game != null) {

                    game.setLastUpdated(new Date());
                    gamesRepository.save(game);

                } else {

                    Games games = new Games("Football",
                            "Чемпионат Испании. Примера",
                            teamFirst, teamSecond,
                            new Date(),
                            new Date(),
                            scoreFirstTeam,
                            scoreSecondTeam );
                    games.addValue(new Scores(scoreFirstTeam, scoreSecondTeam, betName));
                    gamesRepository.save(games);
                }


            }

        }
    }



}
