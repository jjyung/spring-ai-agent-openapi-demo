package com.example.model.dto.generated.account;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * PutInquiryRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.10.0")
public class PutInquiryRequestDTO {

  private BigDecimal amount;

  public PutInquiryRequestDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PutInquiryRequestDTO(BigDecimal amount) {
    this.amount = amount;
  }

  public PutInquiryRequestDTO amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * 修改金額, +100=餘額+100 -100 = 餘額+(-100)
   * @return amount
   */
  @NotNull @Valid 
  @Schema(name = "amount", description = "修改金額, +100=餘額+100 -100 = 餘額+(-100)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("amount")
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PutInquiryRequestDTO putInquiryRequestDTO = (PutInquiryRequestDTO) o;
    return Objects.equals(this.amount, putInquiryRequestDTO.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PutInquiryRequestDTO {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

