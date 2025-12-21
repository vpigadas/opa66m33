package com.example.myapplication.network;

import java.util.List;
import java.util.Objects;

public class JsonReader {

    private String id;
    private String name;
    private List<String> photoUrls;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        JsonReader that = (JsonReader) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(photoUrls, that.photoUrls);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(photoUrls);
        return result;
    }

    @Override
    public String toString() {
        return "JsonReader{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                '}';
    }
}
