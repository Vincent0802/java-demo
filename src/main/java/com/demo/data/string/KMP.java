package com.demo.data.string;

/**
 * @Description: KMP算法
 *
 * @author Vincent
 *
 * @time: 2016年10月17日 上午10:24:20
 *
 */
/*
 * 子串：abaabaca
 * 
 * 将j导入next函数，即可求得，
 * 
 * j=1时，next[0]=0；
 * 
 * j=2时，k的取值为(1,j)的开区间，所以整数k是不存在的，那就是第三种情况，next[2]=1；
 * 
 * j=3时，k的取值为（1，3）的开区间，k从最大的开始取值，然后带入含p的式子中验证等式是否成立，不成立k取第二大的值。现在是k=2，将k导入p的式子中得
 * ，p1=p2，即“a”=“b”，显然不成立，舍去。k再取值就超出范围了，所以next[3]不属于第二种情况，那就是第三种了，即next[3]=1；
 * 
 * j=4时，k的取值为（1，4）的开区间，先取k=3，将k导入p的式子中得，p1p2=p2p3，不成立。
 * 再取k=2，得p1=p3，成立。所以next[4]=2；
 * 
 * j=5时，k的取值为（1，5）的开区间，先取k=4，将k导入p的式子中得，p1p2p3=p2p3p4，不成立。 再取k=2，得p1p2=p3p4，不成立。
 * 再取k=2，得p1=p4，成立。所以next[4]=2；
 */
public class KMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
