package Double;

import java.util.ArrayList;
import java.util.HashMap;

import Double.Scs_coordinate.UValue;

//this is a demo for using Scs_partition
public class Scs_partitioned_demo {
	 public static void main(String[] args) {
		 
//		int n; int nets; int[]int_node; int[]ext_node;
//		
//		Scs_partitioned matA;//= new Scs_partitioned();
//		
//		
//		
//		//n is dimension of the square matrix,user supplys.
//		n=100;
//		matA.setDim(n);//set the dimension of the matrix
//		
//		Scsm Y = getMat(agrs[0]);//loads the matrix file 
//		Scsv I = geRhs(args[1]);//loads the vector file 
//		
//		matA.setScs(Scsy);
//		
////		ArrayList<int> intNd=new ArrayList<int>(8);
////		ArrayList<int> ExtNd=new ArrayList<int>();
////		int [] ext_node = setExt_nodes(intNd);//loads the external file s
////		int [] int_node = setInt_nodes(ext_nodes); 
//		Scs_partnetwork.SetNeta(ext_node, int_node);//set and returns each networks' separately
//		Scs_netT(Ytt~,It~);//calculate coordinate class of Ytt and IT 
//		Scs Ut = Scs_Gaussian(Ytt~,It~);//returns Ut
//		Scs_partitioned.cs_partoper(ext_node,int_node,Ut,Y,);
//		
		 //must have args[0]: coordi.txt to be coordinate txt 
		 //args[1]: subnet1.txt ....
		 Scs_coordinate scsMain=new Scs_coordinate();
		 int s = -1;
		 HashMap<Integer,Double>inj = new HashMap<Integer, Double>();
		 for(int i=0;i<args.length;i++)
		 {
			 ArrayList<Scs_coordinate.branch> intBrlist;
			 ArrayList<Scs_coordinate.branch> bordBrlist;
			 
			 if(i==0)
			 {
				 intBrlist=scsMain.YTTBranch;
				 bordBrlist=null;
			 }
			 else
			 {
				 Scs_subnet sub=new Scs_subnet();
				 intBrlist=sub.intbranch;
				 bordBrlist=sub.bordbranch;
			 }
			 Scs_partition_utilities.load(args[i],intBrlist,bordBrlist,s,inj);
		 }   
		 scsMain.solve();
		 ArrayList<UValue> resultU=scsMain.getResult(); //get UT
//		 
		 
		 
		 
		 
	 }
}
	
