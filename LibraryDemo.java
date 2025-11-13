import java.util.ArrayList;
import java.util.List;

class Book {
    private final String title;
    private final String author;
    private final int publicationYear;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPublicationYear() { return publicationYear; }

    @Override
    public String toString() {
        return "Книга: \"" + title + "\", автор: " + author + ", год: " + publicationYear;
    }
}

class Library {
    private final String libraryName;
    private final List<Book> bookCollection;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.bookCollection = new ArrayList<>();
    }

    public void addBook(Book book) {
        bookCollection.add(book);
    }

    public List<Book> getBooksByAuthor(String authorName) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookCollection) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(bookCollection);
    }

    public String getLibraryName() { return libraryName; }
    public int getBookCount() { return bookCollection.size(); }

    @Override
    public String toString() {
        return "Библиотека: \"" + libraryName + "\", количество книг: " + bookCollection.size();
    }
}

/**
 * Демонстрация работы библиотечной системы
 * Рефакторинг: добавлена демонстрация новых функций
 */
public class LibraryDemo {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦИЯ БИБЛИОТЕЧНОЙ СИСТЕМЫ ===\n");
        
        // Создание библиотек
        Library centralLibrary = new Library("Центральная библиотека");
        Library scienceLibrary = new Library("Научная библиотека");
        
        // Добавление книг
        centralLibrary.addBook(new Book("Преступление и наказание", "Фёдор Достоевский", 1866));
        centralLibrary.addBook(new Book("Война и мир", "Лев Толстой", 1869));
        centralLibrary.addBook(new Book("Идиот", "Фёдор Достоевский", 1869));
        
        scienceLibrary.addBook(new Book("Философия Java", "Брюс Эккель", 2006));
        scienceLibrary.addBook(new Book("Совершенный код", "Стив Макконнелл", 2004));
        scienceLibrary.addBook(new Book("Java. Эффективное программирование", "Джошуа Блох", 2001));
        
        // Рефакторинг: демонстрация новых функций
        System.out.println("\n=== НОВЫЕ ФУНКЦИИ (рефакторинг) ===");
        
        // Статистика библиотек
        System.out.println(centralLibrary.getLibraryStats());
        System.out.println(scienceLibrary.getLibraryStats());
        
        // Поиск по году
        System.out.println("\nКниги 1869 года в центральной библиотеке:");
        centralLibrary.getBooksByYear(1869).forEach(book -> 
            System.out.println("  - " + book.getTitle()));
        
        // Поиск по названию
        System.out.println("\nКниги о Java в научной библиотеке:");
        scienceLibrary.getBooksByTitle("Java").forEach(book -> 
            System.out.println("  - " + book));
        
        // Удаление книги
        System.out.println("\nУдаление книги 'Война и мир':");
        centralLibrary.removeBook("Война и мир", "Лев Толстой");
        System.out.println("Книг после удаления: " + centralLibrary.getBookCount());
        
        // Вывод оригинальной информации
        System.out.println("\n" + centralLibrary);
        System.out.println("Книги Достоевского:");
        centralLibrary.getBooksByAuthor("Фёдор Достоевский").forEach(book -> 
            System.out.println("  - " + book.getTitle() + " (" + book.getPublicationYear() + ")"));
    }
}