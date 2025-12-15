import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
		Queue <Integer> q=new Queue<>();
		q.insert(8);
		q.insert(2);
		q.insert(7);

		System.out.println(isExist(q,2));
		System.out.println(avg(q));

	}

	public static Queue<Integer> ex1(Queue<Integer> q) {
		Queue<Integer> h = new Queue<Integer>();
		Queue<Integer> p = new Queue<Integer>();

		while (!q.isEmpty()) {
			p.insert(q.head());
			h.insert(q.remove());
		}

		while (!p.isEmpty()) {
			q.insert(p.remove());
		}

		return h;
	}


	public static boolean isExist(Queue<Integer> q, int n) {
		Queue<Integer> b = ex1(q);
		while(!b.isEmpty()) {
			int a = b.remove();
			if (a==n) {
				return true;
			}
		}
		return false;
	}

	public static double avg(Queue<Integer> q) {
		Queue<Integer> n = ex1(q);
		int sum = 0;
		int count = 0;
		while(!n.isEmpty()) {
			sum = sum + n.remove();
			count++;
		}
		return (double) sum/count;
	}



}
