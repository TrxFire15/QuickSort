import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.Scanner;

class QuickSort {

public static Scanner sc = new Scanner(System.in);

int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<high; j++) {
                if (arr[j] < pivot) {
                        i++;
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
}
void sort(int arr[], int low, int high){
        if (low < high) {
                int pi = partition(arr, low, high);
                sort(arr, low, pi-1);
                sort(arr, pi+1, high);
        }
}

static void printArray(int arr[]){
        System.out.println("Ordered by quicksort : ");
        Arrays.stream(arr).forEach(System.out::println);
}

public static int[] fill(){
        System.out.println("Enter the number of numbers to enter: ");
        int [] array = new int [sc.nextInt()];
        System.out.println("Enter the numbers: ");
        array = IntStream.range(0, array.length).map(i -> sc.nextInt()).toArray();
        return array;
}
public static void main(String args[]){
        int arr[] = fill();
        QuickSort qs = new QuickSort();
        qs.sort(arr, 0, arr.length -1);

        printArray(arr);
}
}
