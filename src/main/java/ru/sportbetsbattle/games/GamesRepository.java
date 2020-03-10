package ru.sportbetsbattle.games;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * Work around with database
 * Extends Paging And Sorting so that to let to paging JSON we sent to View;
 * For example return 1st page of 10 pages of current games;
 */
public interface GamesRepository extends PagingAndSortingRepository<Games, Long> {


    //TODO: Should sort via data !!!
    Games findByTeamFirstAndTeamSecond(String firstTeam, String secondTeam);

//    @RestResource(path = "sorted", rel = "sorted")
    //
//    Games findByNameOfTheGame(@Param("nameOfTheGame") String nameOfTheGame, Pageable p);


}
