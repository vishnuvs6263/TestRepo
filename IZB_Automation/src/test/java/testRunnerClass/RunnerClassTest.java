package testRunnerClass;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features="src/test/java/feature",
		glue= {"step_Definitions"}


		)
public class RunnerClassTest {


}
