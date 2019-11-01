
import org.fusesource.jansi.AnsiConsole;
public class TestJansi{
    public static final String WORLDONE = "\u001b[95";
    public static final String WORLDTWO = "\u001b[92";
    public static final String WORLDTHREE = "\u001b[91";
    public static final String WORLDFOUR = "\u001b[96";


    public static void main(String[] args){
        AnsiConsole.systemInstall();
        System.out.println(WORLDONE + " Willkommen im Odenwald");
        System.out.println(WORLDTWO + " Willkommen in Mittelklinge");
        System.out.println(WORLDTHREE + " Willkommen am Hexenturm Turismaga");
        System.out.println(WORLDFOUR + " Willkommen am Hexenturm Arcis Borbetomagus");
    }
}
/**Source for above Code
 * https://stackoverflow.com/questions/56140910/setting-up-a-classpath-for-jansi
 *
 * Color table for ANSI Escape Codes
 * https://en.wikipedia.org/wiki/ANSI_escape_code
 */



