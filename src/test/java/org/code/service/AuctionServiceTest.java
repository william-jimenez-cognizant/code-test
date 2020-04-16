package org.code.service;

import org.code.main.TestApplication;
import org.code.model.Auction;
import org.code.model.Bidder;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication
@SpringBootTest
@ComponentScan(basePackages = {"org.code.service"})
public class AuctionServiceTest {

    @Autowired
    private AuctionService auctionService;

    @Test
    public void startAuctionPianoTest() {
        List<String> data = readCsvFile("src/test/resources/PianoTestCase.csv");
        List<Bidder> bidderList = new ArrayList<Bidder>();

        data.forEach(line -> {
            String[] values = line.split(",");
            bidderList.add(new Bidder(values[0], Double.parseDouble(values[1]),
                    Double.parseDouble(values[2]), Double.parseDouble(values[3])));
        });
        auctionService.startAuction(bidderList, new Auction("Test"));
    }

    @Test
    public void startAuctionRecordPlayerTest() {
        List<String> data = readCsvFile("src/test/resources/RecordPlayerTestCase.csv");
        List<Bidder> bidderList = new ArrayList<Bidder>();

        data.forEach(line -> {
            String[] values = line.split(",");
            bidderList.add(new Bidder(values[0], Double.parseDouble(values[1]),
                    Double.parseDouble(values[2]), Double.parseDouble(values[3])));
        });
        auctionService.startAuction(bidderList, new Auction("Test"));
    }

    @Test
    public void startAuctionSnowShoesTest() {
        List<String> data = readCsvFile("src/test/resources/SnowShoesTestCase.csv");
        List<Bidder> bidderList = new ArrayList<Bidder>();

        data.forEach(line -> {
            String[] values = line.split(",");
            bidderList.add(new Bidder(values[0], Double.parseDouble(values[1]),
                    Double.parseDouble(values[2]), Double.parseDouble(values[3])));
        });
        auctionService.startAuction(bidderList, new Auction("Test"));
    }

    private List<String> readCsvFile(String csvFileLocation) {
        BufferedReader bufferedReader = null;
        String line = "";
        List<Bidder> bidderList = new ArrayList<Bidder>();
        List<String> lines = new ArrayList<String>();
        try {

            bufferedReader = new BufferedReader(new FileReader(csvFileLocation));
            String[] values = null;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return lines;
    }
}