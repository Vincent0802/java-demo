package com.demo.data.tree;

/**
 * @Description: 已知中序遍历和后序遍历，求前序遍历
 *
 * @author Cyrus
 *
 * @time: 2016年9月28日 下午12:05:00
 *
 */
public class GetPreOrder {

    public void getPreOrder(int[] inOrder, int[] postOrder) {
        Node root = initTree(inOrder, 0, inOrder.length - 1, postOrder, 0, postOrder.length - 1);
        preOrder(root);
    }

    private void preOrder(Node root) {
        if(root != null) {
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private Node initTree(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int rdata = postOrder[postEnd];
        Node root = new Node(rdata);
        int pos = findIndex(inOrder, rdata, inStart, inEnd);
//        int offset = pos - inStart - 1;利用inOrder计算偏移量
        Node left = initTree(inOrder, inStart, pos - 1, postOrder, postStart, postStart + pos - inStart - 1);
        Node right = initTree(inOrder, pos + 1, inEnd, postOrder, postStart + pos - inStart, postEnd - 1);
        root.left = left;
        root.right = right;
        return root;
    }

    private int findIndex(int[] inOrder, int rdata, int inStart, int inEnd) {
        for(int i = inStart; i <= inEnd; i++) {
            if(inOrder[i] == rdata) {
                return i;
            }
        }
        return -1;
    }


}
