package com.prac.excel.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.prac.excel.CellEnum;
import com.prac.excel.domain.ExcelSheet;
import com.prac.excel.domain.dto.ExcelRequest;
import com.prac.excel.repository.CellRepository;
import com.prac.excel.repository.ExcelSheetRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.swing.border.Border;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

    public ResponseEntity<?> getCell(ExcelRequest request) {

        return ResponseEntity.ok(null);
    }


    public ResponseEntity<String> addCell(ExcelRequest request) {


        return null;
    }


    public String downloadExcel(ExcelRequest request, HttpServletResponse response) throws IOException {
        // 엑셀 워크북 생성
        Workbook workbook = new XSSFWorkbook();

        // 시트 생성
        Sheet sheet = workbook.createSheet("셀 커스텀 테스트");

        // 헤더 행 생성
        Row headerRow = sheet.createRow(0);

        // 헤더 셀 스타일 설정
        CellStyle headerCellStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerCellStyle.setFont(headerFont);
        // 데이터 조회
        List<ExcelSheet> members = excelSheetRepository.findAll();// 데이터 조회를 적절히 수정해야 합니다.

        headerRow.createCell(0).setCellValue("번호");
        headerRow.createCell(1).setCellValue("오더 번호");
        headerRow.createCell(2).setCellValue("주문 번호");
        headerRow.createCell(3).setCellValue("마감 시간");


        // 데이터 행 생성
        int rowNum = 1;
        for (ExcelSheet member : members) { // members를 적절한 데이터 리스트로 변경해야 합니다.
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(rowNum - 1);
            row.createCell(1).setCellValue(member.getId());
            row.createCell(3).setCellValue(member.getOrderCustomId());
            row.createCell(4).setCellValue(member.getOrderId());
            row.createCell(2).setCellValue(member.getCloseTime());
        }
        List<String> data = new ArrayList<>();


        // 셀 크기 조정
        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            sheet.autoSizeColumn(i);
            sheet.setColumnWidth(i, sheet.getColumnWidth(i) * 2); // 두 배로 넓히기
        }

        // 컨텐츠 타입과 파일 이름 설정
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=members.xlsx");

        // 엑셀 파일 출력
        workbook.write(response.getOutputStream());

        // 워크북 및 스트림 닫기
        workbook.close();
        return "ok";
    }


}
