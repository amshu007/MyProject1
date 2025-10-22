package com.example.user.service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "micro_users")
public class User {

    @Id
    @Column(name = "ID")
    private String userId;
    private String name;
    private String email;
    private String about;

    @Transient
    private List<Rating> ratings;



}
