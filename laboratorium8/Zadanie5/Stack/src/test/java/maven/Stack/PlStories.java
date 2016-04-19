package maven.Stack;



import java.util.Locale;
public class PlStories extends LocalizedStories {
    
    @Override
    protected Locale locale() {
        return new Locale("pol");
    }

    @Override
    protected String storyPattern() {
        return "**/*.historia";
    }

    @Override
    protected Object localizedSteps() {
        return new MySteps();
    }
 
}