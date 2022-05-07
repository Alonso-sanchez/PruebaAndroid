package com.example.rickmorty;

public class Results {
    String name;
    String status;
    String species;
    String gender;
    origin origin;
    String image;


    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecies() {
        return species;
    }

    public String getGender() {
        return gender;
    }

    public String getOrigin()  { return origin.getName();  }

    public String getImage() { return image; }

}

class origin{
    String name;
    String url;

    public origin() {

    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}