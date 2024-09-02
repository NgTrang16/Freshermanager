package com.example.FresherManager.dto;

import java.util.List;

public class BulkCreateFresherRequest {
    public List<CreateFresherRequest> freshers;

    public BulkCreateFresherRequest() {
    }

    public BulkCreateFresherRequest(List<CreateFresherRequest> freshers) {
        this.freshers = freshers;
    }

    public List<CreateFresherRequest> getFreshers() {
        return freshers;
    }

    public void setFreshers(List<CreateFresherRequest> freshers) {
        this.freshers = freshers;
    }
}
