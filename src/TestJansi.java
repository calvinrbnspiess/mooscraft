import de.on19.mooscraft.utils.StringTools;

import java.util.Arrays;

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

        String text = "Es war einmal eine Welt vor der unseren, beherrscht von Ungeheuern, Zauberern und Zauberinnen und Wasserwesen. Sie alle kämpften mit den unterschiedlichsten Kräften um die Eroberung der Burg. Doch Vorsicht war geboten, denn viele Fallen und Feinde lauerten in den dunkelsten Ecken und den tiefsten Verstecken um sie daran zu hindern. Viel Energie, Kraft und Stärke war gefordert um die Welt zu durchlaufen und mit genügend Kräften ans Ziel zu kommen. Egal ob Hexe, Kriegerin, Magier, Schurke oder Meerjungfraumann, sie alle machten sich auf den Weg zur Burg, denn es kann nur einen Herrscher über die Welt geben.";
        String textNoWhitespace = text.replaceAll("\\s", "");

        System.out.println(text);
        System.out.println(textNoWhitespace);

        System.out.println("--");

        System.out.println(StringTools.wrapToLength(text, 112));
        System.out.println(StringTools.wrapToLength(textNoWhitespace, 112));

        System.out.println("--");

        for(String line : StringTools.wrapToLengthArray(textNoWhitespace, 112)) {
            System.out.println(line);
        }

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



