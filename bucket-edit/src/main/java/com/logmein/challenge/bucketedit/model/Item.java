package com.logmein.challenge.bucketedit.model;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * Item
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-09-20T10:43:42.587Z[GMT]")
public class Item {
  @JsonProperty("itemName")
  private String itemName = null;

  @JsonProperty("quantity")
  private Integer quantity = null;

  @JsonProperty("price")
  private Double price = null;

  @JsonProperty("itemID")
  private UUID itemID = null;

  public Item(String itemName,Integer quantity, Double price, UUID itemID) {
    this.itemName = itemName;
    this.itemID = itemID;
    this.price = price;
    this.quantity = quantity;
  }
  public Item(){}
  /**
   * Get itemName
   * @return itemName
  **/
  @ApiModelProperty(example = "Doll", required = true, value = "")
  @NotNull
  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  /**
   * Get quantity
   * @return quantity
  **/
  @ApiModelProperty(example = "1", value = "")
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
  /**
   * Get price
   * @return price
  **/
  @ApiModelProperty(example = "200.00", value = "")
  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }
  /**
   * Get itemID
   * @return itemID
  **/
  @ApiModelProperty(example = "d290f1ee-6c54-4b01-90e6-d701748f0851", value = "")
  @Valid
  public UUID getItemID() {
    return itemID;
  }

  public void setItemID(UUID itemID) {
    this.itemID = itemID;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Item itemDTO = (Item) o;
    if (!itemName.equals(itemDTO.itemName)) return false;
    return itemID == null ? true:itemID.equals(itemDTO.itemID);
  }

  @Override
  public int hashCode() {
    int result = itemName.hashCode();
    if(itemID != null) result = 31 * result + itemID.hashCode();
    return result;
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemDTO {\n");    
    sb.append("    itemName: ").append(toIndentedString(itemName)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    itemID: ").append(toIndentedString(itemID)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
