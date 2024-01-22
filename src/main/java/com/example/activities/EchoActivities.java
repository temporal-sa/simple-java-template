package com.example.activities;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface EchoActivities {

    @ActivityMethod
    public String echo1(String input);

    @ActivityMethod
    public String echo2(String input);

    @ActivityMethod
    public String echo3(String input);

    @ActivityMethod
    public EchoOutput echo4(EchoInput input);
}
