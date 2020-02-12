package ru.sportbetsbattle.games;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface GamesRepository extends PagingAndSortingRepository<Games, Long> {

    Page<Games> findByNameOfTheGame(@Param("nameOfTheGame") String nameOfTheGame, Pageable page);
    Page<Games> findByLeague(@Param("league") String league, Pageable page);
    Page<Games> findFirstByLastUpdatedAndTeamFirst(@Param("LastUpdated") Date date, @Param("teamFirst") String name, Pageable page);

    Games findById(long id);

    List<Games> findFirstByTeamFirst(String teamFirst);


}
