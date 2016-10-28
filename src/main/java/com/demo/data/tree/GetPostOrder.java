package com.demo.data.tree;

/**
 * @Description: 已知中序遍历和前序遍历，求后序遍历
 *
 * @author Cyrus
 *
 * @time: 2016年9月28日 下午12:05:33
 *
 */
public class GetPostOrder {

	public void getPostOrder(int[] preOrder, int[] inOrder) {
		Node root = initTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
		postOrder(root);
	}

	private Node initTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
		Node root = null;

		return root;
	}

	private void postOrder(Node root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.data);
		}
	}

}
