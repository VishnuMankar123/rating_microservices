package com.lcwd.hotel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "hotels")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    @Id
    private String id;
    private String name;
    private String location;
    private String about;
}
