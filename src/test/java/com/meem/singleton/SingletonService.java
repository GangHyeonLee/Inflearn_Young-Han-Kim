package com.meem.singleton;

public class SingletonService {
    
    private static final SingletonService instance = new SingletonService(); //싱글톤으로 클래스 안에 인스턴스를 스태틱으로 생성.
    
    public static SingletonService getInstaance() {
        return instance;
    }
    
    private SingletonService() {
        
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
    

}
