package com.workfall.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    static ExtentReports reports;
    public static ExtentReports getReports(){
        if(reports == null){
            reports=new ExtentReports();
            ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/newReport.html");
            htmlReporter.config().setReportName("Production Regression Testing");
            htmlReporter.config().setDocumentTitle("Automation Reports");
            htmlReporter.config().setTheme(Theme.STANDARD);
            htmlReporter.config().setEncoding("utf-8");
            reports.attachReporter(htmlReporter);
        }
        return reports;
    }
}
