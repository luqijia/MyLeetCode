package integer;

/**
 * 两数相除:不能使用除法和乘法和mod运算
 * 思路：使用位运算，向左移1相当于乘以2，向右位移1相当于除以2。判断是否为负数的方法：1）负数的表示方法（最高位为1，减去其余位）
 * 
 * 我们可以把一个dividend（被除数）先除以2^n，n最初为31，不断减小n去试探,当某个n满足dividend/2^n>=divisor时，
 *
 * 表示我们找到了一个足够大的数，这个数*divisor是不大于dividend的，所以我们就可以减去2^n个divisor，以此类推
 *
 * 我们可以以100/3为例
 *
 * 2^n是1，2，4，8...2^31这种数，当n为31时，这个数特别大，100/2^n是一个很小的数，肯定是小于3的，所以循环下来，
 *
 * 当n=5时，100/32=3, 刚好是大于等于3的，这时我们将100-32*3=4，也就是减去了32个3，接下来我们再处理4，同样手法可以再减去一个3
 *
 * 所以一共是减去了33个3，所以商就是33
 * 
 * @author luqijia
 *
 */
public class Divide {
	public static int divide(int dividend, int divisor) {
		if (dividend == 0) {
			return 0;
		}
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		if (divisor == 1) {
			return dividend;
		}
		if (divisor == -1) {
			return -dividend;
		}
		boolean negative;
		negative = (dividend ^ divisor) < 0;// 用异或来计算是否符号相异
		long t = Math.abs((long)dividend);   //必须转换为long类型。不然当dividend为Integer.MIN_VALUE时，取了绝对值会溢出int类型的最大值
		long d = Math.abs((long)divisor);
		int result = 0;
		for (int i = 31; i >= 0; i--) {
			if ((t >> i) >= d) {// 找出足够大的数2^n*divisor
				result += 1 << i;// 将结果加上2^n
				t -= d << i;// 将被除数减去2^n*divisor
			}
		}
		return negative ? -result : result;// 符号相异取反
	}

	public static void main(String[] args) {
		System.out.println(divide(Integer.MIN_VALUE, 2));
	}
}
