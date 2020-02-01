package com.example.project.retrofit.config;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SectionSentence {
    @SerializedName("phrase")
    @Expose
    private String phrase;
    @SerializedName("mean")
    @Expose
    private String mean;
    @SerializedName("meaning")
    @Expose
    private String meaning;
    @SerializedName("iconUrl")
    @Expose
    private String iconUrl;
    @SerializedName("audioUrl")
    @Expose
    private String audioUrl;
    @SerializedName("audio")
    @Expose
    private String audio;
    @SerializedName("video")
    @Expose
    private String video;
    private int type;
    private boolean isRight;
    private boolean isPass = false;
    private boolean isFromMicro = false;

    public SectionSentence() {
    }

    public SectionSentence(String phrase) {
        this.phrase = phrase;
        this.mean = "";
    }

    public SectionSentence(String phrase, String mean, int type) {
        this.phrase = phrase;
        this.mean = mean;
        this.type = type;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    public boolean isPass() {
        return isPass;
    }

    public void setPass(boolean pass) {
        isPass = pass;
    }

    public boolean isFromMicro() {
        return isFromMicro;
    }

    public void setFromMicro(boolean fromMicro) {
        isFromMicro = fromMicro;
    }
}
