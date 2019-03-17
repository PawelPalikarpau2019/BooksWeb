package my.projects.models.generated;

import com.fasterxml.jackson.annotation.*;

public class SaleInfoListPrice {
    private double amount;
    private CurrencyCode currencyCode;

    @JsonProperty("amount")
    public double getAmount() { return amount; }
    @JsonProperty("amount")
    public void setAmount(double value) { this.amount = value; }

    @JsonProperty("currencyCode")
    public CurrencyCode getCurrencyCode() { return currencyCode; }
    @JsonProperty("currencyCode")
    public void setCurrencyCode(CurrencyCode value) { this.currencyCode = value; }
}
