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
		if(preStart > preEnd || inStart > inEnd) {
			return null;
		}
		int rdata = preOrder[preStart];
		Node root = new Node(rdata);
		int pos = findIndex(inOrder, rdata, inStart, inEnd);
		//构建左子树
		Node left = initTree(preOrder,preStart+1,preStart+pos-inStart,inOrder,inStart,pos-1);
		//构建右子树
		Node right = initTree(preOrder,preStart+pos-inStart+1,preEnd,inOrder,pos+1,inEnd);
		root.left = left;
		root.right = right;
		return root;
	}

	private int findIndex(int a[], int data, int start, int end) {
		for(int i = start; i <= end; i++) {
			if(a[i] == data) {
				return i;
			}
		}
		return -1;
	}

	private void postOrder(Node root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.data);
		}
	}
}
