package com.example.model.dto.generated.portfolio;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;

import java.util.Objects;

/**
 * GetPortfolioResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.10.0")
public class GetPortfolioResponseDTO {

  private String productId;

  private Integer count;

  public GetPortfolioResponseDTO productId(String productId) {
    this.productId = productId;
    return this;
  }

  /**
   * 產品代碼
   * @return productId
   */
  
  @Schema(name = "productId", description = "產品代碼", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("productId")
  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public GetPortfolioResponseDTO count(Integer count) {
    this.count = count;
    return this;
  }

  /**
   * 數量
   * @return count
   */
  
  @Schema(name = "count", description = "數量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    GetPortfolioResponseDTO getPortfolioResponseDTO = (GetPortfolioResponseDTO) o;
    return Objects.equals(this.productId, getPortfolioResponseDTO.productId) &&
        Objects.equals(this.count, getPortfolioResponseDTO.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, count);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetPortfolioResponseDTO {\n");
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

