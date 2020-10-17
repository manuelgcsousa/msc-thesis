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
     * There are two types of messages:
     * - (type = 0) = ERROR
     * - (type = 1) = WARNING
     * In case of an error, the program exits.
     *
     * @param type type of message (0 or 1)
     * @param block which block does the message come
     * @param msg the message itself
     */
	public static void print_msg(int type, String block, String msg) {
		switch (type) {
			case 0:
				System.err.println(ANSI_RED + "ERROR: (" + block + ")" + ANSI_RESET + " " + msg);
				// System.err.println(msg);
				System.exit(0); // exit program after printing error message.
				break;

			case 1:
				System.err.println(ANSI_YELLOW + "WARNING: (" + block + ")" + ANSI_RESET + " " + msg);
				// System.err.println(msg);
				break;
		}
	}
    
    
    /**
     * convertLogical.
     *
     * @param components
     * @param attribute
     * @return the converted condition
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
     * Method that verifies the existence of a value within a list of RoseTree's.
     * If the value does not exist, a null pointer is returned, otherwise the object
     * corresponding to the component is returned.
     * Regarding the visitedState variable, is this variable is null, it means that the method
     * is only being used to check if a value exists. On the other and, if the value is 'true',
     * it ensured that said RoseTree has been visited.
     *
     * @param children a list of RoseTree's
     * @param value the value (String) of a component
     * @param visitedState to check that a certain component has been visited
     * @return the correspondent RoseTree
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
     * For every RoseTree within the structure, it is verified which components
     * have a mandatory declaration. Each component is then stored within an auxiliar
     * Map that checks if the component has been declared or not.
     *
     * @param struct the main structure (as a form of a list of RoseTree's)
     * @param required_components a Map containing every required component 
     */
	/*
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
    */

    public static void getRequiredComponents(RoseTree parent, Map<String, Integer> required_components) {
        if (parent.getRequiredState()) {
            Integer occur = required_components.get(parent.getValue());
            if (occur != null)
                required_components.put(parent.getValue(), ++occur);
            else
                required_components.put(parent.getValue(), 1);
            
            for (RoseTree child : parent.getChildren()) {
                getRequiredComponents(child, required_components);
            }
        }
	}
} 
