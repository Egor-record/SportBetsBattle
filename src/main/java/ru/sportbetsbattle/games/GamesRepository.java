package ru.sportbetsbattle.games;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;


import java.util.Date;
import java.util.List;

public interface GamesRepository extends PagingAndSortingRepository<Games, Long> {


    //TODO: Should sort via data !!!
    Games findByTeamFirstAndTeamSecond(String firstTeam, String secondTeam);

//    @RestResource(path = "sorted", rel = "sorted")
    //
//    Games findByNameOfTheGame(@Param("nameOfTheGame") String nameOfTheGame, Pageable p);


}
