package com.workfall.data;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class GetData {

    public static String getPartnerName() throws IOException {
        File src = new File(System.getProperty("user.dir")+"/Excel/Workfall Data.xlsx");
        FileInputStream fr = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fr);
        XSSFSheet xs = xsf.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        String partnerName = dataFormatter.formatCellValue((xs.getRow(1).getCell(0)));

        return partnerName;
    }
    public static String getBookingHours() throws IOException {
        File src = new File(System.getProperty("user.dir")+"/Excel/Workfall Data.xlsx");
        FileInputStream fr = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fr);
        XSSFSheet xs = xsf.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        String hour = dataFormatter.formatCellValue((xs.getRow(1).getCell(1)));

        return hour;
    }
    public static String getWorkStreamDescription() throws IOException {
        File src = new File(System.getProperty("user.dir")+"/Excel/Workfall Data.xlsx");
        FileInputStream fr = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fr);
        XSSFSheet xs = xsf.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        String description = dataFormatter.formatCellValue((xs.getRow(1).getCell(2)));

        return description;
    }
    public static @NotNull String getClientFullName() throws IOException {
        File src = new File(System.getProperty("user.dir")+"/Excel/Workfall Data.xlsx");
        FileInputStream fr = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fr);
        XSSFSheet xs = xsf.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        String partnerFullName = dataFormatter.formatCellValue((xs.getRow(1).getCell(3))).toLowerCase();

        return partnerFullName;
    }
    public static String getClientName() throws IOException {
        File src = new File(System.getProperty("user.dir")+"/Excel/Workfall Data.xlsx");
        FileInputStream fr = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fr);
        XSSFSheet xs = xsf.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        String clientName = dataFormatter.formatCellValue((xs.getRow(1).getCell(4)));

        return clientName;
    }
    public static String getSlot1Date() throws IOException {
        File src = new File(System.getProperty("user.dir")+"/Excel/Workfall Data.xlsx");
        FileInputStream fr = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fr);
        XSSFSheet xs = xsf.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        String date = dataFormatter.formatCellValue((xs.getRow(1).getCell(5)));

        return date;
    }
    public static String getSlot1Time() throws IOException {
        File src = new File(System.getProperty("user.dir")+"/Excel/Workfall Data.xlsx");
        FileInputStream fr = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fr);
        XSSFSheet xs = xsf.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        String time = dataFormatter.formatCellValue((xs.getRow(1).getCell(6)));

        return time;
    }
    public static String getSlot2Date() throws IOException {
        File src = new File(System.getProperty("user.dir")+"/Excel/Workfall Data.xlsx");
        FileInputStream fr = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fr);
        XSSFSheet xs = xsf.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        String date = dataFormatter.formatCellValue((xs.getRow(1).getCell(7)));

        return date;
    }
    public static String getSlot2Time() throws IOException {
        File src = new File(System.getProperty("user.dir")+"/Excel/Workfall Data.xlsx");
        FileInputStream fr = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fr);
        XSSFSheet xs = xsf.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        String date = dataFormatter.formatCellValue((xs.getRow(1).getCell(8)));

        return date;
    }
    public static String getSlot3Date() throws IOException {
        File src = new File(System.getProperty("user.dir")+"/Excel/Workfall Data.xlsx");
        FileInputStream fr = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fr);
        XSSFSheet xs = xsf.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        String date = dataFormatter.formatCellValue((xs.getRow(1).getCell(9)));

        return date;
    }
    public static String getSlot3Time() throws IOException {
        File src = new File(System.getProperty("user.dir")+"/Excel/Workfall Data.xlsx");
        FileInputStream fr = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fr);
        XSSFSheet xs = xsf.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        String date = dataFormatter.formatCellValue((xs.getRow(1).getCell(10)));

        return date;
    }
    public static String getWorkStreamSubmissionDate() throws IOException {
        File src = new File(System.getProperty("user.dir") + "/Excel/Workfall Data.xlsx");
        FileInputStream fr = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fr);
        XSSFSheet xs = xsf.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        String date = dataFormatter.formatCellValue((xs.getRow(1).getCell(20)));

        return date;
    }
    public static String getWorkStreamSubmissionHours() throws IOException {
        File src = new File(System.getProperty("user.dir") + "/Excel/Workfall Data.xlsx");
        FileInputStream fr = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fr);
        XSSFSheet xs = xsf.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        String date = dataFormatter.formatCellValue((xs.getRow(1).getCell(11)));

        return date;
    }
    public static String getWorkStreamSubmissionDescription() throws IOException {
        File src = new File(System.getProperty("user.dir") + "/Excel/Workfall Data.xlsx");
        FileInputStream fr = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fr);
        XSSFSheet xs = xsf.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        String description= dataFormatter.formatCellValue((xs.getRow(1).getCell(12)));

        return description;
    }

    public static String getWorkStreamDay() throws IOException {
        File src = new File(System.getProperty("user.dir") + "/Excel/Workfall Data.xlsx");
        FileInputStream fr = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fr);
        XSSFSheet xs = xsf.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        String day = dataFormatter.formatCellValue((xs.getRow(1).getCell(14)));

        return day;
    }


    public static String getAcceptWorkStreamHours() throws IOException {
        File src = new File(System.getProperty("user.dir") + "/Excel/Workfall Data.xlsx");
        FileInputStream fr = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fr);
        XSSFSheet xs = xsf.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        String hour = dataFormatter.formatCellValue((xs.getRow(1).getCell(15)));

        return hour;
    }

    public static String getAcceptanceNotes() throws IOException {
        File src = new File(System.getProperty("user.dir") + "/Excel/Workfall Data.xlsx");
        FileInputStream fr = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fr);
        XSSFSheet xs = xsf.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        String notes = dataFormatter.formatCellValue((xs.getRow(1).getCell(16)));

        return notes;
    }

    public static String getRejectWorkStreamHours() throws IOException {
        File src = new File(System.getProperty("user.dir") + "/Excel/Workfall Data.xlsx");
        FileInputStream fr = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fr);
        XSSFSheet xs = xsf.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        String date = dataFormatter.formatCellValue((xs.getRow(1).getCell(17)));

        return date;
    }

    public static String getRejectNotes() throws IOException {
        File src = new File(System.getProperty("user.dir") + "/Excel/Workfall Data.xlsx");
        FileInputStream fr = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fr);
        XSSFSheet xs = xsf.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        String notes = dataFormatter.formatCellValue((xs.getRow(1).getCell(18)));

        return notes;
    }
    public static String getCardHolderName() throws IOException {
        File src = new File(System.getProperty("user.dir") + "/Excel/Workfall Data.xlsx");
        FileInputStream fr = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fr);
        XSSFSheet xs = xsf.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        String name_On_Card = dataFormatter.formatCellValue((xs.getRow(1).getCell(19)));

        return name_On_Card;
    }
    public static String getCardNumber() throws IOException {
        File src = new File(System.getProperty("user.dir") + "/Excel/Workfall Data.xlsx");
        FileInputStream fr = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fr);
        XSSFSheet xs = xsf.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        String cardNumber = dataFormatter.formatCellValue((xs.getRow(1).getCell(20)));

        return cardNumber;
    }
    public static String getCardExpDate() throws IOException {
        File src = new File(System.getProperty("user.dir") + "/Excel/Workfall Data.xlsx");
        FileInputStream fr = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fr);
        XSSFSheet xs = xsf.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        String expDate = dataFormatter.formatCellValue((xs.getRow(1).getCell(21)));

        return expDate;
    }
    public static String getCardCVV() throws IOException {
        File src = new File(System.getProperty("user.dir") + "/Excel/Workfall Data.xlsx");
        FileInputStream fr = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fr);
        XSSFSheet xs = xsf.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        String CVV = dataFormatter.formatCellValue((xs.getRow(1).getCell(22)));

        return CVV;
    }

}
