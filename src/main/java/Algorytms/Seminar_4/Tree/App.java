package Algorytms.Seminar_4.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) {

        /***
         * Необходимо превратить собранное на семинаре дерево поиска в полноценное левостороннее красно-черное дерево.
         * И реализовать в нем метод добавления новых элементов с балансировкой.
         *
         * Красно-черное дерево имеет следующие критерии:
         * • Каждая нода имеет цвет (красный или черный)
         * • Корень дерева всегда черный
         * • Новая нода всегда красная
         * • Красные ноды могут быть только левым ребенком
         * • У краной ноды все дети черного цвета
         *
         * Соответственно, чтобы данные условия выполнялись, после добавления элемента в дерево необходимо произвести балансировку,
         * благодаря которой все критерии выше станут валидными. Для балансировки существует 3 операции – левый малый поворот, правый малый поворот и смена цвета.
         *
         */
        final RedBlackTree redBlackTree = new RedBlackTree();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while (true){
                try {
                    int value = Integer.parseInt(reader.readLine());
                    redBlackTree.add(value);
                    System.out.println("Finish!");
                }catch (Exception ignored){

                }
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
