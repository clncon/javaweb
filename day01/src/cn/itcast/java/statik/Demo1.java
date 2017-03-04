package cn.itcast.java.statik;
import static java.lang.Math.PI;
import static java.lang.Math.pow;
//静态导入求圆面积
public class Demo1 {
     public static void main(String[] args){
    	 double r = 5.2;
    	 System.out.println("圆的面积是"+PI*pow(r,2));
     }
}
