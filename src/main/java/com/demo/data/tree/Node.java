package com.demo.data.tree;

/**
 * @Description: Tree节点类
 *
 * @author Cyrus
 *
 * @time: 2016年9月27日 下午5:10:14
 *
 */
public class Node {

	Node left;

	Node right;

	public int data;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
