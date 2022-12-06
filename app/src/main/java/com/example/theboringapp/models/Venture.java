package com.example.theboringapp.models;

public interface Venture {

    String getName();
    //Description of the queried activity

    double getAccessibility();
    // A factor describing how possible an event is to do with zero being the most accessible [0.0, 1.0]

    String getType();
    // Type of the activity ["education", "recreational", "social", "diy", "charity", "cooking", "relaxation", "music", "busywork"]

    int getParticipants();
    // The number of people that this activity could involve [0, n]

    double getPrice();
    // A factor describing the cost of the event with zero being free [0, 1]

    String getLink();
    // a link to website - I.E learning resource

}
