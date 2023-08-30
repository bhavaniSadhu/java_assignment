package com.samplecode.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Sample {
	public static void main(String[] args) {
		List<Employee>empList = new ArrayList<Employee>();		       
		empList.add(new Employee(10,"Havish",10000,"IT"));
		empList.add(new Employee(50,"Rajesh",40000,"IT"));
		empList.add(new Employee(40,"Sirish",20000,"IT"));
		empList.add(new Employee(20,"Mahesh",80000,"IT"));
		empList.add(new Employee(30,"Girish",100000,"IT"));
		
		//Sort by salary - java 8 streams
		
		System.out.println("Before Sorting -->"+empList);
		List<Employee> empSalSortedList = empList.stream().sorted((e1,e2) ->(int)e1.getSalary() - e2.getSalary()).collect(Collectors.toList());
		System.out.println("After Sorting by salary -->"+empSalSortedList);
		List<Employee> empSortedList2 = empList.stream().sorted(Comparator.comparingInt(Employee::getSalary)).collect(Collectors.toList());
		
		
		//Sort by name - comparator
		Collections.sort(empList, new NameComparator());
		System.out.println("After Sorting by name -->"+empList);
		
		//Sort by id - comparable
		
		Collections.sort(empList);
		System.out.println("After Sorting by id -->"+empList);
		
		
		int[] data = {1,2,3,4,5,6,7,8,9,10};
		Arrays.stream(data).filter(i -> i%2==0).forEach(p->System.out.println(p));
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		list.stream().filter(i->i%2==0).forEach(System.out::println);
		
		Predicate<Integer> checkEven = new Predicate<Integer>() {
			
			@Override
			public boolean test(Integer t) {
				if(t%2==0 && t!=null) {
					return true;
				}
				return false;
			}
		};
		
		list.stream().filter(checkEven).forEach(p->System.out.println(p));
	}
}
