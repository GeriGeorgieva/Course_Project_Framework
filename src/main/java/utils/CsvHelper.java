package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvHelper {
    public static Object[][] readCSVFile(String fileName) throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader(fileName));
        List<String[]> csvData = csvReader.readAll();
        Object[][] result = new Object[csvData.size()][2];
        for (int i = 0; i <csvData.size(); i++) {
            result[i] = csvData.get(i);
        }
        return result;
    }

    public static Object[][] readCsvFile(String s) {
        return new Object[0][];
    }
}
