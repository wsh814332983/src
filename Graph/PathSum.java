package Graph;

public class PathSum {
  public void findSum(TreeNode node,int sum,int[] path,int level){
	  if(node==null) return;
	  path[level]=node.val;
	  int t=0;
	  for(int i=level;i>=0;i--){
		  t+=path[i];
		  if(t==sum){
			  print(path,i,level);
		  }
	  }
	  findSum(node.left,sum,path,level+1);
	  findSum(node.right,sum,path,level+1);
	  path[level]=Integer.MIN_VALUE;
  }
  public void findSum(TreeNode node,int sum){
	  int depth=depth(node);
	  int[] path=new int[depth];
	  findSum(node,sum,path,0);
  }
  public int depth(TreeNode node){
	  if(node==null) return 0;
	  return Math.max(depth(node.left), depth(node.right))+1;
  }
  public void print(int[] path, int i,int level){
	  for(int h=level;h>=i;h--){
		  System.out.print(path[h]+" ");
	  }
	  System.out.println();
  }
//	public static void findSum(TreeNode node, int sum, int[] path, int level) {
//		if (node == null) {
//			return;
//		}
//
//		/* Insert current node into path */
//		path[level] = node.val; 
//
//		int t = 0;
//		for (int i = level; i >= 0; i--){
//			t += path[i];
//			if (t == sum) {
//				print(path, i, level);
//			}
//		}
//
//		findSum(node.left, sum, path, level + 1);
//		findSum(node.right, sum, path, level + 1);
//
//		/* Remove current node from path. Not strictly necessary, since we would
//		 * ignore this value, but it's good practice.
//		 */
//		path[level] = Integer.MIN_VALUE; 
//	}
//
//	public static int depth(TreeNode node) {
//		if (node == null) {
//			return 0;
//		} else {
//			return 1 + Math.max(depth(node.left), depth(node.right));
//		}
//	}
//
//	public static void findSum(TreeNode node, int sum) {
//		int depth = depth(node);
//		int[] path = new int[depth];
//		findSum(node, sum, path, 0);
//	}
//
//	private static void print(int[] path, int start, int end) {
//		for (int i = start; i <= end; i++) {
//			System.out.print(path[i] + " ");
//		}
//		System.out.println();
//	}

  public static void main(String [] args){
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(6);
	PathSum a=new PathSum();
		a.findSum(root, 8);
	}
}
