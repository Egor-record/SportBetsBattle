package ru.sportbetsbattle.games;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface GamesRepository extends PagingAndSortingRepository<Games, Long> {

    Page<Games> findByNameOfTheGame(@Param("nameOfTheGame") String nameOfTheGame, Pageable page);
    Page<Games> findByLeague(@Param("league") String league, Pageable page);

}
