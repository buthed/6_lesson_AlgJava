package com.tematihonov;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Task 6.1
        // Приведите пример использования древовидной структуры:
        // Все животные красной книги. Вся книга делится на царства: Животные, бактерии, Растения и т.д. В свою очередь Царство животные делится на: рыбы, птицы, насекомые и т.д.
        // Task 6.2
        // Реализуйте класс узла дерева и базовый шаблон дерева с базовыми методами.
        System.out.println("Task 6.2");
        Tree tree = new Tree();
        // Task 6.3
        // Реализуйте методы поиска и вставки узла в дерево.
        tree.insert(new RedBook("Cat", 1, 2));
        tree.insert(new RedBook("Lion", 2, 4));
        tree.insert(new RedBook("Cat2", 3, 6));
        tree.insert(new RedBook("Lion2", 4, 8));

        // Task 6.4
        // Реализуйте базовые методы обхода дерева и метода дисплей.
        // Реализуйте поиск максимума и минимума.
        tree.max().display();
        tree.min().display();
        tree.displayTree();
        // Task 6.5
        // Реализуйте метод удаления узла и выполните оценку времени базовых методов дерева с помощью System.nanoTime().
        System.out.println();
        System.out.println("Task 6.5");
        long startTime;
        long endTime;
        startTime = System.nanoTime();
        tree.delete(2);
        endTime = System.nanoTime()-startTime;
        System.out.println("Удаление узла заняло: " + endTime);
        // Task 6.6
        // Реализуйте на основе массива из задания 2.1 алгоритм пирамидальной сортировки с реализацией бинарной пирамиды.
        // Выполните оценку алгоритма пирамидальной сортировки с помощью System.nanoTime() и сравните с предыдущими алгоритмами сортировки.
        System.out.println();
        System.out.println("Task 6.6");
        int[] arr;
        arr = new int[1000];
        Random rand = new Random();
        for (int i = 0; i<1000; i++) {
            arr[i] = rand.nextInt(1000);
        }
        System.out.println("Задан массив: " + Arrays.toString(arr));
        HeapSort heap = new HeapSort();
        startTime = System.nanoTime();
        heap.heapSort(arr);
        endTime = System.nanoTime() - startTime;
        System.out.println("Отсортированный массив: "+ Arrays.toString(arr));
        System.out.println("Сортировка заняла: " + endTime);

        // Task 6.7
        // Приведите пример сбалансированного дерева и его применения.
        //Пример сбалансированного дерева:
        //Красно-чёрное дерево;
        //АВЛ-дерево;
        //TreeMap в Java реализован на основе красно-чёрных деревьев.
    }
}
