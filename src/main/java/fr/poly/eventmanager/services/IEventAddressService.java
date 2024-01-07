package fr.poly.eventmanager.services;

import fr.poly.eventmanager.entities.EventAddress;

public interface IEventAddressService {

    void deleteAddress(int id);
    void addAddress(EventAddress a);
    void getAddress(int id);

}
