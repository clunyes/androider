package structural_design_pattern.facde;

public class MyFacade {
    private Camera camera1, camera2;
    private Light light1;
    private Sensor sensor1, sensor2, sensor3;

    public MyFacade() {
        camera1 = new Camera();
        camera2 = new Camera();
        light1 = new Light();
        sensor1 = new Sensor();
        sensor2 = new Sensor();
        sensor3 = new Sensor();
    }

    public void turnOn() {
        camera1.turnOn();
        camera2.turnOn();
        light1.turnOn();
        sensor1.turnOn();
        sensor2.turnOn();
        sensor3.turnOn();
    }

    public void turnOff() {
        camera1.turnOff();
        camera2.turnOff();
        light1.turnOff();
        sensor1.turnOff();
        sensor2.turnOff();
        sensor3.turnOff();
    }
}
