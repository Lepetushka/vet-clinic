package com.magicvet.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {

    private static final DateTimeFormatter FORMATTER=DateTimeFormatter.ofPattern("hh:mm dd.MM.yy");
    private String firstName;
    private String lastName;
    private String email;
    private List<Pet> pets = new ArrayList<>();
    private final LocalDateTime registrationDate=LocalDateTime.now();
    private Location location;

    public Client(String firstName, String lastName, String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }
    public Client(){}

    @Override
    public String toString(){
        return "Client:{"
                + "\n\tfirstName = "+ firstName
                + ", lastName =" + lastName
                + ", email = " + email
                + ", location =" + location
                + ", \n\tpets =" + pets
                + ", \n\tregistrationDate = " + registrationDate.format(FORMATTER)
                + "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;

        if (!getFirstName().equals(client.getFirstName())) return false;
        if (!getLastName().equals(client.getLastName())) return false;
        if (!getEmail().equals(client.getEmail())) return false;
        return getPets().equals(client.getPets());
    }

    @Override
    public int hashCode() {
        int result = getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getPets().hashCode();
        return result;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {

        this.pets = pets;
    }

    public void addPet(Pet pet){
        pets.add(pet);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public enum Location {
        KYIV, LVIV, ODESA
    }
}
