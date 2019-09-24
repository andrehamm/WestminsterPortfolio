import java.util.Objects;

//import jdk.nashorn.internal.ir.ReturnNode;

public class YearAccount {
    private String date;
    private int account;
    private float gallons, cost;

    public YearAccount(String date, int account, float gallons, float cost) {
        this.date = date;
        this.account = account;
        this.gallons = gallons;
        this.cost = cost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAccount() {
        return this.account;
    }

    public void setAccount(int account) {
        this.account = account;
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
        if (!(o instanceof YearAccount))
            return false;
        YearAccount w = (YearAccount)o;
        return date == w.date
            && Objects.equals(date, w.date)
            && Objects.equals(account, w.account)
            && Objects.equals(gallons, w.gallons)
            && Objects.equals(cost, w.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, account, gallons, cost);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %d %d, %d", 
        date, account, gallons, cost);
    }

}