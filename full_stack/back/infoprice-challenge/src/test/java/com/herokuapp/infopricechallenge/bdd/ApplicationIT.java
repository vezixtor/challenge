package com.herokuapp.infopricechallenge.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    glue = {"com.herokuapp.infopricechallenge.bdd.step", "com.herokuapp.infopricechallenge.bdd.step.common"},
    features = "src/test/resources/feature"
)
public class ApplicationIT {
}