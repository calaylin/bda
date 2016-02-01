import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
 
// Taken from http://whyjava.wordpress.com/2010/05/04/finding-all-the-indexes-of-a-whole-word-in-a-given-string-using-java/
public class WholeWordIndexFinder {
 
    private String searchString;
 
    public WholeWordIndexFinder(String searchString) {
        this.searchString = searchString;
    }
 
    public List<IndexWrapper> findIndexesForKeyword(String keyword) {
        String regex = "\\b"+keyword+"\\b";
        Pattern pattern;
        Matcher matcher = null;

        try {        
            pattern = Pattern.compile(regex);        
        //	System.out.println("Pattern created: "+pattern.pattern());
            matcher = pattern.matcher(searchString);
        } 
        
        catch (PatternSyntaxException ex) {
        	System.out.println("This string does not compile: "+ex.getPattern());
        	System.out.println(ex.getMessage());
             regex = "\\"+keyword;
        	 pattern = Pattern.compile(regex);        
           	System.out.println("Pattern created in catch: "+pattern.pattern());
             matcher = pattern.matcher(searchString);
        	        }

        List<IndexWrapper> wrappers = new ArrayList<IndexWrapper>();
 
        while(matcher.find() == true){
            int end = matcher.end();
            int start = matcher.start();
            IndexWrapper wrapper = new IndexWrapper(start, end);
            wrappers.add(wrapper);
        }
        return wrappers;
    }
 
    public static void main(String[] args) {
        WholeWordIndexFinder finder = new WholeWordIndexFinder(
        		"2	(FunctionDef(((CompoundStatement((ForStatement((ForInit((IdentifierDeclStatement(IdentifierDecl)))))((Condition((RelationalExpression(x)(10)))))((IncDecOp((x))((++))))");
        List<IndexWrapper> indexes = finder.findIndexesForKeyword("Condition");
        System.out.println("Indexes found "+indexes.size() +" keyword found at index : " +indexes.get(0).getStart());
        
        //input should be the dep file, do this for each line
        //take the last line that a function id appears in that has the whole depth structure
        String input = "1111 t	(flag)";
        //take the function id in the beginning of the line.    
        String firstWord = input.substring(0, input.indexOf('\t'));
        System.out.println(firstWord);

    }
 
}