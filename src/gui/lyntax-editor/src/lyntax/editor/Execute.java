package lyntax.editor;

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
    
    public static StringBuilder[] generate(String meta_lang) throws IOException {
        String _OS = System.getProperty("os.name").toLowerCase();
        String cmd = 
            _OS.contains("windows") ? "cmd /c \\Resources\\exec.bat -g" : "./Resources/exec.sh -g"
        ;
        System.out.println(cmd); // DEBUG
        
        FileWriter fw = new FileWriter(
            System.getProperty("user.dir") + 
            "/Resources/target/meta-lang"
        );
        fw.write(meta_lang);
        fw.close();

        Process process = Runtime
            .getRuntime()
            .exec(cmd);

        StringBuilder[] output = {
            new StringBuilder(0), // input
            new StringBuilder(1)  // error
        };
        String outputIn, outputErr;

        BufferedReader stdInput = new BufferedReader(
            new InputStreamReader(process.getInputStream())
        );

        BufferedReader stdError = new BufferedReader(
            new InputStreamReader(process.getErrorStream())
        );

        while ((outputIn = stdInput.readLine()) != null) {
            output[0].append(outputIn).append("\n");
        }

        while ((outputErr = stdError.readLine()) != null) {
            output[1].append(outputErr).append("\n");
        }

        stdInput.close();
        stdError.close();
        
        return output;
    }
    
    public static void run() {
        try {
            String _OS = System.getProperty("os.name").toLowerCase();
            String cmd = 
                _OS.contains("windows") ? ".\\Resources\\exec.bat -r" : "./Resources/exec.sh -r"
            ;
            System.out.println(cmd); // DEBUG
            
            Process process = Runtime
                .getRuntime()
                .exec(cmd);
           
            String output = null;
            
            BufferedReader stdInput = new BufferedReader(
                new InputStreamReader(process.getInputStream())
            );
            
            BufferedReader stdError = new BufferedReader(
                new InputStreamReader(process.getErrorStream())
            );
            
            while ((output = stdInput.readLine()) != null) {
                System.out.println(output);
            }
            
            while ((output = stdError.readLine()) != null) {
                System.out.println(output);
            }
            
            stdInput.close();
            stdError.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
