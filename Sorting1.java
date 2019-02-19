// Sorting an array w.r.t sorting of other array
//Here,,, sorting array count w.r.t sorting of array weight;
import java.util.*;

class Cake
{
  int weight;
  int count;
}
class SortByWeight implements Comparator<Cake>
{
	public int compare(Cake a,Cake b)
    {
    	return (a.weight-b.weight);    // This is ascending order //Do (b.weight-a.weight) for descending
    }
}
public class MyClass {
    public static void main(String args[]) {
        int weight[]={5,10,15,2,4};   //Weight of type of cakes
        int count[]={1,2,3,4,5};     // count of those cakes
        //sort the cakes w.r.t weight and store the respective count
        int n=weight.length;
        Cake[] cakes=new Cake[n];
          for(int j=0;j<n;j++)
        {
          cakes[j]=new Cake();
          cakes[j].weight=weight[j];
        }
          for(int j=0;j<n;j++)
        {
          cakes[j].count=count[j];
        }
        Arrays.sort(cakes,new SortByWeight());
        for(int i=0;i<n;i++)
        {
            System.out.println(cakes[i].weight+" "+cakes[i].count);
        }
       
    }
}
