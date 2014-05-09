package Graph;

public class FindAncestor {
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		TreeNode n3 = root.find(1);
		TreeNode n7 = root.find(3);
		TreeNode ancestor = commonAncestor(root, n3, n7);
		System.out.println(ancestor.val);
	}
  public static boolean covers(TreeNode root,TreeNode a){
	  if(root==null) return false;
	  if(root==a)return true;  
	 return covers(root.left,a)||covers(root.right,a);
  }
  public static TreeNode commonAncestorHelper(TreeNode root,TreeNode a,TreeNode b){
	  if(root==null)return null;
	  if(root==a)return root;
	  boolean aisonleft=covers(root.left,a);
	  boolean bisonleft=covers(root.left,b);
	  if(aisonleft!=bisonleft) return root;
	  TreeNode child=aisonleft? root.left :root.right;
	  return commonAncestorHelper(child,a,b);
  }
  public static TreeNode commonAncestor(TreeNode root,TreeNode a,TreeNode b){
	  if(!covers(root,a)||!covers(root,b))return null;
	  return commonAncestorHelper(root,a,b);
  }
	
	
}
