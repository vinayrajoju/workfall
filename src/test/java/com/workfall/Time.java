package com.workfall;

import com.workfall.utils.TestUtil;
import org.testng.annotations.Test;

public class Time {

    @Test
    public void dateValidation(){
        TestUtil util = new TestUtil();
        util.currentDateAndTime();
        System.out.println(util.currentDayandMonth);
        util.getDateandTime(String.valueOf(12));
        System.out.println(util.hour);
        System.out.println(util.meridiem);
        System.out.println(util.month);
        System.out.println(util.week);
        System.out.println(util.day);
        System.out.println(util.year);

        util.getDateandTime(String.valueOf(18));
        System.out.println(util.hour);
        System.out.println(util.meridiem);
        System.out.println(util.month);
        System.out.println(util.week);
        System.out.println(util.day);
        System.out.println(util.year);
    }


}
