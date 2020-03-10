package ru.sportbetsbattle.core;

import javax.persistence.*;

/**
 * Abstract class which we extend to Game and Scores
 */
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;


    protected BaseEntity() {
        id = null;
    }
}
