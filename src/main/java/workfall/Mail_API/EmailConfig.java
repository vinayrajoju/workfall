package workfall.Mail_API;

import workfall.TestBase.App;

import java.util.Properties;

public class EmailConfig extends App
{
    Properties prop;
    public static final String SERVER = "smtp.gmail.com";
    public static final String PORT = "587";

    public static final String FROM = "vinay.rajoju@workfall.com";
    public static final String PASSWORD = "rajoju@10";

    /* "**********@gmail.com", */
    public static final String[] TO = {"vineethworfall@gmail.com"};
    public static final String SUBJECT = "Workfall | "+App.prop.getProperty("client")+" has send a NIUM Payment Request";
}
