package maxWidthOfBinaryTree;

import createtreeusingagivearray.BinaryTree;
import createtreeusingagivearray.Node;

public class Tree<E> {
	// Method 1 using simple level tranverse and counting number of nodes at
	// each leve

	int maxWidthOfTree(Node<E> root) {
		int max = 0;
		for (int i = 0; i < finaMaxDepthOfTree(root); i++) {
			int temp = findNodesAtEachKLevel(root, i);
			if (temp > max)
				max = temp;
		}
		return max;

	}

	int findNodesAtEachKLevel(Node<E> root, int level) {
		if (root == null)
			return 0;
		if (level == 1)
			return 1;

		return findNodesAtEachKLevel(root.getLeftRef(), level - 1)
				+ findNodesAtEachKLevel(root.getRightRef(), level - 1);

	}

	int finaMaxDepthOfTree(Node<E> head) {
		if (head == null) {
			return 0;

		}
		int l = finaMaxDepthOfTree(head.getLeftRef());
		int r = finaMaxDepthOfTree(head.getRightRef());
		if (l > r)
			return l = l + 1;
		else
			return r = r + 1;

	}

	// Method2 recursive way during traverse keep a count of each level of nodes
	// in array

	void findMaxWidthOftree(Node<E> root) {
		int a[] = new int[finaMaxDepthOfTree(root)];
		traverse(root, 0, a);
		int max=0;
		for (int i = 0; i < a.length; i++) {
			if(a[i]>max)
				max=a[i];
		}
		System.out.println(max);
	}

	void traverse(Node<E> root, int level, int a[]) {
		if (root == null)
			return;
		a[level]++;
		traverse(root.getLeftRef(), level + 1, a);
		traverse(root.getRightRef(), level + 1, a);

	}

	public static void main(String[] args) {
		BinaryTree<Integer> bt = new BinaryTree<>();
		Integer[] arr = { 1, 2, 3, 4, 5, 6 };
		bt.covertToTree(arr);
		Tree<Integer> it = new Tree<>();
		// System.out.println(it.maxWidthOfTree(bt.getRoot())); ;
		it.findMaxWidthOftree(bt.getRoot());
	}

}
