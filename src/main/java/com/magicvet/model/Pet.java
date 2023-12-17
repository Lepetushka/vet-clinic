package com.magicvet.model;

public class Pet {

    private String type;
    private String sex;
    private String age;
    private String name;
    private String ownerName;

    @Override
    public String toString(){
        return "type: "+type+", name: "+name
                +", sex: "+ sex
                +", age "+age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet pet)) return false;

        if (!getType().equals(pet.getType())) return false;
        if (!getSex().equals(pet.getSex())) return false;
        if (!getAge().equals(pet.getAge())) return false;
        if (!getName().equals(pet.getName())) return false;
        return getOwnerName().equals(pet.getOwnerName());
    }

    @Override
    public int hashCode() {
        int result = getType().hashCode();
        result = 31 * result + getSex().hashCode();
        result = 31 * result + getAge().hashCode();
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

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
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
}
