package Day9_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class c8_fileExist {
    @Test
    public void fileExist() {

    //C:\\Users\\MURAT\\Desktop\\fileExist.png
        System.out.println(System.getProperty("user.home"));
        String homePath = System.getProperty("user.home");
        String filePath = "\\Desktop\\fileExist.png";
        String fullPath =homePath+filePath;
        File image =new File(fullPath);
        Assert.assertTrue(image.exists());


    }


}
