package com.example.model.dto.generated.portfolio;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * PutPortfollioRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.10.0")
public class PutPortfollioRequestDTO {

  private Integer count;

  private String productId;

  public PutPortfollioRequestDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PutPortfollioRequestDTO(Integer count, String productId) {
    this.count = count;
    this.productId = productId;
  }

  public PutPortfollioRequestDTO count(Integer count) {
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

  public PutPortfollioRequestDTO productId(String productId) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PutPortfollioRequestDTO putPortfollioRequestDTO = (PutPortfollioRequestDTO) o;
    return Objects.equals(this.count, putPortfollioRequestDTO.count) &&
        Objects.equals(this.productId, putPortfollioRequestDTO.productId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, productId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PutPortfollioRequestDTO {\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
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

