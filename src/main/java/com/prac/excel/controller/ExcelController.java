package com.prac.excel.controller;

import com.prac.excel.domain.dto.ExcelRequest;
import com.prac.excel.domain.dto.ExcelResponse;
import com.prac.excel.service.ExcelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName    : com.prac.excel.controller
 * fileName       : ExcelController
 * author         : MinKyu Park
 * date           : 2023-06-12
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-12        MinKyu Park       최초 생성
 */
@RestController
@RequiredArgsConstructor
public class ExcelController {
  private final ExcelService excelService;

  @GetMapping("/get")
  public ResponseEntity<?> getCell() {
    return excelService.getCell();
  }

  @PostMapping("/post")
  public ResponseEntity<String> addExcel(@RequestBody ExcelRequest request) {
    return excelService.addCell(request);
  }

}
