
// Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
// результат после каждой итерации запишите в лог-файл.

import java.util.Scanner;
import java.io.FileWriter;
import java.util.Arrays;
import java.io.IOException;

public class Task1 {
    public static void main(String[] args) throws IOException {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите размерность массива: \n");
        int len = iScanner.nextInt();
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            System.out.printf("Введите %d элемент массива \n", i + 1);
            array[i] = iScanner.nextInt();
        }
        iScanner.close();
        System.out.printf("Исходный массив имеет вид: %s \n", Arrays.toString(array));
        try {
            int temp;
            FileWriter fw = new FileWriter("log.txt", true);
            boolean isSorted = false;
            fw.write("\n");
            while (!isSorted) {
                fw.write(Arrays.toString(array) + "\n");
                // fw.flush();
                isSorted = true;
                for (int i = 1; i < array.length; i++) {
                    if (array[i] < array[i - 1]) {
                        isSorted = false;
                        temp = array[i - 1];
                        array[i - 1] = array[i];
                        array[i] = temp;

                    }
                }
            }
            fw.write("__________________________________________________________");
            fw.flush();
            System.out.printf("Отсортированный массив имеет вид: %s \n", Arrays.toString(array));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
