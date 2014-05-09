package Graph;

public class SubTree {
	public static boolean containsTree(TreeNode t1,TreeNode t2){
		if(t2==null) return true;
		return subTree(t1,t2);
	}
	public static boolean subTree(TreeNode t1,TreeNode t2){
		if(t1==null) return false;
		if(t1.val==t2.val){
			if(matchTree(t1,t2)) return true;
		}
		return (subTree(t1.left,t2))||(subTree(t1.right,t2));
	}
  public static boolean matchTree(TreeNode t1,TreeNode t2){
	  if(t1==null&&t2==null){
		  return true;
	  }
	  if(t1==null||t2==null){
		  return false;
	  }
	  if(t1.val!=t2.val){
		  return false;
	  }
	  return (matchTree(t1.left,t2.left))||(matchTree(t1.right,t2.right));
  }
  
}
