package com.example.project.retrofit.config;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OnlineCourse {

    @SerializedName("conversationWrongReaction")
    @Expose
    private List<SectionSentence> conversationWrongReaction = null;

    public List<SectionSentence> getConversationWrongReaction() {
        return conversationWrongReaction;
    }

    public void setConversationWrongReaction(List<SectionSentence> conversationWrongReaction) {
        this.conversationWrongReaction = conversationWrongReaction;
    }

}
