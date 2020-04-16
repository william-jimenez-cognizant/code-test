package org.code.main;

import org.code.model.Auction;
import org.code.model.Bidder;
import org.code.service.AuctionService;
import org.code.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"org.code"})
public class TestApplication implements ApplicationRunner {

    @Autowired
    private AuctionService auctionService;

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Welcome to the Auction app, please register all the bidders");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Introduce the name of the auction");
		Auction auction = new Auction(scanner.nextLine());
        List<Bidder> bidderList = new ArrayList<Bidder>();
        boolean moreBidders = true;
        while (moreBidders) {
            System.out.println("Please insert information for the " + bidderList.size() + " bidder");
            bidderList.add(registerBidder());
            System.out.println("Do yo need to register another bidder? Y/N");
            moreBidders = scanner.nextLine().toUpperCase().equals("Y");
        }
        auctionService.startAuction(bidderList,auction);
        System.out.println();
    }

    private Bidder registerBidder() {
        String name;
        double startingBid, maxBid, autoIncrementAmount;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce the bidder name");
        name = scanner.nextLine();
        System.out.println("Introduce the bidder starting bid");
        //scanner = new Scanner(System.in);
        startingBid = scanner.nextDouble();
        System.out.println("Introduce the bidder max bid");
        maxBid = scanner.nextDouble();
        System.out.println("Introduce the bidder auto increment amount");
        autoIncrementAmount = scanner.nextDouble();
        Bidder bidder = new Bidder(name, startingBid, maxBid, autoIncrementAmount);
        return bidder;
    }
}