package mavenTest.Gra;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.embedder.Embedder;


public class RunJBehave {

	
	private static Embedder embedder = new Embedder();
	private static List<String> storyPaths = Arrays.asList("HeheszkiStory.story", "TititStory.story");
	
	public static void main(String[] args) {
	embedder.candidateSteps().add(new HeheszkiSteps());
	embedder.candidateSteps().add(new TititSteps());
	embedder.runStoriesAsPaths(storyPaths);
	}

}
