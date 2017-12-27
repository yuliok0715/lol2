import cucumber.api.CucumberOptions;

@CucumberOptions(
        features = "resources"
        ,glue={"steps"}
    )
    public class Runner {

    }
