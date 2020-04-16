package org.code.service;

import org.code.model.Auction;
import org.code.model.Bidder;
import org.code.service.AuctionService;
import org.code.service.BidService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionServiceImpl implements AuctionService {



    @Autowired
    private BidService bidService;

    @Override
    public void startAuction(List<Bidder> bidders, Auction auction) {
        while (!auction.isClosed()) {
            bidders.forEach(bidder -> {
                if (bidService.evaluateNextBid(auction, bidder)) {
                    bidService.increaseBid(bidder, auction);
                    if (bidder.getCurrentBid() > auction.getCurrentBid()) {
                        auction.setCurrentBid(bidder.getCurrentBid());
                    }
                }
            });
            verifyAuctionLeaving(auction, bidders);
            if (bidders.size() < 2) {
                auction.setClosed(true);
            }
        }
        System.out.println("The Winner of the auction is " + bidders.get(0).getName());
        System.out.println("The Winner bid is " + bidders.get(0).getCurrentBid());

    }

    /*
    Verify if any bidder leaves de auction because of his max bid has been exceeded
    */
    private void verifyAuctionLeaving(Auction auction, List<Bidder> bidders) {
        auction.setClosed(true);
        for (int i = 0; i < bidders.size(); i++) {
            if (!bidService.evaluateNextBid(auction, bidders.get(i))) {
                if (bidders.get(i).getCurrentBid() < auction.getCurrentBid()) {
                    bidders.remove(i);
                    i--;
                }
            } else {
                auction.setClosed(false);
            }
        }
    }
}
