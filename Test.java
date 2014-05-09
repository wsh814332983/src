import java.util.*;

class ArrayTest1{
	public ArrayList<String> merge(String[] words,String[] more){
		ArrayList<String> sentence=new ArrayList<String>();
		for(String w:words ) {
			sentence.add(w);
		}
		for(String w:more){
			sentence.add(w);
		}
		
		
		return sentence;
	}
}
class Array1{
public boolean testunique (String a){
		if(a.length()>256){
			return false;
		}
		boolean char_unique[]=new boolean[256];
		for (int i=0;i<a.length();i++){
			int b=a.charAt(i);
			System.out.print(a.charAt(i));
			if(char_unique[b]){
				return false;	
			}
			char_unique[b]=true;
		}
		return true;
	}
public boolean testunique2(String a){
		if(a.length()>256){
			return false;
		}
		for(int i=0;i<a.length();i++){
	     char b=a.charAt(i);
	      for(int j=a.length()-1;j>i;j--){
	    	  if(b==a.charAt(j)){
	    		  return false;
	    	  }
	    	  break;
	      }
	}
	
      return true;
}
}
class Array2{
	public String reverse(String a){
		char b[]=new char[a.length()];
		b=a.toCharArray();
		for(int i=0;i<=a.length()/2-1;i++){
			char temp;
			temp=b[i];
			b[i]=b[a.length()-1-i];
			b[a.length()-1-i]=temp;	
			
		}
		String c=String.valueOf(b);
		return c;
	}
	
}
class Array3{
	public boolean Permutation(String a,String b){
		if(a.length()!=b.length()){
			return false;
		}
		char c[]=a.toCharArray();
		char d[]=b.toCharArray();
		Arrays.sort(c);
		String e=new String(c);
		Arrays.sort(d);
		String f=new String(d);
		if(e.equals(f)){
			return true;
		}
		
		
		return false;
	}
	public boolean Permutation2(String a,String b){
		if(a.length()!=b.length()){
			return false;
		}
		int c[]=new int[256];
		char d[]=a.toCharArray();
		for(char f:d){
			c[f]++;	
		}
		for(int i=0;i<b.length();i++){
			int e=(int) b.charAt(i);
			if(--c[e]<0){
				return false;
			}
		}
		return true;
	}
}
class Array4{
	public String Replace(String a){
		char space=' ';
		
		int length=a.length();
		for(int i=0;i<a.length();i++){
			if(a.charAt(i)==' '){
			length=length+2;}
		}
		System.out.print(length);
		char b[]=new char[length];
		//b[length]='\0';
		int j=length-1;
		for(int i=a.length()-1;i>=0;i--){
				if(a.charAt(i)==' '){
					b[j]='%';
					b[--j]='2';
					b[--j]='0';
					j--;
					
				}
				if(a.charAt(i)!=' '){
					b[j]=a.charAt(i);
					j--;
				}
			
		}
		return String.valueOf(b);
	}
}
class Array5{
	public String Compress(String a){
		String b=new String();
		a=a+" ";
		int count=1;
		if(a.length()>countCompress(a)){
		for (int i=0;i<a.length()-1;i++){
			if(a.charAt(i)==a.charAt(i+1)){
				count++;
			}
			else if(a.charAt(i)!=a.charAt(i+1)){
				if(count!=1){
				b=b+String.valueOf(a.charAt(i))+String.valueOf(count);
				count=1;}
				else {b=b+String.valueOf(a.charAt(i))+String.valueOf(count);
				count=1;
				}
			}
		}
		return b;}else{
			return a;
		}
	}
    public int countCompress(String a){
	if(a.length()==0||a==null){
		return 0;
	}
	int count=1;
	int size=2;
	a=a+" ";
	for(int i=0;i<=a.length()-2;i++){
		if(a.charAt(i)==a.charAt(i+1)){
			count++;
			size=size;
		}else{
			size+=2;
		}
	}
	return size;
}
}
class Array6{
	public void rotateMatric(int matric[][],int n){
		
		int top[][]=new int[n][n];
		for(int layer=0;layer<n/2;++layer){
			int first=layer;
			int last=n-1-layer;
			for(int i=first;i<last;++i){
				int offset=i-first;
				top[first][i]=matric[first][i];
				  //left to top;
				matric[first][i]=matric[last-offset][first];
				 //bottom to left;
				matric[last-offset][first]=matric[last][last-offset];
				 //right to bottom;
				matric[last][last-offset]=matric[i][last];
				matric[i][last]=top[first][i];	
			}
		}
	}
	
}
class Array7{//need approve;
	public void zeroTest(int matric[][],int m,int n){
		int count[][]=new int[m][n];
		for(int i=0;i<m;i++){
			for(int t=0;t<n;t++){
				if(matric[i][t]==0){
					count[i][t]=1;
				}else{
					count[i][t]=0;
				}
			}
		}
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(count[i][j]==1){
					for(int h=0;h<m;h++){
						matric[h][j]=0;
					}
					for(int h=0;h<n;h++){
						matric[i][h]=0;
					}
				}
			}
		}
		
	}
}