public class Main {
    public static void main(String[] args) {
        Text text = new Text("Заголовок: Введение в Java");
        text.addParagraph("Первый абзац: Это начало текста.");
        text.addParagraph("Второй абзац: Описание задания.");

        // Дописываем к первому абзацу
        text.appendToParagraph(0, " Дополнение к первому абзацу.");
        // Дописываем к последнему абзацу
        text.appendToLastParagraph(" Дополнение ко второму абзацу.");

        System.out.println("=== Печать заголовка ===");
        text.printTitle();

        System.out.println("\n=== Печать текста ===");
        text.printText();
 
        System.out.println("=== getFullText() ===");
        System.out.println(text.getFullText());

        System.out.println("\n=== toString() (короткое представление объекта) ===");
        System.out.println(text.toString());

        // Демонстрация equals/hashCode
        Text text2 = new Text("Заголовок: Введение в Java");
        text2.addParagraph("Первый абзац: Это начало текста. Дополнение к первому абзацу.");
        text2.addParagraph("Второй абзац: Описание задания. Дополнение ко второму абзацу.");

        System.out.println("\ntext.equals(text2) = " + text.equals(text2));
        System.out.println("text.hashCode() = " + text.hashCode());
        System.out.println("text2.hashCode() = " + text2.hashCode());
    }
}
