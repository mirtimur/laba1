package com.company;

public class ChewingGum extends Food implements Nutritious {

    private String flavour;


    public ChewingGum(String flavour) {
        super("Жевательная резинка");
        this.flavour = flavour;

    }

    @Override
    public void consume() {
        System.out.println(this + " съедено" + " каллорий " + calculateCalories());
    }

    public String getFlavour() {
        return flavour;
    }

    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if (!(arg0 instanceof ChewingGum)) return false;
            return flavour.equals(((ChewingGum)arg0).flavour);
        } else
            return false;
    }

    public String toString() {
        return super.toString() + " вкуса " + flavour.toUpperCase();
    }

    @Override
    public int calculateCalories() {
        if (this.flavour == null) {
            return 0;
        }
        switch (this.flavour.toLowerCase()) {
            case "мята":
                return 15;
            case "арбуз":
                return 16;
            case "вишня":
                return 17;
            default: return 0;
        }
    }

}
