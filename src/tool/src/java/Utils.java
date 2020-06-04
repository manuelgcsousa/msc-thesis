import java.util.List;
import java.util.Map;


public class Utils
{    
    // Colors to print errors and warnings.
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_YELLOW = "\u001B[33m";
	private static final String ANSI_RESET = "\u001B[0m";
	
	/**
     * Method that prints error/warning messages with custom colors.
     */
	public static void print_msg(int type, String block, String msg) {
		// (type = 0) -> ERROR
	    // (type = 1) -> WARNING

		switch (type) {
			case 0:
				System.out.println(ANSI_RED + "\nERROR: (" + block + ")" + ANSI_RESET);
				System.out.println(msg);
				System.exit(0); // exits program after printing error message.
				break;

			case 1:
				System.out.println(ANSI_YELLOW + "\nWARNING: (" + block + ")" + ANSI_RESET);
				System.out.println(msg);
				break;
		}
	}
    
    
    /**
     * Method...
     */
    public static String convertLogical(List<String> components, String attribute) {
        String logical_condition = "";
        String comp = "";

        for (String c : components)
            logical_condition += (c + "__");
        
        logical_condition += (attribute.toUpperCase());

        return logical_condition;
    }


	/** 
     * Method that verifies the existence of a value within a list of a RoseTree.
     */
	public static RoseTree containsValue(List<RoseTree> children, String value, Boolean visitedState) {
		RoseTree child = null;
		boolean flag = false;

		for (int i = 0; i < children.size() && flag != true; i++) {
			RoseTree tree = children.get(i);
			
			if (!tree.getVisitedState() && tree.getValue().equals(value)) {
				child = tree;
				
				if (visitedState != null)
					tree.setVisitedState(visitedState);
		
				flag = true;
			}
		}

		return child;
	}
	

	/**
     * Method that verifies which components have mandatory declaration.
     */
	public static void getRequiredComponents(List<RoseTree> struct, Map<String, Integer> required_components) {
		for (int i = 0; i < struct.size(); i++) {
			RoseTree parent = struct.get(i);

			if (parent.getRequiredState()) {
				required_components.put(parent.getValue(), 1);

				List<RoseTree> children = parent.getChildren();
				
				// Executes method for all children.
				getRequiredComponents(children, required_components);
			}
		}
	}
} 
