package com.demo.data.tree;

import com.demo.data.tree.BinaryTree;
import com.demo.data.tree.Node;

/**
 * @Description: Tree主函数入口
 *
 * @author Cyrus
 *
 * @time: 2016年9月27日 下午5:10:00
 *
 */
public class TreeMainApp {

	public static void main(String[] args) {
//		OutToFile.out();
		int arr[] = { 3, 5, 6, 1, 0 };
		BinaryTree tree = new BinaryTree();
		Node root = null;
		root = tree.buildBinaryTree(arr);
		tree.preOrder(root);
		System.out.print("))");
	}
}
