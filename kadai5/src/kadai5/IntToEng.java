package kadai5;

import java.util.Scanner;

public class IntToEng {
	static String num="";
	static String numbers1[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
	static String numberTeen[]={"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	static String numbers10[]={"","","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
        	int input = sc.nextInt();	
        	
        System.out.println(translateEng(input));
        
    }
	static String translateEng(int n) {
		if(n<=99)return underTwo(n);
		else {
			int shou100=n/100;
			int amari100=n%100;//amari100は下二桁
			num=numbers1[shou100]+" hundred and "+underTwo(amari100);
			return num;
		}

    }
	static String underTwo(int n){//nは二桁の整数
		if(n<=9)return numbers1[n];
		else if(10<=n && n<=19)return numberTeen[n%10];
		else{
			int shou=n/10;
			int amari=n%10;
			num=numbers10[shou]+"-"+numbers1[amari];
			return num;
		}
	}
	static String underThree(int n){//nは3桁の整数
		if(n<=99)return underTwo(n);
		else {
			int shou100=n/100;
			int amari100=n%100;//amari100は下二桁
			num=numbers1[shou100]+" hundred and "+underTwo(amari100);
			return num;
		}
	}


}
