/*Given a sorted array of consecutive elements.
The array has only one element repeated many times. The task is to find length of the sequence of repeated element.
number of times repeated = size-(arr[rightmost]-arr[leftmost])
*/
package Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountOnlyRepeated {
    public static void countRepeated(long[] arr, int n) {
        long repeatNum = n - (arr[n - 1] - arr[0]);
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid != 0 && mid != n - 1 && (arr[mid - 1] == arr[mid] || arr[mid + 1] == arr[mid])
                    || (mid == 0 && arr[mid + 1] == arr[mid])
                    || (mid == n - 1 && arr[mid - 1] == arr[mid])
            ) {
                System.out.println(arr[mid] + " " + repeatNum);
                break;
            }
            long leftCount = (mid-l+1)-(arr[mid]-arr[l]);
//            long rightCount = (r-mid+1)-(arr[r]=arr[mid]);
            boolean goLeft = leftCount!=1;
            if (goLeft) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] arr = new long[n];
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(input[i]);
            }

            countRepeated(arr, arr.length);
        }
    }
}



