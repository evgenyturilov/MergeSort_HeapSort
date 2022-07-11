package sort;

public class HeapSort {
    
    // Функция сортировки
    public void sort(int arr[]) {
        int n = arr.length;  // n - количество элементов в массиве/куче

        // для построение убывающей кучи, воспользуемся формулой i/2 - 1, где i - индекс/уровень дерева
        // 
        for (int i = n/2 - 1; i >= 0; i--) {
        // На каждом этапе цикла выполняем условие построения бинарного дерева
            b_tree(arr, n, i);
        }
        // Сортировка кучи - перемещение максимальных элементов в конец
        for (int i = (n/2 - 1); i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
        // После каждого перемещения выполняем условие построения бинарного дерева
            b_tree(arr, n, 0);
        }
    }
    // Функция упорядочивания бинарного дерева по правилу root > left_child > right_child
    public static void b_tree(int arr[], int n, int i) {
        // Находим наибольший элемент из значений root, left_child, right_child
        int max = i;
        int l_child = 2*i + 1;
        int r_child = 2*i + 2;

        if(l_child < n && arr[l_child] > arr[max]) {
            max = l_child;
        }

        if(r_child < n && arr[r_child] > arr[max]) {
            max = r_child;
        }

        // В случае, если значение в корневом узле меньше, чем в узлах-потомках, то меняем их местами и делаем рекурсивную проверку
        if (max != i) {
            int tmp = arr[i];
            arr[i] = arr[max];
            arr[max] = tmp;

            b_tree(arr, n, max);
        }
    }
    // Функция печати массива
    public static void PrintArr(int arr[]) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {1,4,7,34,5,9,3,22,6,7,4};

        HeapSort hs = new HeapSort();
        hs.sort(arr);
        PrintArr(arr);
    }
}
