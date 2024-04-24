package com.practice.shop;

public class Disc extends Product {

  private final int capacity;
  private final double discount;

  public Disc(String name, double price, int capacity, double discount) {
    super(name, price);
    this.capacity = capacity;
    this.discount = discount;
  }
  public int getCapacity() {
    return capacity;
  }
  @Override
  public String toString() {
    var msg = super.toString() + ", capacity=%dMB, discount=%4.3f";
    return String.format(msg, this.capacity, this.discount);
  }
}