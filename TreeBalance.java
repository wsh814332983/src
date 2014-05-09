import java.math.*;
class TreeBalance {
public static int getHight(TreeNode root){
	if(root==null){
		return 0;
	}
	
	return Math.max(getHight(root.left), getHight(root.right))+1;
}
public static boolean isBalance(TreeNode root){
	if(root==null){
		return true;
	}
	int val=getHight(root.left)-getHight(root.right);
	if(val>1){
		return false;
		
	}else{return isBalance(root.left)&&isBalance(root.right);}
}
public int checkHight(TreeNode root){
	if(root==null){
		return 0;
	}
	if(checkHight(root.left)==-1){
		return -1;
	}
	if(checkHight(root.right)==-1){
		return -1;
	}
	int val=Math.abs(checkHight(root.left)-checkHight(root.right));
	if(val>1){
		return -1;
	}
	else{return Math.max(checkHight(root.left), checkHight(root.right))+1;}
}
public boolean isaBalance(TreeNode root){
	if(checkHight(root)==-1){
		return false;
		
	}else{return true;}
}
}
