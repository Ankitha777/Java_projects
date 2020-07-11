package com.example.order;

import java.util.stream.Collectors; 
import java.util.stream.Stream; 
import java.util.*;
import java.util.function.Function; 


public class Myservice {

	public void Orders() {
		//Orders to sore lists of orders,split_items is to split the items
		//Itemnumber_toStore is to store numbers by splitting item and its number
		ArrayList<String> Orders = new ArrayList<String>();
		ArrayList<String> split_items=new ArrayList<String>();
		ArrayList<Integer> Itemnumber_toStore=new ArrayList<Integer>();
		List<String> str1 = null;
		System.out.println("Enter the total no of orders you have");
		Scanner n = new Scanner(System.in);
		int Ordererd_list = n.nextInt();
		for (int i = 1; i <= Ordererd_list; i++) {
			System.out.print("Order "+i+"->");
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			//Data is stored in orders in the list format
			Orders.add(str);
		}
		//This streams is used to split the orders and sore in str1,
		for (String OrderedData : Orders) {
			str1=Stream.of(OrderedData.split(",")).map (elem -> new String(elem))
		      .collect(Collectors.toList());
			   split_items.addAll(str1);
			   }
		//Resplit and extract the numbers,for ex:item 2->2
		for(String Str2:split_items) {
			Integer k = Integer.parseInt(Str2.substring(5));
			Itemnumber_toStore.add(k);
		}
		//To find most repeated number
		Integer maxVal1 = Itemnumber_toStore.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max((o1, o2) -> o1.getValue().compareTo(o2.getValue()))
                .map(Map.Entry::getKey).orElse(null);
		//count of most repeated number
		Integer count1 = (int) Itemnumber_toStore.stream().filter(o1->o1.intValue()==maxVal1).count();
		//To find second most repeated number
		Integer maxVal2 = Itemnumber_toStore.stream().filter(o1->o1.intValue()!=maxVal1)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max((o1, o2) -> o1.getValue().compareTo(o2.getValue()))
                .map(Map.Entry::getKey).orElse(null);
		//count of second most repeated number
		Integer count2=(int) Itemnumber_toStore.stream().filter(o1->o1.intValue()==maxVal2).count();
		System.out.println();
		//function to map the orders numbers with item numbers
		LooptoPrint_Orders(maxVal1,count1,Orders);
		LooptoPrint_Orders(maxVal2,count2,Orders);
}
  // here maxval is the most repeated number,count is its frequency,orders are the total number of orders
	public void LooptoPrint_Orders(Integer maxVal,int count, ArrayList<String> orders) {
		int i=1;
		String store_orderList="";
		System.out.print("item "+maxVal+"->"+"usageCount: "+count+";"+" Corresponding orders: ");
		for(String OrderedData : orders) {
			//splits with , as reference
			List<String> str1 = Stream.of(OrderedData.split(","))
				      .map (elem -> new String(elem) )
				      .collect(Collectors.toList());
			//i as a reference to find order seq
			for(String str2:str1) {
				if(str2.equalsIgnoreCase("item "+maxVal)) {
					store_orderList=store_orderList+"Order "+i+",";
				}
			}
			i++;
			}
		//prints the orders of the particular list
		System.out.println(store_orderList.substring(0, store_orderList.length()-1));
	}
}
