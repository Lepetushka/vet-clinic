package com.magicvet.model;

public class Dog extends Pet {


    private Size size;

    public Dog(){}

    public Dog(Size size){
        this.size=size;

    }
    @Override
    public String toString(){
        return "type: "+getType()+", name: "+getName()
                +", sex: "+ getSex()
                +", age "+getAge();
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public enum Size{
        XS(1),
        S(2),
        M(3),
        L(4),
        XL(5),
        UNNULL(0);
        private final int value;

        Size(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


}
