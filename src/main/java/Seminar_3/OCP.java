package ru.geekbrains.seminar3;

public class OCP {

    public static void main(String[] args) {

    }



}

class SimpleDrawer{

    public void Draw(Shape shape){

        switch (shape.getShapeType()){
            case Circle:
                drawCircle(shape);
                break;
            case Square:
                drawSquare(shape);
                break;
        }
    }

    private void drawCircle(Shape shape){
        //...
    }

    private void drawSquare(Shape shape){
        //...
    }

}

enum ShapeType{
    Circle,
    Square
}

class Shape {

    private ShapeType shapeType;

    public ShapeType getShapeType() {
        return shapeType;
    }
}


class SimpleDrawerV2{

    public void draw(ShapeV2 shape){
        shape.draw();
    }

    public void add(ShapeV2 shape1, ShapeV2 shape2){

    }

    public  void remove(ShapeV2 shape){

    }

    public  void remove(ShapeV2 shape, int i){

    }

}

abstract class ShapeV2{

    public abstract void draw();

}

class CircleV2 extends ShapeV2{


    @Override
    public void draw() {
        // ....
    }
}













