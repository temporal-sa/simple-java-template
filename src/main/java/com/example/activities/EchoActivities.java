package com.example.activities;

import com.example.model.EchoInput;
import com.example.model.EchoOutput;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface EchoActivities {

    @ActivityMethod
    String echo1(String input);

    @ActivityMethod
    String echo2(String input);

    @ActivityMethod
    String echo3(String input);

    @ActivityMethod
    EchoOutput echo4(EchoInput input);
}
