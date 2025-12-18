
private Long id;
private String campaignName;
private LocalDate startDate;
private LocalDate endDate;

public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}

public String getCampaignName() {
    return campaignName;
}
public void setCampaignName(String campaignName) {
    this.campaignName = campaignName;
}

public LocalDate getStartDate() {
    return startDate;
}
public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
}

public LocalDate getEndDate() {
    return endDate;
}
public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
}
