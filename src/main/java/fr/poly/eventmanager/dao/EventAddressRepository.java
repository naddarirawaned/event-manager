package fr.poly.eventmanager.dao;

import fr.poly.eventmanager.entities.EventAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventAddressRepository extends JpaRepository<EventAddress,Integer> {

}
