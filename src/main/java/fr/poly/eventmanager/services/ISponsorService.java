package fr.poly.eventmanager.services;

import fr.poly.eventmanager.entities.Sponsor;

import java.util.List;

public interface ISponsorService {
    void addSponsor(Sponsor s);

    List<Sponsor> getAllSponsors();

    void deleteSponsor(int id);

    void getSponsor(Integer id);
}
