package com.lcwd.user.service.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "micro_user")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @Column(name="ID")
    private String userId;
    @Column(name = "NAME",length = 20)
    private String name;
    @Column(name="EMAIL")
    private String email;
    @Column(name="ABOUT")
    private String about;
    @Transient
    private List<Rating> ratings;

}
