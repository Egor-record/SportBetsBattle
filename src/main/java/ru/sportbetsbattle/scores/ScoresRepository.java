package ru.sportbetsbattle.scores;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ScoresRepository extends PagingAndSortingRepository<Scores, Long> {
}
