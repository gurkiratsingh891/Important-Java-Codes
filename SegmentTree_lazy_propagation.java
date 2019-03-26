
    
//Segement Tree with Lazy propagation
class SegmentTree
{
    void buildTree(int[] arr,int[] tree,int start,int end,int treenode)
    {
        if(start==end)
        {
            tree[treenode]=arr[start];
            return;
        }
        int mid=(start+end)/2;
        buildTree(arr,tree,start,mid,2*treenode);
        buildTree(arr,tree,mid+1,end,2*treenode+1);
        tree[treenode]=Math.min(tree[2*treenode],tree[2*treenode+1]);
        
    }
    void updateTreeLazy(int[] tree,int[] lazy,int start,int end,int treenode,int left,int right,int value)
    {
        if(start>end)
        return;
        if(lazy[treenode] !=0){
		tree[treenode] += lazy[treenode];

		if(start!=end){
			lazy[2*treenode] += lazy[treenode];
			lazy[2*treenode+1] += lazy[treenode];
		}
		lazy[treenode] = 0;
	}
        //no overlap
        if(start>right || end<left)
        return ;
        //complete overlap
        if(start<=left&&end<=right)
        {
            tree[treenode]+=value;
            if(start!=end)
            {
                lazy[2*treenode]+=value;
                lazy[2*treenode+1]+=value;
            }
            return;
        }
        //partial overlap
        int mid=(start+end)/2;
                    updateTreeLazy(tree,lazy,start,mid,2*treenode,left,right,value);
            updateTreeLazy(tree,lazy,mid+1,end,2*treenode+1,left,right,value);
        tree[treenode]=Math.min(tree[2*treenode],tree[2*treenode+1]);
    }
    int query(int[] tree,int[] lazy,int start,int end,int treenode,int left,int right)
    {
            if(lazy[treenode] !=0){
		tree[treenode] += lazy[treenode];

		if(start!=end){
			lazy[2*treenode] += lazy[treenode];
			lazy[2*treenode+1] += lazy[treenode];
		}
		lazy[treenode] = 0;
	}
        //Completely outside given range
        if(start>right || end<left)
        return Integer.MAX_VALUE;
        //Completely inside given range
        if(start>=left&&end<=right)
        return tree[treenode];
        //Partially inside and partially outside
        int mid=(start+end)/2;
        int ans1=query(tree,lazy,start,mid,2*treenode,left,right);
        int ans2=query(tree,lazy,mid+1,end,2*treenode+1,left,right);
        return Math.min(ans1,ans2);
    }
}
public class MyClass {
    public static void main(String args[]) {
        int arr[] = {1,3,-2,4};
        int n=arr.length;
        int[] tree=new int[4*n];  
        int[] lazy=new int[4*n];
        SegmentTree st=new SegmentTree();
        st.buildTree(arr,tree,0,3,1);
       
        st.updateTreeLazy(tree,lazy,0,3,1,0,3,3);
        
	st.updateTreeLazy(tree,lazy,0,3,1,0,1,2);
	   for(int i=1;i<12;i++)
        {
            System.out.println(tree[i]);
        }
       
         for(int i=1;i<12;i++)
        {
            System.out.println(lazy[i]);
        }
                    System.out.println(st.query(tree,lazy,0,3,1,0,1));

        
    }
}

