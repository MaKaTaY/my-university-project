import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс-репозиторий для управления коллекцией текстовых объектов
 * Рефакторинг: добавлен для расширения функциональности иерархии Text
 */
public class TextRepository {
    private List<Text> textCollection;
    
    public TextRepository() {
        this.textCollection = new ArrayList<>();
    }
    
    /**
     * Добавление текста в коллекцию
     * @param text объект Text для добавления
     */
    public void addText(Text text) {
        if (text != null) {
            textCollection.add(text);
            System.out.println("Текст добавлен в репозиторий: " + text.getTitle());
        }
    }
    
    /**
     * Удаление текста из коллекции по индексу
     * @param index индекс удаляемого текста
     * @return true если удаление успешно, false если индекс неверный
     */
    public boolean removeText(int index) {
        if (index >= 0 && index < textCollection.size()) {
            Text removed = textCollection.remove(index);
            System.out.println("Текст удален: " + removed.getTitle());
            return true;
        }
        return false;
    }
    
    /**
     * Удаление текста по объекту
     * @param text объект для удаления
     * @return true если удаление успешно
     */
    public boolean removeText(Text text) {
        boolean removed = textCollection.remove(text);
        if (removed) {
            System.out.println("Текст удален: " + text.getTitle());
        }
        return removed;
    }
    
    /**
     * Обновление текста в коллекции
     * @param index индекс обновляемого текста
     * @param newText новый текст
     * @return true если обновление успешно
     */
    public boolean updateText(int index, Text newText) {
        if (index >= 0 && index < textCollection.size() && newText != null) {
            textCollection.set(index, newText);
            System.out.println("Текст обновлен: " + newText.getTitle());
            return true;
        }
        return false;
    }
    
    /**
     * Получение всех текстов
     * @return список всех текстов
     */
    public List<Text> getAllTexts() {
        return new ArrayList<>(textCollection);
    }
    
    /**
     * Поиск текстов по заголовку
     * @param title заголовок для поиска
     * @return список найденных текстов
     */
    public List<Text> findTextsByTitle(String title) {
        return textCollection.stream()
                .filter(text -> text.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    /**
     * Получение количества текстов в репозитории
     * @return количество текстов
     */
    public int getTextCount() {
        return textCollection.size();
    }
    
    /**
     * Очистка репозитория
     */
    public void clear() {
        textCollection.clear();
        System.out.println("Репозиторий очищен");
    }
    
    @Override
    public String toString() {
        return "TextRepository{textCount=" + textCollection.size() + "}";
    }
}