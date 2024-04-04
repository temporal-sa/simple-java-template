package com.example.activities;

import com.example.model.EchoInput;
import com.example.model.EchoOutput;
import io.temporal.spring.boot.ActivityImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@ActivityImpl(workers = "simple-worker")
public class EchoActivitiesImpl implements EchoActivities {

    private final int number;

    public EchoActivitiesImpl(@Value("${echo.number}") int number) {
        this.number = number;
    }

    // sleep util
    private static void sleep(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String echo1(String input) {
        log.info("Echo1 activity started, input = {}", input);

        sleep(1);

        String result = input;
        return result;
    }

    @Override
    public String echo2(String input) {
        log.info("Echo2 activity started, input = {}", input);

        sleep(1);

        String result = input;
        return result;
    }

    @Override
    public String echo3(String input) {
        log.info("Echo3 activity started, input = {}", input);

        sleep(1);

        String result = input;
        return result;
    }

    @Override
    public EchoOutput echo4(EchoInput input) {
        log.info("Echo4 activity started, input = {}", input.toString());

        sleep(1);

        String result = "";
        for (int i = 0; i < number; i++) {
            result += String.format("%s ", input.getVal());
        }

        return new EchoOutput(result);
    }
}
