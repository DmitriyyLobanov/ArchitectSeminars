package ru.geekbrains.seminar3;

public class ISP {


    public static void main(String[] args) {

    }

}

interface Animal{

    void run();
    void swim();
    //void fly();
}

interface Flying{
    void fly();
}

class Cat implements Animal{

    @Override
    public void run() {
        System.out.println("Котик бегает.");
    }

    @Override
    public void swim() {
        System.out.println("Котик плавает. Иногда, если очень захочет.");
    }


}

class DuckV2 implements Animal, Flying{

    @Override
    public void run() {
        System.out.println("Утка бегает.");
    }

    @Override
    public void swim() {
        System.out.println("Утка плавает.");
    }

    @Override
    public void fly() {
        System.out.println("Утка летает.");
    }

}