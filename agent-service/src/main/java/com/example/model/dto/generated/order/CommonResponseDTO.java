package com.example.model.dto.generated.order;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CommonResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.10.0")
public class CommonResponseDTO {

  private String message;

  private String returnCode;

  public CommonResponseDTO message(String message) {
    this.message = message;
    return this;
  }

  /**
   * 回傳訊息
   * @return message
   */
  
  @Schema(name = "message", description = "回傳訊息", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public CommonResponseDTO returnCode(String returnCode) {
    this.returnCode = returnCode;
    return this;
  }

  /**
   * 狀態碼
   * @return returnCode
   */
  
  @Schema(name = "returnCode", description = "狀態碼", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("returnCode")
  public String getReturnCode() {
    return returnCode;
  }

  public void setReturnCode(String returnCode) {
    this.returnCode = returnCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommonResponseDTO commonResponseDTO = (CommonResponseDTO) o;
    return Objects.equals(this.message, commonResponseDTO.message) &&
        Objects.equals(this.returnCode, commonResponseDTO.returnCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, returnCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommonResponseDTO {\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    returnCode: ").append(toIndentedString(returnCode)).append("\n");
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

