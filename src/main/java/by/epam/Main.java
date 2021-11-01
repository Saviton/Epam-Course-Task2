package by.epam;


import by.epam.additional.MethodsForFile;
import by.epam.task2.Text;

/**
 * Task2
 * Создать программу обработки фрагмента текста учебника по программированию с использованием элементов, например: Символ, Слово,
 * Предложение, Текст, Абзац, Листинг, Лексема, Знак препинания и др.
 * Приложение должно осуществлять разбор текста на элементы с обязательной возможностью восстановления текста в исходном виде.
 * Можно использовать шаблон Composite.
 * Во всех задачах с формированием текста разрешено заменять табуляции и последовательности пробелов одним пробелом.
 * Для демонстрации работы приложения использовать unit тесты.
 * Использовать logging.
 * Использовать библиотеки сборки.
 *
 *
 * 6.	Напечатать слова текста в алфавитном порядке по первой
 * букве. Слова, начинающиеся с новой буквы, печатать с красной строки.
 */

public class Main {


    public static void main(String[] args) {
        String pathFile = "src\\main\\resources\\text1.txt";
        String content = MethodsForFile.parseFile(pathFile);
        Text text = new Text(content);

        System.out.println(text.print());

        System.out.println(text.taskNumber6());

    }
}
