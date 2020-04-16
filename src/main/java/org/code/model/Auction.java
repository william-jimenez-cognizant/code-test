package org.code.model;

public class Auction {

    private String name;
    private double currentBid;
    private boolean isClosed;

    public Auction (String name){
        this.name = name;
        this.currentBid = 0;
        this.isClosed = false;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(double currentBid) {
        this.currentBid = currentBid;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }
}
