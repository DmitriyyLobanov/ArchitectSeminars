package Seminar_1.ModelElements;

public class Camera {

    private Point3D location;
    private Angle3D angle;

    public Point3D getLocation() {
        return location;
    }

    public void setLocation(Point3D location) {
        this.location = location;
    }

    public Angle3D getAngle() {
        return angle;
    }

    public void setAngle(Angle3D angle) {
        this.angle = angle;
    }


    public Camera(Point3D location, Angle3D angle) {
        this.location = location;
        this.angle = angle;
    }

    public Camera() {
    }

    public void rotate(Angle3D angle){
        //TODO вращение освещения
    }

    public void move(Point3D point){
        //TODO перемещение освещения
    }
}
