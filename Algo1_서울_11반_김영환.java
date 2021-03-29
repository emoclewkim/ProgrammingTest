import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Algo1_서울_11반_김영환 { // 백준 1755 숫자놀이

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		ArrayList<alpha> list = new ArrayList<>();  // 이 리스트에 제가 만든 알파라는 클래스 형식으로 담아서 정렬을 할것입니다
		
		for(int i=m; i<=n; i++) { // 각각의 숫자에 맞게 알파벳 영어를 스트링으로 담아줍니다
			
			int a = i/10;
			int b = i%10;
			
			String str="";
			
			if(a==0) {
				if(b==1) str ="one";
				else if(b ==2) str = "two";
				else if(b ==3) str = "three";
				else if(b ==4) str = "four";
				else if(b ==5) str = "five";
				else if(b ==6) str = "six";
				else if(b ==7) str = "seven";
				else if(b ==8) str = "eight";
				else if(b ==9) str = "nine";
			}else{
				if(a==1) str ="one";
				else if(a ==2) str = "two";
				else if(a ==3) str = "three";
				else if(a ==4) str = "four";
				else if(a ==5) str = "five";
				else if(a ==6) str = "six";
				else if(a ==7) str = "seven";
				else if(a ==8) str = "eight";
				else if(a ==9) str = "nine";
				
				if(b==0) str +="zero";
				else if(b ==1) str +="one";
				else if(b ==2) str += "two";
				else if(b ==3) str += "three";
				else if(b ==4) str += "four";
				else if(b ==5) str += "five";
				else if(b ==6) str += "six";
				else if(b ==7) str += "seven";
				else if(b ==8) str += "eight";
				else if(b ==9) str += "nine";
			}
			
			list.add(new alpha(i,str));
		}
		
		Collections.sort(list); // 정해준 기준에 맞게 정렬하고
		
		int cnt=0;
		for(int i=0; i<list.size(); i++) { // 10개단위로 띄어서 출력
			cnt++;
			System.out.print(list.get(i).i+" ");
			if(cnt%10==0) System.out.println();
		}
		

		
	}
	
	static class alpha implements Comparable<alpha>{  //alpha라는 클래스를 생성해서 숫자값과 그 숫자를 영어로 읽은 값을 값으로 가지는 클래스를 선언해서 리스트에 넣어서 알파벳순서대로 정렬한다.
		int i;
		String name;
		
		alpha(int i, String name){
			this.i = i;
			this.name = name;
		}

		@Override
		public String toString() {
			return "i: "+i+" "+"name: "+name; 
		}

		@Override
		public int compareTo(alpha o) {
			return name.compareTo(o.name); // 비교 우선순위를 알파벳의 사전순에 맞게 나열한다
		}
		
		
		
	}
	


}
