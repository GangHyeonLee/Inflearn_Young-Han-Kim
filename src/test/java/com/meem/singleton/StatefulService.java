package com.meem.singleton;

public class StatefulService {
    
    //private int price; // 상태를 유지하는 필드
    
    /*
     * public void order(String name, int price) { System.out.println("name = " +
     * name + "price = " + price); this.price = price; // 여기가 문제!
     * 
     * }
     */
    
    //stateless 무상태 로 설계하면 문제는 해결된다.
    public int order(String name, int price) {
        System.out.println("name = " + name + "price = " + price);
       // this.price = price; // 여기가 문제!
        return price;
        
    }
    
    /*
     * public int getPrice() { return price; }
     */

}
