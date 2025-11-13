import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс библиотеки для управления коллекцией книг
 * Рефакторинг: добавлены методы для поиска по году и названию, улучшена структура кода
 */
public class Library {
    private final String libraryName;
    private final List<Book> bookCollection;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.bookCollection = new ArrayList<>();
    }

    public void addBook(Book book) {
        bookCollection.add(book);
        System.out.println("Книга добавлена: " + book.getTitle());
    }

    public List<Book> getBooksByAuthor(String authorName) {
        return bookCollection.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(authorName))
                .collect(Collectors.toList());
    }
    
    /**
     * Рефакторинг: добавлен поиск книг по году издания
     * @param year год для поиска
     * @return список книг указанного года
     */
    public List<Book> getBooksByYear(int year) {
        return bookCollection.stream()
                .filter(book -> book.getPublicationYear() == year)
                .collect(Collectors.toList());
    }
    
    /**
     * Рефакторинг: добавлен поиск книг по названию
     * @param title часть названия для поиска
     * @return список найденных книг
     */
    public List<Book> getBooksByTitle(String title) {
        return bookCollection.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    /**
     * Рефакторинг: добавлено удаление книги по названию и автору
     * @param title название книги
     * @param author автор книги
     * @return true если книга удалена
     */
    public boolean removeBook(String title, String author) {
        boolean removed = bookCollection.removeIf(book -> 
            book.getTitle().equalsIgnoreCase(title) && 
            book.getAuthor().equalsIgnoreCase(author));
        
        if (removed) {
            System.out.println("Книга удалена: " + title);
        }
        return removed;
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(bookCollection);
    }

    public String getLibraryName() { 
        return libraryName; 
    }
    
    public int getBookCount() { 
        return bookCollection.size(); 
    }
    
    /**
     * Рефакторинг: добавлен метод для получения статистики
     * @return строку со статистикой библиотеки
     */
    public String getLibraryStats() {
        long uniqueAuthors = bookCollection.stream()
                .map(Book::getAuthor)
                .distinct()
                .count();
        
        return String.format("Библиотека '%s': книг=%d, уникальных авторов=%d", 
                           libraryName, bookCollection.size(), uniqueAuthors);
    }

    @Override
    public String toString() {
        return "Библиотека: \"" + libraryName + "\", количество книг: " + bookCollection.size();
    }
}