package ru.kpfu.net.model;

public class Car {
    private int id;
    private String name;
    private String brand;
    private String creationData;
    private String engineType;
    private String gearbox;
    private String gear;

    public Car(int id, String name, String brand, String creationData, String engineType, String gearbox, String gear){
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.creationData = creationData;
        this.engineType = engineType;
        this.gearbox = gearbox;
        this.gear = gear;
    }

    public Car(String name, String brand, String creationData, String engineType, String gearbox, String gear) {
        this.name = name;
        this.brand = brand;
        this.creationData = creationData;
        this.engineType = engineType;
        this.gearbox = gearbox;
        this.gear = gear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCreationData() {
        return creationData;
    }

    public void setCreationData(String creationData) {
        this.creationData = creationData;
    }


    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }
}
