package com.example.Custumer_Service.models;

import jakarta.persistence.*;

@Entity
@Table(name = "custumers")
public class Custumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_client;
    private String nom_client;
    public String prenom_client;
    public String add_client;


    public long getId_client() {
        return id_client;
    }

    public void setId_client(long id_client) {
        this.id_client = id_client;
    }

    public String getNom_client() {
        return nom_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public String getPrenom_client() {
        return prenom_client;
    }

    public void setPrenom_client(String prenom_client) {
        this.prenom_client = prenom_client;
    }
    public String getAdd_client() {
        return add_client;
    }

    public void setAdd_client(String add_client) {
        this.add_client = add_client;
    }

    public String add_client() {
        return "";
    }

    public String prenom_client() {
        return "";
    }
}
