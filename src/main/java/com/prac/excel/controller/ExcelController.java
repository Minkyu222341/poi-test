package com.prac.excel.controller;

import com.prac.excel.domain.ExcelSheet;
import com.prac.excel.domain.dto.ExcelRequest;
import com.prac.excel.domain.dto.ExcelResponse;
import com.prac.excel.service.ExcelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "excel", description = "엑셀 추출 API")
@RestController
@RequiredArgsConstructor
public class ExcelController {
  private final ExcelService excelService;

  @GetMapping("/get")
  @Operation(summary = "셀 목록 조회", description = "모든 셀의 목록을 조회합니다.")
  @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = ExcelSheet.class)))
  @ApiResponse(responseCode = "400", description = "실패", content = @Content(schema = @Schema(implementation = ExcelResponse.class)))
  public ResponseEntity<?> getCell(ExcelRequest request) {
    return excelService.getCell(request);
  }

  @PostMapping("/post")
  public ResponseEntity<String> addExcel(@RequestBody ExcelRequest request) {
    return excelService.addCell(request);
  }

}
