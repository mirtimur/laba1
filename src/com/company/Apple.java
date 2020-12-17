package com.company;

public class Apple extends Food implements Nutritious {

    private String size;


    public Apple(String size) {
        super("Яблоко");
        this.size = size;

    }

    @Override
    public void consume() {
        System.out.println(this + " съедено"+" каллорий "+calculateCalories());
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if (!(arg0 instanceof Apple)) return false;
            return size.equals(((Apple)arg0).size);
        } else
            return false;
    }

    public String toString() {
        return super.toString() + " размера " + size.toUpperCase();
    }


    @Override
    public int calculateCalories() {
        if(this.size==null){
            return 0;
        }
        switch (this.size.toLowerCase()){
            case "малый": return 10;
            case "средний": return 20;
            case "большой": return 30;
            default: return 0;
        }
    }

}