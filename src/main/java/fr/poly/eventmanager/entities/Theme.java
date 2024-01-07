package fr.poly.eventmanager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@JsonIgnore
    private Integer id;
    private  String name;
    @OneToMany(mappedBy = "theme",cascade = CascadeType.ALL)
    @JsonIgnore

    private List<Event> events = new ArrayList<Event>();


}
