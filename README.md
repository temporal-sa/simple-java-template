# simple-java-template

To be used as a template project to bootstrap other projects on
the [Temporal Java SDK](https://github.com/temporalio/sdk-java)

## Run Worker

```bash
./gradlew bootRun

# To run with a specific profile
./gradlew bootRun --args='--spring.profiles.active=tc'
```

## Start Workflow

```bash
temporal workflow start --type SimpleJava --task-queue simple-task-queue --input '{"val":"foo"}'
```
