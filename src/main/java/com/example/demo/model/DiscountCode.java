
com.example.demo.model

private Long id;
private String codeValue;
private Double discountPercentage;
private Influencer influencer;
private Campaign campaign;

public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}

public String getCodeValue() {
    return codeValue;
}
public void setCodeValue(String codeValue) {
    this.codeValue = codeValue;
}

public Double getDiscountPercentage() {
    return discountPercentage;
}
public void setDiscountPercentage(Double discountPercentage) {
    this.discountPercentage = discountPercentage;
}

public Influencer getInfluencer() {
    return influencer;
}
public void setInfluencer(Influencer influencer) {
    this.influencer = influencer;
}

public Campaign getCampaign() {
    return campaign;
}
public void setCampaign(Campaign campaign) {
    this.campaign = campaign;
}
