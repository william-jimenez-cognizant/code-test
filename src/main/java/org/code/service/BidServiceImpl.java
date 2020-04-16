package org.code.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.code.model.Auction;
import org.code.model.Bidder;
import org.springframework.stereotype.Service;

@Service
public class BidServiceImpl implements BidService {

    Logger logger = LogManager.getLogger(BidServiceImpl.class);

    @Override
    public void increaseBid(Bidder bidder, Auction auction) {
        logger.info("the bidder" + bidder.getName() + " is increasing its bid");
        double currentBid = bidder.getCurrentBid();
        while (currentBid <= auction.getCurrentBid() && currentBid < bidder.getMaxBid()) {
            currentBid = currentBid + bidder.getAutoIncrementAmount();
        }
        if (currentBid <= bidder.getMaxBid()) {
            bidder.setCurrentBid(currentBid);
        }
    }

    @Override
    public boolean evaluateNextBid(Auction auction, Bidder bidder) {
        return (auction.getCurrentBid() <= bidder.getMaxBid() &&
                bidder.getMaxBid() - bidder.getCurrentBid() >= bidder.getAutoIncrementAmount());
    }
}
