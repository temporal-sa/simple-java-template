package com.example.workflows;

import com.example.activities.EchoActivities;
import com.example.activities.EchoInput;
import com.example.activities.EchoOutput;
import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.workflow.Async;
import io.temporal.workflow.Promise;
import io.temporal.workflow.Workflow;
import org.slf4j.Logger;

import java.time.Duration;

public class SimpleWorkflowImpl implements SimpleWorkflow {

    public static final Logger logger = Workflow.getLogger(SimpleWorkflowImpl.class);
    ActivityOptions activityOptions = ActivityOptions.newBuilder()
            .setStartToCloseTimeout(Duration.ofSeconds(5))
            .setRetryOptions(RetryOptions.newBuilder()
                    .setInitialInterval(Duration.ofSeconds(1))
                    .setBackoffCoefficient(2)
                    .setMaximumInterval(Duration.ofSeconds(30))
                    .build())
            .build();

    private final EchoActivities activities =
            Workflow.newActivityStub(EchoActivities.class, activityOptions);

    @Override
    public SimpleOutput execute(SimpleInput input) {
        logger.info("Simple workflow started, input = {}", input.toString());

        String result1 = activities.echo1(input.getVal());

        String result2 = activities.echo2(result1);

        String result3 = activities.echo3(result2);

        logger.info("Sleeping for 1 second...");
        Workflow.sleep(Duration.ofSeconds(1));

        EchoInput echoInput = new EchoInput(result3);
        // async example
        Promise<EchoOutput> echoPromise = Async.function(activities::echo4, echoInput);
        EchoOutput echoOutput = echoPromise.get();
        String result4 = echoOutput.getResult();

        // sync example
        // EchoOutput echoOutput = activities.echo4(echoInput);

        return new SimpleOutput(result4);
    }
}
