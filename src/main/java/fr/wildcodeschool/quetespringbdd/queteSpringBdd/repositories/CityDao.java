package fr.wildcodeschool.quetespringbdd.queteSpringBdd.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.wildcodeschool.quetespringbdd.queteSpringBdd.entities.City;


@Repository
public interface CityDao extends JpaRepository<City, Long> {
}