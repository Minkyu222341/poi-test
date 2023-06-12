package com.prac.excel.service;

import com.prac.excel.domain.ExcelSheet;
import com.prac.excel.domain.dto.ExcelRequest;
import com.prac.excel.domain.dto.ExcelResponse;
import com.prac.excel.repository.CellRepository;
import com.prac.excel.repository.ExcelSheetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.prac.excel.service
 * fileName       : ExcelService
 * author         : MinKyu Park
 * date           : 2023-06-12
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-12        MinKyu Park       최초 생성
 */
@Service
@RequiredArgsConstructor
public class ExcelService {
  private final CellRepository cellRepository;
  private final ExcelSheetRepository excelSheetRepository;

  public ResponseEntity<ExcelResponse> getCell() {
    return null;
  }

  public ResponseEntity<String> addCell(ExcelRequest request) {



    return null;
  }
}
