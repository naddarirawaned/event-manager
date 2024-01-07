package fr.poly.eventmanager.services;

import fr.poly.eventmanager.dao.EventAddressRepository;
import fr.poly.eventmanager.entities.EventAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventAddressService implements IEventAddressService {

    @Autowired
    EventAddressRepository ear;

    @Override
    public void deleteAddress(int id) {
        ear.deleteById(id);
    }

    @Override
    public void addAddress(EventAddress a) {
        ear.save(a);
    }

    @Override
    public void getAddress(int id) {
        ear.getById(id);
    }


}
