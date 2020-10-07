package com.logmein.challenge.bucketedit.model;

import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-09-20T10:43:42.587Z[GMT]")
public class OrderItem {
	@JsonProperty("userID")
	private String userID;
	@JsonProperty("item")
	private Item item;
	  /**
	   * Get userID
	   * @return userID
	  **/
	  @ApiModelProperty(example = "John Sharma", required = true, value = "")
	  @NotNull
	  public String getUserID() {
	    return userID;
	  }

	  public void setUserID(String userID) {
	    this.userID = userID;
	  }	

	  /**
	   * Get item
	   * @return item
	  **/
	  @ApiModelProperty(required = true, value = "")
	  @NotNull
	  @Valid
	  public Item getItem() {
	    return item;
	  }

	  public void setItem(Item item) {
	    this.item = item;
	  }


	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    OrderItem orderItem = (OrderItem) o;
	    return Objects.equals(this.userID, orderItem.userID) &&
	        Objects.equals(this.item, orderItem.item);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(userID, item);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class OrderItem {\n");
	    sb.append("    userID: ").append(toIndentedString(userID)).append("\n");
	    sb.append("    item: ").append(toIndentedString(item)).append("\n");
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
