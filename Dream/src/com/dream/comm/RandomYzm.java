package com.dream.comm;

import java.util.Random;

public class RandomYzm {
	public int  Randyzm(){
	   Random r= new Random();
	 
	   int rand = r.nextInt(899999);

	    rand = rand+100000;
	 return rand;
}

}
  