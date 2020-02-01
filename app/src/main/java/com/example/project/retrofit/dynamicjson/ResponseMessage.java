package com.example.project.retrofit.dynamicjson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseMessage extends ResponseWrapper {

    @SerializedName("surname")
    @Expose
    private String surname;
    @SerializedName("forename")
    @Expose
    private String forename;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("refNo")
    @Expose
    private String refNo;
    @SerializedName("result")
    @Expose
    private String result;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
