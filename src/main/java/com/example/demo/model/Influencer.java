
package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
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
    @JsonManagedReference
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
