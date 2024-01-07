package fr.poly.eventmanager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Sponsor {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     private String name;
     private Double donation;

     @JsonIgnore
     @ManyToMany
     @JoinTable(name ="Event_Sponsor_Associations",
         joinColumns = @JoinColumn( name ="idSponsor"),
         inverseJoinColumns = @JoinColumn( name = "idEvent"))
     private List<Event> Events = new ArrayList<>();


     public String toString(){
         return name;
     }

}
