package lyntax;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Execute class.
 * 
 * { Linux }
 * - Run a shell command:
 *      Process process = Runtime.getRuntime().exec("ls /home/mkyong/");
 * 
 * - Run a shell script:
 *      Process process = Runtime.getRuntime().exec("path/to/hello.sh");
 * 
 * { Windows }
 * - Run a command:
 *      Process process = Runtime.getRuntime().exec("cmd /c dir C:\\Users\\mkyong");
 * 
 * - Run a bat file:
 *      Process process = Runtime.getRuntime().exec("cmd /c hello.bat", null, new File("C:\\Users\\mkyong\\"));
 * 
 * @author gcsousa
 */
public class Execute 
{
    public Execute() { }
    
    public static StringBuilder generate(String meta_lang) throws IOException {
        String _OS = System.getProperty("os.name").toLowerCase();
        String cmd = 
            _OS.contains("windows") ? "cmd /c .\\Resources\\exec.bat -g" : "./Resources/exec.sh -g"
        ;
        System.out.println(cmd); // DEBUG
        System.out.println(System.getProperty("user.dir")); // DEBUG
        
        FileWriter fw = new FileWriter(
            System.getProperty("user.dir") + 
            "/Resources/target/meta-lang"
        );
        fw.write(meta_lang);
        fw.close();

        Process process = Runtime
            .getRuntime()
            .exec(cmd);

        StringBuilder output = new StringBuilder();
        String outErr;

        BufferedReader stdError = new BufferedReader(
            new InputStreamReader(process.getErrorStream())
        );

        while ((outErr = stdError.readLine()) != null) {
            output.append(outErr).append("\n\n");
        }
        
        stdError.close();
        
        return output;
    }
    
    public static StringBuilder run() throws IOException {
        String _OS = System.getProperty("os.name").toLowerCase();
        String cmd = 
            _OS.contains("windows") ? ".\\Resources\\exec.bat -r" : "./Resources/exec.sh -r"
        ;
        System.out.println(cmd); // DEBUG

        Process process = Runtime
            .getRuntime()
            .exec(cmd);

        StringBuilder output = new StringBuilder();
        String outErr;

        BufferedReader stdError = new BufferedReader(
            new InputStreamReader(process.getErrorStream())
        );

        while ((outErr = stdError.readLine()) != null) {
            output.append(outErr).append("\n\n");
        }

        stdError.close();
        
        return output;
    }
}
