package org.code.service;

import org.code.model.Auction;
import org.code.model.Bidder;

import java.util.List;

public interface BidService {

    void increaseBid(Bidder bidder, Auction auction);
    boolean evaluateNextBid(Auction auction, Bidder bidder);
}
