package ru.rstyle;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {

    @Test
    public void getConnection() throws SQLException {
        Assert.assertEquals(46, App.getEuropeCountries());
    }

}