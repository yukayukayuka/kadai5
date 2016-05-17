package kadai5;

import java.util.Scanner;

public class IntToEng {
	static String num="";
	static String numbers1[]={"zero","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	//static String numberTeen[]={"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	static String numbers10[]={"","ten","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
        	int input = sc.nextInt();	
        	
        System.out.println(translateEng(input));
        
    }
	static String translateEng(int n) {
		if(n<=99)return underTwo(n);
		else if(n<=999)return underThree(n);
		else if(n<=9999)return underFour(n);
		else{
			//error
			/*int shouM=n/10000;
			int amariM=n%10000;
			if(amariM==0)return numbers10[shouM]+" thousand";
			num=numbers10[shouM]+" thousand and "+underFour(amariM);*/
			return num;
		}

    }
	static String underTwo(int n){//nは二桁の整数
		if(n<=19)return numbers1[n];
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
			if(amari100==0)return numbers1[shou100]+" hundred";
			num=numbers1[shou100]+" hundred and "+underTwo(amari100);
			return num;
		}
	}
	static String underFour(int n){//nは４桁の整数
		if(n<=999)return underThree(n);
		else{
			int shou1000=n/1000;			
			int amari1000=n%1000;//amari100は下二桁
			if(amari1000==0 && shou1000<=9)return numbers1[shou1000]+" thousand";
			else if(amari1000==0 && shou1000<=99)return underTwo(shou1000)+" thousand";
			else if(amari1000==0 && shou1000<=999)return underThree(shou1000)+" thousand";
			
			num=numbers1[shou1000]+" thousand and "+underThree(amari1000);
			return num;
		}
	}
}
