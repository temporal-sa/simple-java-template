package com.example.workflows;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface SimpleWorkflow {

    @WorkflowMethod(name = "SimpleJava")
    SimpleOutput execute(SimpleInput input);
}
