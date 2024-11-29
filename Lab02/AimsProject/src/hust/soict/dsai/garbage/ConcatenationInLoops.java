package hust.soict.dsai.garbage;

import java.util.Random;

public class ConcatenationInLoops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random(123);
		long start = System.currentTimeMillis();
		String s = "";
		for(int i=0;i<65536;i++) {
			s+= r.nextInt(2);
		}
		System.out.println(System.currentTimeMillis()-start); //print 1476
		
		r = new Random(123);
		start = System.currentTimeMillis();
		StringBuilder sb = 	new StringBuilder();
		for (int i=0;i<65536;i++) {
			sb.append(r.nextInt(2));
		}
		s = sb.toString();
		System.out.println(System.currentTimeMillis() - start); //print 1

	}

}
