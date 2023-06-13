package com.prac.excel.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.prac.excel.domain.dto
 * fileName       : ExcelRequest
 * author         : MinKyu Park
 * date           : 2023-06-12
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-12        MinKyu Park       최초 생성
 */
@Getter
@NoArgsConstructor
public class ExcelRequest {

  private String cellStatus;

  @Builder
  public ExcelRequest(String cellStatus) {
    this.cellStatus = cellStatus;
  }
}
