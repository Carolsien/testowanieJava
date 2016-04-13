package maven.Stack;
import java.util.Arrays;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;


public class RunJBehave extends JUnitStories{

	public RunJBehave(){
		super();
	}
	@Override
	public Configuration configuration(){
		return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath()).useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE, Format.TXT));
	}
	@Override
	public InjectableStepsFactory stepsFactory(){
		return new InstanceStepsFactory(configuration(), new MySteps());
	}

	@Override
	protected List<String> storyPaths() {
		return Arrays.asList("MyTopStory.story");
	}

}