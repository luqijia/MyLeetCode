package array;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * @author luqijia
 *
 */
public class RemoveElement {
	/**
	 * 方法一：遍历数组，如果当前数字与给定val相等，则把数组后面的元素往前移，把当前等于val的元素放到数组末尾
	 * @param nums
	 * @param val
	 * @return
	 */
	public static int removeElement(int[] nums, int val) {
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			if (val == nums[i]) {
				int j = i;
				for (; j < length-1; j++) {
					nums[j]=nums[j+1];
				}
				nums[j]=val;
				length --;
				i--;   //移动之后会跳过当前元素，因此要减一
			}
		}
		return length;
	}
	
	/**
	 * 方法二：使用两个指针
	 * @param nums
	 * @param val
	 * @return
	 */
	public int removeElement1(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
          if (nums[j] != val) {
              nums[i++] = nums[j];
          }
        }
        return i;
    }
	
	public static void main(String[] args) {
		int[] nums = {0,1,2,2,3,0,4,2};
		System.out.println(removeElement(nums, 2));
	}
}
