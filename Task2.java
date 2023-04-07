// Дана строка (получение через обычный текстовый файл!!!)

// "фамилия":"Иванов","оценка":"5","предмет":"Математика"
// "фамилия":"Петрова","оценка":"4","предмет":"Информатика"

// Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
// Студент [фамилия] получил [оценка] по предмету [предмет].

// Пример вывода в консоль:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        // File file = new File("journal.txt");
        String[] journal;
        StringBuilder sb = new StringBuilder();

        try {

            Scanner scanner = new Scanner(new File("journal.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                journal = line.replace("\"", "").split(",|:");
                sb.append("Студент ");
                sb.append(journal[1]);
                sb.append(" получил ");
                sb.append(journal[3]);
                sb.append(" по предмету ");
                sb.append(journal[5]).append(".\n");
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
