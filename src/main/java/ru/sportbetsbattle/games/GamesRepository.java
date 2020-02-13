package ru.sportbetsbattle.games;

import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.Date;
import java.util.List;

public interface GamesRepository extends PagingAndSortingRepository<Games, Long> {


    //TODO: Should sort via data !!!
    Games findByTeamFirstAndTeamSecond(String firstTeam, String secondTeam);


}
