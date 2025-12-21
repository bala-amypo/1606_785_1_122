package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
@Entity
@Table(name = "influencers")
public class Influencer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String socialHandle;

    private boolean active = true;

    private String email;

    @OneToMany(mappedBy = "influencer")
    private List<DiscountCode> discountCodes;

    public Influencer() {}

    public Influencer(String name, String socialHandle, boolean active) {
        this.name = name;
        this.socialHandle = socialHandle;
        this.active = active;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSocialHandle() {
        return socialHandle;
    }
    public void setSocialHandle(String socialHandle) {
        this.socialHandle = socialHandle;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public List<DiscountCode> getDiscountCodes() {
        return discountCodes;
    }
    public void setDiscountCodes(List<DiscountCode> discountCodes) {
        this.discountCodes = discountCodes;
    }
    public String getEmail() {
    return email;
}
    public void setEmail(String email) {
    this.email = email;
}
}
