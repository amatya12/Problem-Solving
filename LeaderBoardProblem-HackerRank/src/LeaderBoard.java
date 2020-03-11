import java.util.stream.IntStream;

public class LeaderBoard {

	public static int[] climbingLeaderboard(int[] scores, int[] alice) {
		int[] array = IntStream.of(scores).distinct().toArray();
		int i = array.length - 1;
		int[] res = new int[alice.length];
		int c = 0;
		for (int score : alice) {
			while (i >= 0) {
				if (score >= array[i])
					i--;
				else {
					res[c] = i + 2;
					c++;
					break;
				}
			}
			if (i < 0) {
				res[c] = 1;
				c++;
			}
		}

		return res;
	}

	public static int[] LeaderBoard1(int[] scores, int[] alice) {

		int[] array = IntStream.of(scores).distinct().toArray();

		int c = 0;
		int l = array.length - 1;
		
		int [] res =  new int[alice.length];
		

		for (int x : alice) {
			while(l>=0) {

			if (x >= array[l]) {
				l--;

			} else {
				res[c] = l+2;
				c++;
				break;
				
				}
			}
			
			if(l<0) {
				res[c]=1;
			}
			
			
			

		}
		return res;
		

	}

	public static void main(String[] args) {

		int[] scores = { 100 ,100, 50, 40, 40, 20, 10 };
		int[] alice = { 5, 25, 50, 120};

		LeaderBoard l = new LeaderBoard();
		int[] result = l.LeaderBoard1(scores, alice);
		for (int x : result) {
			System.out.println(x);
		}

	}

}
