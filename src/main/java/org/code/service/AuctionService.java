package org.code.service;

import org.code.model.Auction;
import org.code.model.Bidder;

import java.util.List;

public interface AuctionService {

    void startAuction(List<Bidder> bidders, Auction auction);

}
