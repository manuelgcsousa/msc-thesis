package msc.editor;

/**
 * Main class.
 * 
 * @author gcsousa
 */
public class Main
{
    public static void main(String[] args) {
        Facade f = new Facade();
        Editor ed = new Editor(f);
        
        ed.setLocationRelativeTo(null);
        ed.setVisible(true);
    }
}
