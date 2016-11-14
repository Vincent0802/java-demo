package com.demo.data.tree;

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
//		root = tree.buildBinaryTree(arr);
//		tree.preOrder(root);
        int[] preOrder = {3,5,1,0,6};
        int[] inOrder = {1,5,0,3,6};
        int[] postOrder = {1,0,5,6,3};
//        GetPostOrder post = new GetPostOrder();
//        post.getPostOrder(preOrder, inOrder);
        GetPreOrder pre = new GetPreOrder();
        pre.getPreOrder(inOrder, postOrder);
	}
}
