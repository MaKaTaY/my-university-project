import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Класс для работы с текстом
 * Рефакторинг: добавлен геттер для заголовка для совместимости с репозиторием
 */
public class Text {
    private String title;
    private List<String> paragraphs;
    
    public Text(String title) {
        this.title = title;
        this.paragraphs = new ArrayList<>();
    }
    
    public void addParagraph(String paragraph) {
        paragraphs.add(paragraph);
    }
    
    public void appendToParagraph(int index, String text) {
        if (index >= 0 && index < paragraphs.size()) {
            paragraphs.set(index, paragraphs.get(index) + text);
        }
    }
    
    public void appendToLastParagraph(String text) {
        if (!paragraphs.isEmpty()) {
            int lastIndex = paragraphs.size() - 1;
            paragraphs.set(lastIndex, paragraphs.get(lastIndex) + text);
        }
    }
    
    public void printTitle() {
        System.out.println("Заголовок: " + title);
    }
    
    public void printText() {
        for (int i = 0; i < paragraphs.size(); i++) {
            System.out.println((i + 1) + ". " + paragraphs.get(i));
        }
    }
    
    public String getFullText() {
        StringBuilder fullText = new StringBuilder(title + "\n");
        for (String paragraph : paragraphs) {
            fullText.append(paragraph).append("\n");
        }
        return fullText.toString();
    }
    
    /**
     * Рефакторинг: добавлен геттер для заголовка
     * Необходим для работы TextRepository
     */
    public String getTitle() {
        return title;
    }
    
    @Override
    public String toString() {
        return "Text{title='" + title + "', paragraphs=" + paragraphs.size() + "}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text = (Text) o;
        return Objects.equals(title, text.title) && 
               Objects.equals(paragraphs, text.paragraphs);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(title, paragraphs);
    }
}