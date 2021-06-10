import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13335_트럭_해결 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 트럭 
		int W = Integer.parseInt(st.nextToken()); // 다리 길이
		int L = Integer.parseInt(st.nextToken()); // 다리 하중 
		int arr[] = new int[N];
		int cnt =0; // 총걸린 최단시간
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=0; i<W; i++) {
			q.add(0); // 다리길이만큼 큐에 0을넣어준다 카운트를 해주기위해
		}
		
		int qSum=0; //다리 하중 
		
		for(int i=0; i<N; i++) {
			boolean isJustPass = false; // 카운트를 셀때 하나만 세주기 위해 측정하는것.

				while(qSum + arr[i] > L){ // 다리 하중이 꽉차있으면 하중이 줄어들때까지 트럭을 이동시킨다.
					isJustPass = true;
					cnt++;
					
					int temp =q.poll();
					qSum -= temp;
					
					if(qSum + arr[i] <=L) {
						break;
					}
					q.add(0);
					//System.out.println("그냥흘려보내는 시간"+cnt);
				}
			
				if(!isJustPass) { // 안거쳐온거
					cnt++;
					
					int temp = q.poll();
					qSum -= temp;
					
					q.add(arr[i]);
					qSum += arr[i];
				}else { //while문을 거쳐온거

					q.add(arr[i]);
					qSum += arr[i];
				}
				

				//System.out.println(i+"번째 넣었을때 시간"+cnt);
		}
		
		while(!q.isEmpty()) {
			q.poll();
			cnt++;
		}
		
		//System.out.print("최종 ");
		System.out.println(cnt);
		
		
	}

}