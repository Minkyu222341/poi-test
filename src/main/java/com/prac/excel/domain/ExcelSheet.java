package com.prac.excel.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.prac.excel
 * fileName       : ExcelSheet
 * author         : MinKyu Park
 * date           : 2023-06-12
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-12        MinKyu Park       최초 생성
 */
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExcelSheet {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Lob
  @Column(columnDefinition = "jsonb")
  private String cellStatus;

  @Builder
  public ExcelSheet(Long id, String cellStatus) {
    this.id = id;
    this.cellStatus = cellStatus;
  }


}
