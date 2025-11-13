/**
 * Демонстрация работы с текстом и репозиторием
 * Рефакторинг: добавлена работа с TextRepository
 */
public class Main {
    public static void main(String[] args) {
        // Создание текстов
        Text text1 = new Text("Заголовок: Введение в Java");
        text1.addParagraph("Первый абзац: Это начало текста.");
        text1.addParagraph("Второй абзац: Описание задания.");
        
        Text text2 = new Text("Заголовок: Продвинутая Java");
        text2.addParagraph("Абзац 1: Изучение коллекций.");
        text2.addParagraph("Абзац 2: Работа с потоками.");

        // Рефакторинг: создание и использование репозитория
        TextRepository repository = new TextRepository();
        
        // Добавление текстов в репозиторий
        repository.addText(text1);
        repository.addText(text2);
        
        System.out.println("\n=== Количество текстов в репозитории: " + repository.getTextCount() + " ===");

        // Демонстрация оригинальной функциональности
        text1.appendToParagraph(0, " Дополнение к первому абзацу.");
        text1.appendToLastParagraph(" Дополнение ко второму абзацу.");

        System.out.println("\n=== Печать заголовка ===");
        text1.printTitle();

        System.out.println("\n=== Печать текста ===");
        text1.printText();
        
        System.out.println("\n=== Поиск текстов по заголовку ===");
        List<Text> foundTexts = repository.findTextsByTitle("Java");
        for (Text text : foundTexts) {
            System.out.println("Найден: " + text.getTitle());
        }

        // Демонстрация методов репозитория
        System.out.println("\n=== Обновление текста в репозитории ===");
        Text updatedText = new Text("Заголовок: Обновленное введение в Java");
        updatedText.addParagraph("Новый абзац: Обновленное содержание.");
        repository.updateText(0, updatedText);

        System.out.println("\n=== Все тексты в репозитории ===");
        for (Text text : repository.getAllTexts()) {
            System.out.println(text.getTitle());
        }
        
        System.out.println("\n=== Удаление текста ===");
        repository.removeText(1);
        System.out.println("Количество текстов после удаления: " + repository.getTextCount());
    }
}