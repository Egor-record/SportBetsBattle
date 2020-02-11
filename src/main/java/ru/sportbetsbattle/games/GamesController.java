package ru.sportbetsbattle.games;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/parse")
public class GamesController {

    GamesRepository gamesRepository;

    @GetMapping("/football")
    public String getAllMatches() {
        return "OK";
    }

    @PostMapping("/update")
    public HttpStatus updateGame(@RequestBody String jsonStr) {
        System.out.println(jsonStr);
        return HttpStatus.OK;

    }

}
