package ru.sportbetsbattle.values;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ValuesRepository extends PagingAndSortingRepository<Values, Long> {
}
