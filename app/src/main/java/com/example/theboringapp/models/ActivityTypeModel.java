package com.example.theboringapp.models;

public class ActivityTypeModel {

    private String activityTypeName;
    private int activityTypeImage;

    public ActivityTypeModel(String activityTypeName, int activityTypeImage) {
        this.activityTypeName = activityTypeName;
        this.activityTypeImage = activityTypeImage;
    }

    public String getActivityTypeName() {
        return activityTypeName;
    }

    public void setActivityTypeName(String activityTypeName) {
        this.activityTypeName = activityTypeName;
    }

    public int getActivityTypeImage() {
        return activityTypeImage;
    }

    public void setActivityTypeImage(int activityTypeImage) {
        this.activityTypeImage = activityTypeImage;
    }
}
