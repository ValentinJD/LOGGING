package ru.project;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

@ApplicationPath("/")
public class RestInternalApiConfig extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        return new LinkedHashSet<>(
                Arrays.asList(
                        ReportingPeriodController.class
                ));
    }
}
