package No88_mergeMidNum;

/**
 * @Description TODO
 * @Author tao.ling
 * @Date 2024/8/29
 **/
public class Main {
    /**
     * @param nums1 数组1
     * @param m     数组1长度
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; ++i)
                nums1[i] = nums2[i];
        } else {
            int currentSize = m;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < (m + n); j++) {
                    System.out.println("processing : " + nums2[i]);
                    if (nums2[i] <= nums1[j]) {
                        insert2Array(nums1, nums2[i], j);
                        currentSize++;
                        break;
                    } else if (j == currentSize - 1) {
                        insert2Array(nums1, nums2[i], j + 1);
                        currentSize++;
                        break;
                    }
                }
            }
        }
    }

    /**
     * @param arr   目标数据
     * @param elem  需要插入的数据
     * @param index 插入的位置
     * @throws IndexOutOfBoundsException 指定位置超过数组最大时抛
     */
    public static void insert2Array(int[] arr, int elem, int index) {
        if (index > arr.length - 1)
            throw new IndexOutOfBoundsException("指定位置超过数组长度");
        int tmp = arr[index];
        arr[index] = elem;
        if (index == arr.length - 1)
            return;
        index += 1;
        for (; index < arr.length; ++index) {
            int tmp2 = tmp;
            tmp = arr[index];
            arr[index] = tmp2;
        }

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};

        merge(nums1, 0, nums2, 1);

        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);

        }
    }
}
