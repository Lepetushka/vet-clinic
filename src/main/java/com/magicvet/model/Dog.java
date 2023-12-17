package com.magicvet.model;

public class Dog extends Pet {

    private String size;

    @Override
    public String toString(){
        return "type: "+getType()+", name: "+getName()
                +", sex: "+ getSex()
                +", age "+getAge();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }


}
