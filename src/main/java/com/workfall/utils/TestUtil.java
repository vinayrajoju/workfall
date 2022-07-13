package com.workfall.utils;

import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    public static long Page_Load_Timeout = 20;
    public static long Implicit_Wait = 10;


    public static String hour;
    public static String meridiem;
    public static String month;
    public static String week;
    public static Integer day;
    public static String year;
    public static String currentWeek;
    public static String currentHour;
    public static String currentDayandMonth;

    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }
    public void waitTime() throws InterruptedException {
        Thread.sleep(3000);
    }
    public void getDateandTime(String slotDif){

        LocalDateTime dateTime = LocalDateTime.now().plusHours(Integer.valueOf(slotDif));
        DateTimeFormatter hourFormat = DateTimeFormatter.ofPattern("hh");
        hour = dateTime.format(hourFormat);

        DateTimeFormatter meridiemFormat = DateTimeFormatter.ofPattern("a");
        meridiem = dateTime.format(meridiemFormat);

        DateTimeFormatter monthFormat = DateTimeFormatter.ofPattern("MMMM");
        month = dateTime.format(monthFormat);

        DateTimeFormatter weekFormat = DateTimeFormatter.ofPattern("EEEE");
        week = dateTime.format(weekFormat);

        DateTimeFormatter dayFormat = DateTimeFormatter.ofPattern("dd");
        day = Integer.valueOf(dateTime.format(dayFormat));

        DateTimeFormatter yearFormat = DateTimeFormatter.ofPattern("YYYY");
        year = dateTime.format(yearFormat);
    }

    public void currentDateAndTime(){
        LocalDateTime time= LocalDateTime.now();
        currentWeek = time.format(DateTimeFormatter.ofPattern("EEEE"));
        currentHour = time.format(DateTimeFormatter.ofPattern("hh"));
        currentDayandMonth =time.format(DateTimeFormatter.ofPattern("MMM"+" "+"dd"));
    }
}
