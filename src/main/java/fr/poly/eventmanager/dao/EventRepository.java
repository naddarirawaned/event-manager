package fr.poly.eventmanager.dao;

import fr.poly.eventmanager.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EventRepository extends JpaRepository<Event,Integer> {



    @Query("select p from Event p where p.name like %:x%")
    List<Event> searchByKW(@Param("x")String mc);
}
