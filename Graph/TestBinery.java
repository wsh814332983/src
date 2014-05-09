package Graph;

public class TestBinery {
	public boolean testBinery(TreeNode a,Integer max,Integer min){
		if(a==null) return true;
		if(min!=null&&a.val<=min||max!=null&&a.val>max){
			return false;
			
		}
		if(!testBinery(a.left,min,a.val)||(!testBinery(a.right,a.val,max))){
		  return false;
		}
		return true;
	}
  public boolean testBinery(TreeNode root){
	  return testBinery(root,null,null);
  }
}
