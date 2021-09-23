package edu.bsu.cs222;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCheckerTest {


    @Test
    public void LocalDateTest(){
        Date today = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(format.format(today));



    }
}
