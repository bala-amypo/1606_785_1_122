
private Long id;
private DiscountCode discountCode;
private BigDecimal transactionAmount;
private LocalDateTime transactionDate;
private Long customerId;

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

public BigDecimal getTransactionAmount() {
    return transactionAmount;
}
public void setTransactionAmount(BigDecimal transactionAmount) {
    this.transactionAmount = transactionAmount;
}

public LocalDateTime getTransactionDate() {
    return transactionDate;
}
public void setTransactionDate(LocalDateTime transactionDate) {
    this.transactionDate = transactionDate;
}

public Long getCustomerId() {
    return customerId;
}
public void setCustomerId(Long customerId) {
    this.customerId = customerId;
}
