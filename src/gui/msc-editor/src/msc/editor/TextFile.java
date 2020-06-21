package msc.editor;

import java.util.List;

/**
 * TextFile class.
 * 
 * @author gcsousa
 */
public class TextFile
{
    private String path;
    private List<String> content;
    
    public TextFile(String path, List<String> content) {
        this.path = path;
        this.content = content;
    }
    
    public String getPath() {
        return this.path;
    }
    
    public List<String> getContent() {
        return this.content;
    }
    
    public void setPath(String path) {
        this.path = path;
    }
    
    public void setContent(List<String> content) {
        this.content = content;
    }
}
