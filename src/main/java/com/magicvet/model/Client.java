package com.magicvet.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Client {

    private static final DateTimeFormatter FORMATTER=DateTimeFormatter.ofPattern("hh:mm dd.MM.yy");
    private String firstName;
    private String lastName;
    private String email;
    private Pet pet;
    private final LocalDateTime registrationDate=LocalDateTime.now();

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
                + ", \n\tpet =" + pet
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
        return getPet().equals(client.getPet());
    }

    @Override
    public int hashCode() {
        int result = getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getPet().hashCode();
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

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
