package hello;

import Logic.CSVToCompetitor;
import Models.Competitor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/test")
    public String test() {
        String csvFile = "/Users/Adam/desktop/registration.csv";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csvFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "Error reading file";
        }

        List<Competitor> competitors = CSVToCompetitor.extractCompetitorsList(br);

        return competitors.get(0).toString();
    }

}
