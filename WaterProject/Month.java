import java.util.Objects;

import jdk.nashorn.internal.ir.ReturnNode;

public class Month {
    private String date;
    private float gallons, cost;

    public Month(String date, float gallons, float cost) {
        this.date = date;
        this.gallons = gallons;
        this.cost = cost;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getGallons() {
        return this.gallons;
    }

    public void setGallons(float gallons) {
        this.gallons = gallons;
    }

    public float getCost() {
        return this.cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Month))
            return false;
        Month w = (Month)o;
        return date == w.date
            && Objects.equals(date, w.date)
            && Objects.equals(gallons, w.gallons)
            && Objects.equals(cost, w.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, gallons, cost);
    }

    @Override
    public String toString() {
        return String.format("%s, %d, %d", 
        date, gallons, cost);
    }

}