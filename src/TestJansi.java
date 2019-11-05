/**
 *  colors for worlds
 *
 *  public static final String WORLDONE = "\u001b[1;95m";
 public static final String WORLDTWO = "\u001b[1;92m";
 public static final String WORLDTHREE = "\u001b[1;91m";
 public static final String WORLDFOUR = "\u001b[1;96m";
 color table:
 https://en.wikipedia.org/wiki/ANSI_escape_code
 Table about 3/4bit; use FG Code
 *
 */
public class TestJansi {

    public static void main(String[] args) {
        //color all following text
        System.out.println("\u001b[1;92m Willkommen im Odenwald.");
        System.out.println("Hello Magalia");
        System.out.println("Hello Rogue");
        System.out.println("Hello White Mage");

        //just color a text snippet
        System.out.println("\u001b[1;92m Willkommen im Odenwald.\u001b[0m");
        System.out.println("Hello Magalia");
        System.out.println("Hello Rogue");
        System.out.println("Hello White Mage");

        //wold welcoming phrase
        System.out.println("\u001b[1;95m Willkommen im Odenwald.");
        System.out.println("\u001b[1;92m Willkommen in Mittelklinge.");
        System.out.println("\u001b[1;91m Willkommen am Hexenturm Turismaga.");
        System.out.println("\u001b[1;96m Willkommen in Arcis Barbetomagus.");


    }

}
/**Source for above Code
 * https://stackoverflow.com/questions/56140910/setting-up-a-classpath-for-jansi
 *
 * Color table for ANSI Escape Codes
 * https://en.wikipedia.org/wiki/ANSI_escape_code
 */



