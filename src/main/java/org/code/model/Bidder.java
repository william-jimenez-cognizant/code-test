package org.code.model;

public class Bidder {

    private String name;
    private double startingBid;
    private double maxBid;
    private double autoIncrementAmount;
    private double currentBid;

    public Bidder(String name, double startingBid, double maxBid, double autoIncrementAmount){
        this.name = name;
        this.startingBid = startingBid;
        this.maxBid = maxBid;
        this.autoIncrementAmount = autoIncrementAmount;
        this.currentBid = startingBid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getStartingBid() {
        return startingBid;
    }

    public void setStartingBid(double startingBid) {
        this.startingBid = startingBid;
    }

    public double getMaxBid() {
        return maxBid;
    }

    public void setMaxBid(double maxBid) {
        this.maxBid = maxBid;
    }

    public double getAutoIncrementAmount() {
        return autoIncrementAmount;
    }

    public void setAutoIncrementAmount(double autoIncrementAmount) {
        this.autoIncrementAmount = autoIncrementAmount;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(double currentBid) {
        this.currentBid = currentBid;
    }
}
