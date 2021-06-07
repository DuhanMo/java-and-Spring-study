package ch19;

public class Factory {
    private static Factory instance = new Factory();

    private Factory (){
    }

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public Car createCar() {
        return new Car();
    }
}
