
public class KMP {
	// 返回值是子串在str1中的起始下标
	public static int findSubStr(String str1, String str2) {
		if (str1 == null || str2 == null || str1.length() < str2.length()) {
			return -1;
		}

		return process(str1.toCharArray(), str2.toCharArray());
	}

	public static int process(char[] str1, char[] str2) {
		// i1是str1的匹配指针，i2是str2的匹配指针
		int i1 = 0;
		int i2 = 0;

		// 获取str2所有字符的最长前缀和后缀
		int[] next = getMaximalPrefixAndSuffix(str2);

		// 匹配过程只要i1越界或者i2越界匹配都会终止（i1和i2也可能同时越界）
		while (i1 < str1.length && i2 < str2.length) {
			// KMP加速过程中只有三种情况
			if (str1[i1] == str2[i2]) {
				// 对应位置一样，str1和str2并行向后继续匹配
				i1 ++;
				i2 ++; // 只有匹配字符相等时i2才会往后走
			} else if (i2 == 0) { // next[i2] == -1
				// 对应位置不一样，但是str2的匹配指针在0位置，说明i2跳到0位置了，意味着str1前面一整段没有位置能和str2匹配成功
				// str1匹配指针向后移一位开始下一段与str2的匹配
				i1 ++;
			} else {
				// 对应位置不一样，且str2的匹配指针不在0位置，此时i2需要跳到最长前缀的下一位，进行下一次比较
				// i2跳的这个过程就是KMP常数加速的操作
				i2 = next[i2];
			}
		}

		// 如果i2越界，那么说明str1中匹配成功了str2，那么就返回str1中子串的首位
		// 如果i1越界，那么说明str1中没有任何一位能够与str2匹配成功，返回-1
		return i2 == str2.length ? i1 - i2 : -1;
	}

	// 统计最大前后缀的本质就是确定str2每一位的最大前缀，预估的最大前缀在没有匹配成功时每一轮都会缩小，直到收缩到0，则表示该位置没有最大前缀
	public static int[] getMaximalPrefixAndSuffix(char[] str2) {
		// 如果str2中只有一个字符，那么一定是next[0]
		if (str2.length == 1) {
			return new int[] {-1};
		}

		// 如果不止一个字符，那么手动给next[0]和next[1]赋值
		int[] next = new int[str2.length];
		next[0] = -1;
		next[1] = 0;

		// str2的游标，从str2[2]后开始给next填值
		int i = 2;

		// prefix是c[i]目前最有可能的最长前缀的后一位的下标
		int prefix = 0;

		// 当i越界时表示next已经全部填满
		while (i < str2.length) {
			if (str2[i - 1] == str2[prefix]) {
				// str2[i]的前一位和str2[i]当前最有可能的最长前缀的后一位的下标相同，说明最长前缀还能延长，需要包含str2[prefix]
				// 同时当前第i位匹配成功
				next[i ++] = ++ prefix;
			} else if (prefix > 0) {
				// 如果str2[i]的前一位和str2[i]当前最有可能的最长前缀的后一位的下标不相同，说明最长前缀必须缩小，prefix需要向前跳
				// prefix需要跳到c[prefix]最长前缀的后一位
				// 当前第i位匹配失败，下一轮继续匹配第i位
				prefix = next[prefix];
			} else {
				// 当prefix跳到第0位时，还和第i位匹配不上，说明str2[i]没有最长前缀，置为0
				// 同时当前第i位匹配成功
				next[i ++] = 0;
			}
		}

		return next;
	}
}
