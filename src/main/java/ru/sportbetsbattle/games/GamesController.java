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

/**
 * Class controller - router;
 * Handle all POST and GET Requests
 * URL: /api/v1/games/
 *
 * @since 1.1
 * @version 1.1
 *
 */

@RestController
@RequestMapping("/api/v1/games")
public class GamesController {


    private GamesRepository gamesRepository;

    @Autowired
    public GamesController(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    /**
     * Handle "/update" POST Request from Parser; Sort JSON and then return HttpStatus OK;
     * @param jsonStr - json string which gets from parser;
     * @return HTTP Status OK
в    */
    @PostMapping("/update")
    public HttpStatus updateGame(@RequestBody String jsonStr) throws ParseException {

        System.out.println(jsonStr);

        sortRequest(jsonStr);

        return HttpStatus.OK;
    }

    /**
     * Method to convert string to JSON
     * @param json - String which we get from parser
     * @return JSONArray - Parsed JSON
     * @throws ParseException - Json exception if smg gone wrong
     */
    private JSONArray handleJSON(String json) throws ParseException {
        JSONParser parser = new JSONParser();
        Object object = parser.parse(json);
        return (JSONArray) object;
    }

    /**
     * Method to sort request from parser and safe to date base
     * @param jsonStr - String which comes from Parser
     * @throws ParseException - if we can't parse JSON
     * @throws NullPointerException - if JSON is OK but game is empty
     */
    private void sortRequest(String jsonStr) throws ParseException, NullPointerException {

        JSONArray json = handleJSON(jsonStr);

        System.out.println(json);

        for (Object o : json) {

            JSONObject jsonObj = (JSONObject) o;

            /* Get params from JSON */
            String teamFirst = jsonObj.get("teamFirst").toString();
            String teamSecond = jsonObj.get("teamSecond").toString();
            String betName = jsonObj.get("betName").toString();
            int scoreFirstTeam = Integer.parseInt( jsonObj.get("scoreFirstTeam").toString() );
            int scoreSecondTeam = Integer.parseInt( jsonObj.get("scoreSecondTeam").toString() );


            if (!teamFirst.equals("") && !teamSecond.equals("")) {

               Games game = gamesRepository.findByTeamFirstAndTeamSecond(teamFirst, teamSecond);

               /*
                If we find the game in database just update the game
               */
                if (game != null) {

                    game.setLastUpdated(new Date());
                    gamesRepository.save(game);

                } else {

                    /*
                        No game in database - create new game
                     */

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
