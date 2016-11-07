package com.demo.data.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 二叉树的基本遍历与实现
 *
 * @author Cyrus
 *
 * @time: 2016年9月27日 下午5:10:31
 *
 */
public class BinaryTree {

	/**
	 * 根据数组创建二叉树
	 * 
	 * @param arr
	 *            数组数据
	 * @return 根节点
	 */
	public Node buildBinaryTree(int arr[]) {
		Node root = null;
		/*for (int i = 0; i < arr.length; i++) {
			root = insertRecursion(arr[i], root);
		}*/
		for (int i = 0; i < arr.length; i++) {
			root = insertNonRecursion(arr[i], root);
		}
		return root;
	}

	/**
	 * 非递归创建二叉树
	 * 
	 * @param data
	 *            数据
	 * @param root
	 *            根节点
	 * @return 根节点
	 */
	public Node insertNonRecursion(int data, Node root) {
		Node target = new Node(data);
		if (root == null) {
			return target;
		} else {
			Node current = root;
			Node parent;
			while (true) {
				parent = current;
				if (current.data > data) {
					current = current.left;
					if (current == null) {
						parent.left = target;
						return root;
					}
				} else {
					current = current.right;
					if (current == null) {
						parent.right = target;
						return root;
					}
				}
			}
		}
	}

	/**
	 * 递归创建二叉树
	 * 
	 * @param data
	 *            数据
	 * @param root
	 *            根节点
	 * @return 根节点
	 */
	public Node insertRecursion(int data, Node root) {
		Node current = root;
		Node target = new Node(data);
		if (root == null) {
			return target;
		} else {
			if (current.data > data) {
				if (current.left == null) {
					current.left = target;
				} else {
					insertRecursion(data, current.left);
				}
			} else {
				if (current.right == null) {
					current.right = target;
				} else {
					insertRecursion(data, current.right);
				}
			}
		}
		return root;
	}

	/**
	 * 前序遍历
	 * 
	 * @param root
	 *            根节点
	 */
	public void preOrder(Node root) {
		if (root != null) {
			System.out.print("(");
			if(root.left == null) {
				System.out.print(root.data + ", None");
			} else {
				System.out.print(root.data + ", ");
			}
			preOrder(root.left);
			if(root.right == null) {
				System.out.print(", None)");
			} else {
				System.out.print(", ");
			}
//			System.out.print(")");
			preOrder(root.right);
		}
	}

	/**
	 * 中序遍历
	 * 
	 * @param root
	 *            根节点
	 */
	public void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.println(root.data);
			inOrder(root.right);
		}
	}

	/**
	 * 后序遍历
	 * 
	 * @param root
	 *            根节点
	 */
	public void postOrder(Node root) {
		if (root != null) {
			postOrder(root.left);
			preOrder(root.right);
			System.out.println(root.data);
		}
	}

	/**
	 * 层序遍历
	 * 
	 * @param root
	 *            根节点
	 */
	public void layoutTranverse(Node root) {
		Queue<Node> treeQ = new LinkedList<Node>();
		Node current = root;
		treeQ.add(current);
		while(!treeQ.isEmpty()) {
			Node tmp = treeQ.poll();
			System.out.println(tmp.data);
			if(tmp.left != null) {
				treeQ.add(tmp.left);
			}
			if(tmp.right != null) {
				treeQ.add(tmp.right);
			}
		}
	}

	/**
	 * 求二叉树中节点的最大距离
	 * 
	 * @param root
	 *            根节点
	 */
	public void findMaxDistance(Node root) {

	}
}
