package com.example.activities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class EchoActivitiesImpl implements EchoActivities {

    private static final Logger logger = LoggerFactory.getLogger(EchoActivitiesImpl.class);

    private final int number;

    public EchoActivitiesImpl(int number) {
        this.number = number;
    }

    @Override
    public String echo1(String input) {
        logger.info("Echo1 activity started, input = {}", input);

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
        logger.info("Echo2 activity started, input = {}", input);

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
        logger.info("Echo3 activity started, input = {}", input);

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
        logger.info("Echo4 activity started, input = {}", input.toString());

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
