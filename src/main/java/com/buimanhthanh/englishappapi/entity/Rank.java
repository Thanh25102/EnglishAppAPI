package com.buimanhthanh.englishappapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tbl_rank")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rank {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "repersent")
    private String repersent;
    @Basic
    @Column(name = "type")
    private String type;

    @ManyToMany(mappedBy = "ranks")
    private Set<Account> accounts;


}
