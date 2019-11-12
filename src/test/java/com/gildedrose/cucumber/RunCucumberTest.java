package com.gildedrose.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

import java.util.logging.Level;

@RunWith(Cucumber.class)
@CucumberOptions(   plugin = {"pretty"},
                    features = "src/test/resources/features"
                )
public class RunCucumberTest {
}

