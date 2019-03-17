package my.projects.models.generated;

import com.fasterxml.jackson.annotation.*;

public class OfferListPrice {
    private long amountInMicros;
    private CurrencyCode currencyCode;

    @JsonProperty("amountInMicros")
    public long getAmountInMicros() { return amountInMicros; }
    @JsonProperty("amountInMicros")
    public void setAmountInMicros(long value) { this.amountInMicros = value; }

    @JsonProperty("currencyCode")
    public CurrencyCode getCurrencyCode() { return currencyCode; }
    @JsonProperty("currencyCode")
    public void setCurrencyCode(CurrencyCode value) { this.currencyCode = value; }
}
