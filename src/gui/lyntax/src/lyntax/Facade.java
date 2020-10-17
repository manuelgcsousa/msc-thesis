package lyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Facade class.
 *
 * @author gcsousa
 */
public class Facade
{
    private TextFile rulesFile;
    private TextFile inputFile;
    
    /**
     * Facade constructor.
     */
    public Facade() {
        this.rulesFile = null;
        this.inputFile = null;
    }
    
    public TextFile getRulesFile() {
        return this.rulesFile;
    }
    
    public TextFile getInputFile() {
        return this.inputFile;
    }
    
    public void onNew() {
        System.out.println("onNew");
    }
    
    public boolean onOpen(String fileName, String filePath, char type) {
        List<String> content = new ArrayList<>();
        
        try {
            BufferedReader br = new BufferedReader(
                new FileReader(filePath + fileName)
            );
                        
            String line = null;
            while ((line = br.readLine()) != null) {
                content.add(line);
            }
            
            br.close();
        } catch (IOException e) {
            return false;
        }
        
        switch (type) {
            case 'r':
                this.rulesFile = new TextFile(filePath + fileName, content);
                break;
            case 'i':
                this.inputFile = new TextFile(filePath + fileName, content);
                break;
            default:
                return false;
        }
        
        return true;
    }
    
    public boolean onSave(String content_str, char type) {
        try {
            FileWriter fw = new FileWriter(this.rulesFile.getPath());
            fw.write(content_str);
            fw.close();
        } catch (IOException e) {
            return false;
        }
                    
        String[] lines = content_str.split("\\r?\\n");
        List<String> content = Arrays.asList(lines);

        switch (type) {
            case 'r':
                this.rulesFile.setContent(content);
                break;
            case 'i':
                this.inputFile.setContent(content);
                break;
            default:
                return false;   
        }
        
        return true;
    }
    
    public boolean onSaveAs(String fileName, String filePath, String content_str, char type) {
        try {
            FileWriter fw = new FileWriter(filePath + fileName);
            fw.write(content_str);
            fw.close();
        } catch (IOException e) {
            return false;
        }
        
        String[] lines = content_str.split("\\r?\\n");
        List<String> content = Arrays.asList(lines);
        
        switch (type) {
            case 'r':
                this.rulesFile = new TextFile(filePath + fileName, content);
                break;
            case 'i':
                this.inputFile = new TextFile(filePath + fileName, content);
                break;
            default:
                return false;   
        }
        
        return true;
    }
    
    public String onGen(String rules_str, String input_str) {
        String msg;    
        String meta_lang = rules_str + "\n" + input_str;
        
        try {
            StringBuilder output = Execute.generate(meta_lang); 
           
            if (output.length() == 0) msg = "";
            else {
                String 
                    ANSI_RED = "\u001B[31m", 
                    ANSI_YELLOW = "\u001B[33m", 
                    ANSI_RESET = "\u001B[0m"
                ;
                
                msg = output.toString()
                    .replace(ANSI_RED, "")
                    .replace(ANSI_YELLOW, "")
                    .replace(ANSI_RESET, "")
                ;
            }
        } catch (IOException e) {
            msg = "err";
        }
        
        return msg;
    }
    
    public void onRun() {
        Execute.run();
    }
    
    public void onExit() {
        System.out.println("onExit");
    }
}
