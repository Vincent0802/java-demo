package com.demo.data.linked.list;

import com.demo.data.sort.BubbleSort;

/**
 * @Description: 单链表的基本操作
 *
 * @author Cyrus
 *
 * @time: 2016年9月23日 上午9:43:18
 *
 */
public class LinkedListDemo {

	/**
	 * 添加节点在末尾
	 * 
	 * @param head
	 *            头节点
	 * @param data
	 *            节点数据
	 * @return head 头节点
	 */
	public static Node addNode(Node head, int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return head;
		}
		Node demo = head; // 创建一个副本，不改变原来的head值
		while (demo.next != null) {
			demo = demo.next;
		}
		demo.next = newNode;
		return head;
	}

	/**
	 * 删除节点
	 * 
	 * @param head
	 *            头节点
	 * @param pos
	 *            位置
	 * @return head 头节点
	 */
	public static Node deleteNode(Node head, int pos) {
		if (pos < 1 || pos > length(head)) {
			System.out.println("IndexOutOfBound");
			return null;
		}
		if (pos == 1) {
			head = head.next;
			return head;
		}

		Node preNode = head;
		Node curNode = preNode.next;
		int a = 1;
		while ((a++ != pos - 1) && (curNode.next != null)) {
			preNode = preNode.next;
			curNode = curNode.next;
		}

		preNode.next = curNode.next;
		return head;
	}

	/**
	 * 插入节点，在节点前插入
	 * 
	 * @param head
	 *            头节点
	 * @param data
	 *            节点数据
	 * @param pos
	 *            位置
	 * @return head 头节点
	 */
	public static Node insert(Node head, int data, int pos) {
		Node newNode = new Node(data);

		if (pos < 1 || pos > length(head)) {
			System.out.println("IndexOutOfBound");
			return null;
		}
		if (pos == length(head)) {
			head.next = newNode;
			return head;
		}
		Node preNode = head;
		Node curNode = preNode.next;
		int a = 1;
		while ((a++ != pos - 1) && (curNode.next != null)) {
			preNode = preNode.next;
			curNode = curNode.next;
		}
		newNode.next = curNode;
		preNode.next = newNode;
		return head;
	}

	/**
	 * 计算单链表长度
	 * 
	 * @param head
	 *            头节点
	 * @return 单链表长度
	 */
	public static int length(Node head) {
		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}
		return len;
	}

	/**
	 * 给单链表排序
	 * 
	 * @param head
	 *            头节点
	 * @return head 头节点
	 */
	public static Node orderList(Node head) {
		Node demo = BubbleSort.bubbleSort(head);
		return demo;
	}

	/**
	 * 打印单链表数据
	 * 
	 * @param head
	 *            头节点
	 */
	public static void printList(Node head) {
		Node demo = head;
		int pos = 1;
		System.out.println("单链表值如下：");
		while (demo != null) {
			System.out.println("data" + pos + " = " + demo.data);
			demo = demo.next;
			pos++;
		}
	}

	/**
	 * 快慢指针判断单链表是否有环
	 * 
	 * @param head
	 *            头节点
	 * @return true or false
	 */
	public static boolean isLoop(Node head) {
		Node fast = head;
		Node slow = head;
		if (fast == null) {
			return false;
		}
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return true;
			}
		}
		return !(fast == null || fast.next == null);
	}

	/**
	 * 找到环的入口
	 * 
	 * @param head
	 *            头节点
	 * @return 环的入口节点
	 */
	public static Node findLoopPort(Node head) {
		Node fast = head;
		Node slow = head;
		if (fast == null) {
			return null;
		}
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				break;
			}
		}
		if (fast == null || fast.next == null) {
			return null;
		}
		slow = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}

	/**
	 * 删除重复元素,双重循环
	 * 
	 * @param head
	 *            头节点
	 * @return head 头节点
	 */
	public static Node deleteDuplecate(Node head) {
		Node p = head;
		while (p != null) {
			Node q = p;
			while (q.next != null) {
				if (p.data == q.next.data) {
					q.next = q.next.next;
				} else {
					q = q.next;
				}
			}
			p = p.next;
		}
		return head;
	}

	/**
	 * 找出单链表倒数第k个节点
	 * 
	 * @param head
	 *            头节点
	 * @return 所求节点
	 */
	public static Node findElement(Node head, int k) {
		if (k < 1 || k > length(head)) {
			return null;
		}
		Node p1 = head;
		Node p2 = head;
		for (int i = 0; i < k; i++) {
			p1 = p1.next;
		}
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}

	/**
	 * 反转单链表
	 * 
	 * @param head
	 *            头节点
	 * @return head 头节点
	 */
	public static Node reverse(Node head) {
		Node preNode = head;
		Node curNode = preNode.next;
		Node postNode = curNode.next;
		preNode.next = null;
		while (curNode != null) {
			curNode.next = preNode;
			preNode = curNode;
			curNode = postNode;
			if (postNode == null)
				break;
			postNode = postNode.next;
		}
		return preNode;
	}

	/**
	 * 从尾到头输出单链表
	 * 
	 * @param head
	 *            头节点
	 */
	public static void printReversely(Node head) {
		if (head != null) {
			printReversely(head.next);
			System.out.println("data" + " = " + head.data);
		}
	}

	/**
	 * 找出单链表中间节点,快慢指针，快走两步，慢走一步，
	 * 
	 * @param head
	 *            头节点
	 * @return 所求节点
	 */
	public static Node findMiddle(Node head) {
		Node p = head;
		Node q = head;
		while (p != null && p.next != null && p.next.next != null) {
			p = p.next.next;
			q = q.next;
		}
		return q;
	}

	/**
	 * 不知头节点的情况下删除指定节点(若为链尾节点则无法删除，无法设置前驱节点next为null)
	 * 
	 * @param head
	 *            头节点
	 * @return head 头节点
	 */
	public static boolean deleteUnknownHead(Node target) {
		if (target == null || target.next == null) {
			return false;
		}
		int tmp = target.data;
		target.data = target.next.data;
		target.next.data = tmp;// 交换后面的data，并抛弃next
		target.next = target.next.next;
		return true;
	}

	/**
	 * 判断两个链表是否相交(判断尾节点是否相同)
	 * 
	 * @param head
	 *            头节点
	 * @return true or false
	 */
	public static boolean isIntersect(Node p, Node q) {
		Node tail1 = p;
		while (tail1.next != null)
			tail1 = tail1.next;

		Node tail2 = q;
		while (tail2.next != null)
			tail2 = tail2.next;
		return tail1 == tail2;
	}
}
