package fr.poly.eventmanager.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double price;
    private String animator;
    private String picture;
    @ManyToOne

    private Theme theme;

    public String toString() {
        return name;
    }


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @JsonManagedReference
    private EventAddress address;

    @ManyToMany
    @JoinTable(name ="Event_Sponsor_Associations",
        joinColumns = @JoinColumn( name ="idEvent"),
        inverseJoinColumns = @JoinColumn( name = "idSponsor"))
    private List<Sponsor> Sponsors = new ArrayList<>();
}
