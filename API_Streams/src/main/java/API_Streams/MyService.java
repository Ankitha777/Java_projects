package API_Streams;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MyService {
	public void Orders() {
		ArrayList<String> Orders = new ArrayList<String>();
		ArrayList<Integer> item_list = new ArrayList<Integer>();
		ArrayList<ArrayList> Orders2D = new ArrayList<ArrayList>();
		ArrayList<ArrayList<String>> orders = new ArrayList<ArrayList<String>>();
		// int item_list[]=new int[100];

		System.out.println("Enter the total no of orders you have");
		Scanner n = new Scanner(System.in);
		int i;
		int Ordererd_list = n.nextInt();
		for (i = 0; i <= Ordererd_list; i++) {
			System.out.println("Enter the  total no items of the " + i + "  Order");
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			Orders.add(str);
		}
		for (String OrderedData : Orders) {
			String[] str1;
			i = 0;
			if (OrderedData.matches(".*,.*")) {
				str1 = OrderedData.split(",");
				for (String str2 : str1) {
					String[] str3 = str2.split(" ");
					Integer k = Integer.parseInt(str3[1]);
					// System.out.println(k);
					item_list.add(k);
					i++;
				}
			} else {
				String[] str3 = OrderedData.split(" ");
				Integer k = Integer.parseInt(str3[1]);
				item_list.add(k);
				i++;
			}
		}

		Count_Items(item_list,item_list.size(),Orders);

	}

	public void Count_Items(ArrayList<Integer> item_list, int n,ArrayList<String> Orders) {
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		LinkedList<Integer> Item_toStore = new LinkedList<Integer>();
		ArrayList<Integer> Order_toStore = new ArrayList<Integer>();
		int arrrep[]=new int[10];
		int arrrep1[] = new int[100];
		for (int i = 0; i < item_list.size(); i++) {
			arrrep1[i] = item_list.get(i);
		}
		
		  
		  for(Integer i=0;i<n;i++) {
			  int count=1;
                  for(int j=i+1;j<n;j++) {
					  	if(arrrep1[i]==arrrep1[j] && arrrep1[i]!=99999 && arrrep1[j]!=99999 ){
					  		int store=arrrep1[i];
					  			count++; 
					  		   arrrep1[j]=99999; 
					  	}
				  				
		  }
			
				  if(arrrep1[i]!=99999) {
				  Order_toStore.add(arrrep1[i]);
				  Item_toStore.add(count);
				  } 
			
		  }
		  int large_first[]=Firstlargest(Item_toStore,Item_toStore.size());
		  int large_second[]=Secondlargest(Item_toStore,Item_toStore.size(),large_first[0]);
		  int o=large_first[1];
		  int o1=large_second[1];
		  find_itemNum(Order_toStore,o,Orders,large_first[0]);
		  find_itemNum(Order_toStore,o1,Orders,large_second[0]);
	}
	public  void find_itemNum(ArrayList<Integer> Order_tostore,int o,ArrayList<String> Orders,int maximum) {
		Iterator iterator=Order_tostore.iterator();
		int n=0;
		int item_n = 0;
		int i = 1;
		String coll_orders="";
		int st;
		item_n=Order_tostore.get(o);
		System.out.println();
		System.out.print("item "+item_n+"->");
		System.out.print("usageCount :"+maximum+";");
		System.out.print(" "+"corresponding orders: ");
		
		for (String OrderedData : Orders) {
			String[] str1;
			
            int count=OrderedData.length();
             			//System.out.println(count);
			
			if (OrderedData.matches(".*,.*")) {
				str1 = OrderedData.split(",");
				for (String str2 : str1) {
					String[] str3 = str2.split(" ");
						if(Integer.parseInt(str3[1])==item_n) {
							System.out.print("Order "+i+",");
							
						}
						
				}
			}
				else {
					String[] str3 = OrderedData.split(" ");
					if(Integer.parseInt(str3[1])==item_n) {
						System.out.print("Order "+i+",");
						}
					
				}
			
				i++;
				
				
			}
		System.out.println(coll_orders);
		
		}
	

	public int[] Secondlargest(LinkedList<Integer> item_toStore, int size,int large) {
		int i,index = 0;
		int p=0;
	    int store[]=new int[2];
	    int arr[]=new int[size];
	    for(Integer arr1:item_toStore) {
	    
	    	arr[p]=arr1;
	    	p++;
	    }  
	    // Initialize maximum element 
	    int max = arr[0]; 
	  
	    // Traverse array elements  
	    // from second and compare 
	    // every element with current max  
	    for (i = 0; i < size; i++) 
	        if (arr[i] > max && arr[i]!=large) {
	            max = arr[i]; 
	    		index=i;}
	    store[0]=max;store[1]=index;
	    return store;
	}

	public int[] Firstlargest(LinkedList<Integer> item_toStore, int size) {
		int i,index = 0;
		int p=0;
	    int store[]=new int[2];
	    int arr[]=new int[size];
	    for(Integer arr1:item_toStore) {
	    	arr[p]=arr1;
	    	p++;
	    }	    
	    
	    // Initialize maximum element 
	    int max = arr[0]; 
	  
	    // Traverse array elements  
	    // from second and compare 
	    // every element with current max  
	    for (i = 0; i < size; i++) {
	        if (arr[i] > max) {
	            max = arr[i]; 
	    		index=i;}
	    }
	    store[0]=max;store[1]=index;
	    return store;

	}
}


