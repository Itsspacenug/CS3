package findDups;
//Aaron Nguyen
//7th

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class dups {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<String> set = new HashSet<String>();
		System.out.println("Enter words");
		String st = sc.nextLine();
		set.add(st);
		while(true) {
			System.out.println("Enter words");
			st = sc.nextLine();
			if(st.equals("exit")) {
				System.out.println("\"EXIT\" CLOSES THE PROGRAM\nSize: "+ set.size());
				for(String s : set) {
					System.out.println(s + " ");
				}
				break;
			}
			else {
				if(set.contains(st)) {
					System.out.println("DUPLICATE DETECTED ["+st+"]");
					
				}
			}
			set.add(st);
			
		}
	}

}
