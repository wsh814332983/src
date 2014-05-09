package Graph;

public class NextNode {
	public static TreeNode inordersucc(TreeNode n){
		if(n==null) return null;
	
	if(n.right!=null){
		return leftMost(n.right);
	}
	else {
		TreeNode p=n;
		TreeNode x=p.parent;
	while (x!=null&&x.left!=p){
		p=x;
		x=p.parent;
	}
	return x;
	}
	
	}
	public static TreeNode leftMost(TreeNode a){
		if(a.left==null) return null;
		while (a.left!=null){
			a=a.left;
		}
		return a;
	}
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		for (int i = 0; i < array.length; i++) {
			TreeNode node = root.find(array[i]);
			TreeNode next = inordersucc(node);
			if (next != null) {
				System.out.println(node.data + "->" + next.data);
			} else {
				System.out.println(node.data + "->" + null);
			}
		}
	}

}
