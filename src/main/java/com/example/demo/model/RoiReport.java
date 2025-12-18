
private Long id;
private DiscountCode discountCode;
private BigDecimal totalSales;
private Integer totalTransactions;
private Double roiPercentage;

public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}

public DiscountCode getDiscountCode() {
    return discountCode;
}
public void setDiscountCode(DiscountCode discountCode) {
    this.discountCode = discountCode;
}

public BigDecimal getTotalSales() {
    return totalSales;
}
public void setTotalSales(BigDecimal totalSales) {
    this.totalSales = totalSales;
}

public Integer getTotalTransactions() {
    return totalTransactions;
}
public void setTotalTransactions(Integer totalTransactions) {
    this.totalTransactions = totalTransactions;
}

public Double getRoiPercentage() {
    return roiPercentage;
}
public void setRoiPercentage(Double roiPercentage) {
    this.roiPercentage = roiPercentage;
}
