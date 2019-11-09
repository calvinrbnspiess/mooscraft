# mooscraft
Es war einmal eine Welt vor der unseren, beherrscht von Ungeheuern, Zauberern und Zauberinnen und Wasserwesen. Sie alle kämpften mit den unterschiedlichsten Kräften um die Eroberung der Burg.
***

Projekt im Studiengang Onlinemedien (ON19), DHBW Mosbach - Alischa Thomas, Calvin Reibenspieß, Julia Henschel, Larissa Eirich

#### Hier findet ab jetzt die Aufgabenverteilung statt: 
https://github.com/calvinrbnspiess/mooscraft/projects/1

#### Link zu unserer Google Docs:
https://docs.google.com/document/d/1lFSnBUEKzq0onimjHwcxg2O8msLgrVsvE1CTEcN2SmM/edit#heading=h.ovag3lmn41e6

#### Link zu den Java-Projekten:
https://docs.google.com/document/d/1--6y3bYb3GTwR0ndTWS87F57AsPkYFDW8XnqojA792I/edit#

Auf Eingaben warten:

```java
        handler.waitForAction(new GameAction() {
            @Override
            public boolean isInvoked(String[] args) {
                return args[0].equals("weiter");
            }
        });
```

Eine neue Bildschirmseite anzeigen:

```java
        Screen screen = new Screen();
        screen.append(new String[]{
                "Zeile 1",
                "Zweite Zeile",
                "..."
        });
        renderer.printScreen(screen);
```
## Klassentypen
Standard: class
implementierende Funktion
```java
public class Spielbrett implements SpielbrettAnleitung {

}
```
abstract: Klasse ist unfertig + kann nicht aufgerufen werden
```java
public abstract class Spielbrett {

}
```
interface: Hülle für andere Klassen; Aufbauanleitung; kann keine Objekte erstellen
```java
public interface SpielbrettAnleitung {

    public spielen();

}
```
