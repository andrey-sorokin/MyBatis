package ru.rstyle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private static final Logger logger = Logger.getLogger(App.class);

    private static ApplicationContext context =
            new ClassPathXmlApplicationContext("/database/Spring-DataSource.xml");

    private static DataSource dataSource = (DataSource) context.getBean("dataSource");

    public static int getEuropeCountries() {

        String sql = "SELECT count(*) as Europe FROM world.country where Continent = 'Europe'";
        int numberOfCountires = 0;

        try (Connection conn = dataSource.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                numberOfCountires = rs.getInt("Europe");
            }
            logger.info("The number of countries in Europe is : " + numberOfCountires);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return numberOfCountires;

    }

}
