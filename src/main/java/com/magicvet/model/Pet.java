package com.magicvet.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Pet {

    private static final DateTimeFormatter FORMATTER=DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");

    private String type;
    private String sex;
    private int age;
    private String name;
    private String ownerName;
    private final LocalDateTime registrationDate= LocalDateTime.now();



    @Override
    public String toString() {
        return "Pet {"
                + "type = " + getType()
                + ", sex = " + getSex()
                + ", age = " + getAge()
                + ", name = " + getName()
                + ", ownerName = " + getOwnerName()
                + ", registrationDate = " + getRegistrationDate().format(FORMATTER)
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet pet)) return false;

        if (!getType().equals(pet.getType())) return false;
        if (!getSex().equals(pet.getSex())) return false;
        if (getAge()!=pet.getAge()) return false;
        if (!getName().equals(pet.getName())) return false;
        return getOwnerName().equals(pet.getOwnerName());
    }

    @Override
    public int hashCode() {
        int result = getType().hashCode();
        result = 31 * result + getSex().hashCode();
        result = 31 * result + getAge();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getOwnerName().hashCode();
        return result;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Pet(){}

    public Pet(int age) {
        this.age=age;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }



    public enum HealthState{
        STEADY(1),
        EASY(2),
        MODERATE(3),
        SEVERE(4),
        CRITICAL(5),
        UNKNOWN(0);
        private final int value;

        public static Pet.HealthState fromString(String value) {
            for (Pet.HealthState type : values()) {
                if (type.toString().equals(value)) {
                    return type;
                }
            }

            System.out.println("Unable to parse value '" + value + "'. Using default value: " + UNKNOWN);

            return UNKNOWN;
        }

        HealthState(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

}
