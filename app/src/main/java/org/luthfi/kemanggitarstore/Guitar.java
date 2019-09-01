package org.luthfi.kemanggitarstore;

public class Guitar {

    private String brand;
    private String price;
    private String deskripsi;
    private String photo;

    public String getInfo() {
        return brand;
    }

    public void setInfo(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String from) {
        this.price = from;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String from) {
        this.deskripsi = from;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


}
