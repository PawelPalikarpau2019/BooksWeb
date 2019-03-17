package my.projects.models.generated;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class SaleInfo {
    private Country country;
    private Saleability saleability;
    private boolean isEbook;
    private String buyLink;
    private SaleInfoListPrice listPrice;
    private SaleInfoListPrice retailPrice;
    private List<Offer> offers;

    @JsonProperty("country")
    public Country getCountry() { return country; }
    @JsonProperty("country")
    public void setCountry(Country value) { this.country = value; }

    @JsonProperty("saleability")
    public Saleability getSaleability() { return saleability; }
    @JsonProperty("saleability")
    public void setSaleability(Saleability value) { this.saleability = value; }

    @JsonProperty("isEbook")
    public boolean getIsEbook() { return isEbook; }
    @JsonProperty("isEbook")
    public void setIsEbook(boolean value) { this.isEbook = value; }

    @JsonProperty("buyLink")
    public String getBuyLink() { return buyLink; }
    @JsonProperty("buyLink")
    public void setBuyLink(String value) { this.buyLink = value; }

    @JsonProperty("listPrice")
    public SaleInfoListPrice getListPrice() { return listPrice; }
    @JsonProperty("listPrice")
    public void setListPrice(SaleInfoListPrice value) { this.listPrice = value; }

    @JsonProperty("retailPrice")
    public SaleInfoListPrice getRetailPrice() { return retailPrice; }
    @JsonProperty("retailPrice")
    public void setRetailPrice(SaleInfoListPrice value) { this.retailPrice = value; }

    @JsonProperty("offers")
    public List<Offer> getOffers() { return offers; }
    @JsonProperty("offers")
    public void setOffers(List<Offer> value) { this.offers = value; }
}
