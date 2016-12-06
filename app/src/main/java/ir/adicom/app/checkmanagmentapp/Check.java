package ir.adicom.app.checkmanagmentapp;

/**
 * Created by adicom on 12/6/16.
 */

public class Check {

    private int id;
    private String price;
    private String vajhe;
    private String babat;
    private String date;

    public String getBabat() {
        return babat;
    }

    public void setBabat(String babat) {
        this.babat = babat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVajhe() {
        return vajhe;
    }

    public void setVajhe(String vajhe) {
        this.vajhe = vajhe;
    }

    public Check() {}

    public Check(int id, String price, String vajhe, String babat, String date) {
        this.id = id;
        this.price = price;
        this.vajhe = vajhe;
        this.babat = babat;
        this.date = date;
    }
}
