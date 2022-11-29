package ru.geekbrains.seminar3;

public class LSP {

    public static void main(String[] args) {

        // Тип S будет подтипом Т тогда и только тогда,
        // когда каждому объекту oS типа S соответствует некий объект oT типа T таким образом,
        // что для всех программ P,
        // реализованных в терминах T, поведение P не будет меняться, если oT заменить на oS.

        Bird bird1 = new Bird(); // oT1
        Bird bird2 = new Bird(); // oT2
        Bird bird3 = new Bird(); // oT3


        Duck duck01 = new Duck(); // oS1
        Duck duck02 = new Duck(); // oS2
        Duck duck03 = new Duck(); // oS3

        Penguin penguin1 = new Penguin();

        Bird bird = new Bird();
        bird.fly();

        fly(bird1);
        fly(bird2);
        fly(bird3);

        fly(duck01);
        fly(duck02);
        fly(duck03);

        fly(penguin1);

    }

    public static void fly(Bird bird){ // МЕТОД P

        if (!(bird instanceof Penguin))
            bird.fly();
    }



}

/**
 * T
 */
class Bird{

    private int flySpeed = 10;

    public void fly() {
        System.out.printf("Птица летит со скоростью %d км/ч\n", flySpeed);
    }
}

/**
 * S
 */
class Duck extends Bird{

    @Override
    public void fly() {
        System.out.printf("Утка летит со скоростью %d км/ч\n", 8);
    }
}

class Penguin extends Bird{

    @Override
    public void fly() {
        System.out.println("Пингвин не умеет летать!!!");
       // throw new RuntimeException("Пингвин не умеет летать!!!");
    }
}








