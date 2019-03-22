//Segement Tree
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
        tree[treenode]=tree[2*treenode]+tree[2*treenode+1];
        
    }
    void updateTree(int[] arr,int[] tree,int start,int end,int treenode,int indx,int value)
    {
        if(start==end)
        {
            arr[indx]=value;
            tree[treenode]=value;
            return;
        }
        int mid=(start+end)/2;
        if(indx>mid)
        {
            updateTree(arr,tree,mid+1,end,2*treenode+1,indx,value);
        }
        else
        {
            updateTree(arr,tree,start,mid,2*treenode,indx,value);
        }
        tree[treenode]=tree[2*treenode]+tree[2*treenode+1];
    }
    int query(int[] tree,int start,int end,int treenode,int left,int right)
    {
        
        //Completely outside given range
        if(start>right || end<left)
        return 0;
        //Completely inside given range
        if(start>=left&&end<=right)
        return tree[treenode];
        //Partially inside and partially outside
        int mid=(start+end)/2;
        int ans1=query(tree,start,mid,2*treenode,left,right);
        int ans2=query(tree,mid+1,end,2*treenode+1,left,right);
        return ans1+ans2;
    }
}
public class MyClass {
    public static void main(String args[]) {
        int[] arr={1,2,3,4,5};
        int n=arr.length;
        int[] tree=new int[2*n];  //2n-1 elements ,,from 1 to 2n-1
        SegmentTree st=new SegmentTree();
        st.buildTree(arr,tree,0,4,1);
         for(int i=1;i<tree.length;i++)
        {
            System.out.println(tree[i]);
        }
        st.updateTree(arr,tree,0,4,1,2,10);
        int ans=st.query(tree,0,4,1,2,4);
        System.out.println(ans);
    }
}
