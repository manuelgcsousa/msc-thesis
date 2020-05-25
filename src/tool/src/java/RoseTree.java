import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class RoseTree
{
	// Main attributes
	private String value;
	private boolean required;
	private Map<String, String> attributes; // Key -> attribute name :: Value -> attributed value
	private List<String> lexical_part;
	private List<RoseTree> children;
	
	// Auxiliar attributes
	private boolean visited; //	checks if a node was already visited.
	private String path; // stores the path until the current RoseTree.
	

	/**
	 * Main constructor
	 */
	public RoseTree(String value) {
		this.value = value;
		this.required = true;
		this.attributes = new HashMap<>();
		this.lexical_part = new ArrayList<>();
		this.children = new ArrayList<>();
	
		this.visited = false;
		this.path = "";
	}
	

	/** 
	 * Getters
	 */
	public String getValue() {
		return this.value;
	}

	public boolean getRequiredState() {
		return this.required;
	}
		
	public Map<String, String> getAttributes() {
		return this.attributes;
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
	}

	/**
	 * Setters
	 */
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
	public String hasAttribute(String attr_name) {
		return this.attributes.get(attr_name);
	}

	public String toString() {
		return new String(
			"\n* RoseTree *" +
			"\nValue: " + this.value +
			"\nRequired? " + this.required +
			"\nPath: " + this.path +
			"\nAttributes: " + this.attributes +
			"\nLexical Part: " + this.lexical_part +
			"\nChildren: " + this.children
		);
	}
}

