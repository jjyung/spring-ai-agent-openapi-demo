package com.example.model.dto.generated.order;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * BuyRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.10.0")
public class BuyRequestDTO {

  private String account;

  private String productId;

  private Integer count;

  public BuyRequestDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public BuyRequestDTO(String account, String productId, Integer count) {
    this.account = account;
    this.productId = productId;
    this.count = count;
  }

  public BuyRequestDTO account(String account) {
    this.account = account;
    return this;
  }

  /**
   * 交易帳號
   * @return account
   */
  @NotNull 
  @Schema(name = "account", description = "交易帳號", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("account")
  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public BuyRequestDTO productId(String productId) {
    this.productId = productId;
    return this;
  }

  /**
   * 產品代碼
   * @return productId
   */
  @NotNull 
  @Schema(name = "productId", description = "產品代碼", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("productId")
  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public BuyRequestDTO count(Integer count) {
    this.count = count;
    return this;
  }

  /**
   * 數量
   * @return count
   */
  @NotNull 
  @Schema(name = "count", description = "數量", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("count")
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BuyRequestDTO buyRequestDTO = (BuyRequestDTO) o;
    return Objects.equals(this.account, buyRequestDTO.account) &&
        Objects.equals(this.productId, buyRequestDTO.productId) &&
        Objects.equals(this.count, buyRequestDTO.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(account, productId, count);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BuyRequestDTO {\n");
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

