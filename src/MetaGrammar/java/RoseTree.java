import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;


public class RoseTree
{
	private String				chosenValue;
	private String				path;		// stores the path until the current RoseTree.
	private boolean				visited;	// checks if a node was already visited.
	private boolean				required;
	private Map<String, String> attributes; // Key -> attribute name :: Value -> attribute value
	private Set<String>			optionValues;
	private List<String>		lexical_part;
	private List<RoseTree>		children;
	
	// stores the path until the current RoseTree. \
	// Key -> optionValue :: Value -> path
	// private Map<String, String> paths;

	/**
	 * Main constructor
	 */
	public RoseTree() {
		this.chosenValue  = "";
		this.path		  = "";
		this.visited	  = false;
		this.required	  = true;
		this.attributes	  = new HashMap<>();
		this.optionValues = new HashSet<>();
		this.lexical_part = new ArrayList<>();
		this.children	  = new ArrayList<>();
		// this.paths = new HashMap<>();
	}
	

	/** 
	 * Getters
	 */
	public String getValue() {
		return this.chosenValue;
	}

	public boolean getRequiredState() {
		return this.required;
	}
		
	public Map<String, String> getAttributes() {
		return this.attributes;
	}

    public Set<String> getOptionValues() {
        return this.optionValues;
    }

	public List<String> getLexicalPart() {
		return this.lexical_part;
	}
	
	public List<RoseTree> getChildren() {
		return this.children;
	}
	
	public boolean getVisitedState() {
		return this.visited;
	}

	public String getPath() {
		return this.path;
		// return this.paths.get(value);
	}

	/**
	 * Setters
	 */
	public void setChosenValue(String value) {
		this.chosenValue = value;
	}

	public void setRequiredState(boolean required) {
		this.required = required;
	}
	
	public void setVisitedState(boolean visited) {
		this.visited = visited;
	}

	public void setPath(String path) {
		this.path = path;	
	}
	

	/**
	 * Class methods
	 */
	public void addValue(String value) {
		this.optionValues.add(value);
	}

	public boolean hasValue(String value) {
		return this.optionValues.contains(value);
	}
	
	public String hasAttribute(String attr_name) {
		return this.attributes.get(attr_name);
	}

	public String toString() {
		return new String(
			"\n* RoseTree *" +
			"\nValue: " + this.chosenValue +
			"\nRequired? " + this.required +
			"\nPath: " + this.path +
			"\nAttributes: " + this.attributes +
			"\nLexical Part: " + this.lexical_part +
			"\nChildren: " + this.children
		);
	}
}
