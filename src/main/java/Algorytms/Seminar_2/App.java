package Algorytms.Seminar_2;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] testArray = new int[]{2, 5, 3, 2, 7, 23, 52, 33, 345, 234,23, 235, 5, 45};
        System.out.println(Arrays.toString(testArray));

        SortMethods.HeapSort(testArray);
        System.out.println(Arrays.toString(testArray));
    }

    static class SortMethods {

        // Реализовать алгоритм пирамидальной сортировки (сортировка кучей).
            private static void Heapify(int[] array, int heapSize, int rootIndex){
                int largest = rootIndex;
                int leftChild = 2 * rootIndex + 1;
                int rightChild = 2 * rootIndex + 2;

                if (leftChild < heapSize && array[leftChild] > array[largest]) largest = leftChild;
                if (rightChild < heapSize && array[rightChild] > array[largest]) largest = rightChild;

                if(largest != rootIndex){
                    int temp = array[rootIndex];
                    array[rootIndex] = array[largest];
                    array[largest] = temp;
                }

                Heapify(array, heapSize, largest);
            }

            public static void HeapSort(int[] array){
                for (int i = array.length/2 - 1; i >= 0; i--) {
                    Heapify(array, array.length, i);
                }

                for (int i = array.length - 1; i >= 0; i--) {
                    int temp = array[0];
                    array[0] = array[i];
                    array[i] = temp;

                    Heapify(array, i, 0);
                }
            }
        }
    }

