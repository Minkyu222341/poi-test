package com.prac.excel.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.prac.excel.domain.ExcelSheet;
import com.prac.excel.domain.dto.ExcelRequest;
import com.prac.excel.domain.dto.ExcelResponse;
import com.prac.excel.repository.CellRepository;
import com.prac.excel.repository.ExcelSheetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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

  public ResponseEntity<?> getCell() {

    List<JsonNode> allCellStatus = excelSheetRepository.findAllCellStatus();

    for (JsonNode cellStatus : allCellStatus) {
//      String title = cellStatus.get("title").asText();
//      JsonNode cellArray = cellStatus.get("cell");
//
//      System.out.println("Title: " + title);
//      System.out.println("Cell Array: " + cellArray);

      System.out.println(cellStatus.get(0));
    }


    return ResponseEntity.ok(null);
  }


  public ResponseEntity<String> addCell(ExcelRequest request) {



    return null;
  }
}
