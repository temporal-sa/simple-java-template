package com.example.activities;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

@Slf4j
public class EchoActivitiesImpl implements EchoActivities {

    private final int number;

    public EchoActivitiesImpl(int number) {
        this.number = number;
    }

    @Override
    public String echo1(String input) {
        log.info("Echo1 activity started, input = {}", input);

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String result = input;
        return result;
    }

    @Override
    public String echo2(String input) {
        log.info("Echo2 activity started, input = {}", input);

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String result = input;
        return result;
    }

    @Override
    public String echo3(String input) {
        log.info("Echo3 activity started, input = {}", input);

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String result = input;
        return result;
    }

    @Override
    public EchoOutput echo4(EchoInput input) {
        log.info("Echo4 activity started, input = {}", input.toString());

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String result = "";
        for (int i = 0; i < number; i++) {
            result += String.format("%s ", input.getVal());
        }

        return new EchoOutput(result);
    }
}
