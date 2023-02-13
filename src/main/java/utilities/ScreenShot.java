package utilities;

import net.bytebuddy.jar.asm.commons.TryCatchBlockSorter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot{

    //region Variables
    static DateFormat dateFormat = new SimpleDateFormat("ddMMyy");
    static DateFormat timeFormat = new SimpleDateFormat("HHmmss");
    static Date date = new Date();
    //endregion

    //Obtain current Date on format DMY
    public static String getDate(){
        return dateFormat.format(date);
    }

    //Obtain current hour on format HMS
    public static String getHour(){
        return timeFormat.format(date);
    }

    //Take ScreenShot
    public static void takeScreenShot(String screenName, WebDriver driver){
        File myScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            //region Comments
            //The SS It creates on raíz of project
            //FileUtils.copyFile(myScreenShot, new File(screenName + "-" + getDate() + "-"
            //+ getHour() + ".png"));
            //The SS It creates on a file specific
            //endregion
            String path ="screenshots\\";
            FileUtils.copyFile(myScreenShot, new File(path + screenName + "-" +
                    getDate() + "-" + getHour() + ".png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

}