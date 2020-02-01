package com.example.project.retrofit.config;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubConfig {

    @SerializedName("length")
    @Expose
    private List<Integer> length = null;
    @SerializedName("year")
    @Expose
    private List<Integer> year = null;

    public List<Integer> getLength() {
        return length;
    }

    public void setLength(List<Integer> length) {
        this.length = length;
    }

    public List<Integer> getYear() {
        return year;
    }

    public void setYear(List<Integer> year) {
        this.year = year;
    }

}
