package utils;

import model.UserModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XLSParser {
    @SuppressWarnings("deprecation")
    public List<UserModel> getUsersFromXLS() throws IOException {
        List<UserModel> userModels = new ArrayList<>();
        FileInputStream excelFile = new FileInputStream(new File("src/test/resources/users.xlsx"));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet datatypeSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = datatypeSheet.iterator();

        while (iterator.hasNext()) {
            UserModel user = new UserModel();
            Row currentRow = iterator.next();
            Iterator<Cell> cellIterator = currentRow.iterator();

            while (cellIterator.hasNext()) {
                Cell currentCell = cellIterator.next();
                if (currentCell.getColumnIndex() == 0) {
                    user.setLogin(currentCell.getStringCellValue());
                }
                if (currentCell.getColumnIndex() == 1) {
                    user.setPassword(currentCell.getStringCellValue());
                }
            }
            userModels.add(user);
        }
        return userModels;
    }
}

