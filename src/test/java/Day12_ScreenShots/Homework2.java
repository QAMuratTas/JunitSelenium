package Day12_ScreenShots;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class Homework2 extends BaseTest {

//    Go to URL: https://the-internet.herokuapp.com/tables
//    Print the entire table
//    Print All Rows
//    Print Last row data only
//    Print column 5 data in the table body
//    Write a method that accepts 2 parameters
//    parameter 1 = row number
//    parameter 2 = column number
//    printData(3,4); => prints
//    parameter 3 = table id
//    printData(3,4,"table1") => prints data in 3rd row 4th Column with table id

    @Test
    public void webTablesTest() {
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement table1 = driver.findElement(By.id("table1"));

        System.out.println(table1.getText());

        int rowTable1 = table1.findElements(By.xpath(".//tr")).size();
        System.out.println(rowTable1);
        System.out.println("********* Table1 rows *************");
        for (int i = 1; i < rowTable1; i++) {
            System.out.println(table1.findElement(By.xpath("(.//tr)[" + i + "]")).getText());
        }

        System.out.println();
        System.out.println("Last Row :" + table1.findElement(By.xpath("(.//tr)[" + (rowTable1 - 1) + "]")).getText());

        System.out.println();
        System.out.println("Column 5 table body ");
        for (int i = 1; i < rowTable1; i++) {
            System.out.println(table1.findElement(By.xpath(".//tr[" + i + "]//td[5]")).getText());
        }

        System.out.println();
        System.out.println("Methods called");
        printData(3, 4);
        printdata1(3, 4, table1);

    }

    public void printData(int row, int column) {

        WebElement table1 = driver.findElement(By.id("table1"));
        System.out.println(table1.findElement(By.xpath(".//tr[" + row + "]//td[" + column + "]")).getText());


    }

    public void printdata1(int row, int column, WebElement table1) {

        System.out.println(table1.findElement(By.xpath(".//tr[" + row + "]//td[" + column + "]")).getText());


    }


}
