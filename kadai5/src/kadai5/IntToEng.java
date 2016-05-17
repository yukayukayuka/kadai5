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
		else if(n<=999)return underThree(n);//hundred
		else if(n<=999999)return underMillion(n);//thousand
		else if(n<=999999999)return underBillion(n);//million
		else if(n<=2147483647)return underTenBillion(n);
		else{
			//一応書いたけど、意味なし
			return "over integer";
		}

    }
	static String underTwo(int n){//nは二桁の整数
		if(n<=19)return numbers1[n];
		else{
			int shou=n/10;
			int amari=n%10;
			if(amari==0)return numbers10[shou];
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
	static String underMillion(int n){//nは４桁の整数
		if(n<=999)return underThree(n);
		else{
			int shou1000=n/1000;			
			int amari1000=n%1000;//amari100は下二桁
			
			//キリ番
			if(amari1000==0 && shou1000<=9)return numbers1[shou1000]+" thousand";
			else if(amari1000==0 && shou1000<=99)return underTwo(shou1000)+" thousand";
			else if(amari1000==0 && shou1000<=999)return underThree(shou1000)+" thousand";
			
			//そのた
			if(shou1000<=19)return numbers1[shou1000]+" thousand"+underThree(amari1000);
			else if(shou1000<=99)return underTwo(shou1000)+" thousand"+underThree(amari1000);
			else if(shou1000<=999)return underThree(shou1000)+" thousand and "+underThree(amari1000);
			
			num=numbers1[shou1000]+" thousand and "+underThree(amari1000);
			return num;
		}
	}
	static String underBillion(int n){
		int shouM=n/1000000;
		int amariM=n%1000000;
		
		//キリ番
		if(amariM==0 && shouM<=9)return numbers1[shouM]+" million";
		else if(amariM==0 && shouM<=99)return underTwo(shouM)+" million";
		else if(amariM==0 && shouM<=999)return underThree(shouM)+" million";
		
		//そのた
		if(shouM<=19)return numbers1[shouM]+" million"+underMillion(amariM);
		else if(shouM<=99)return underTwo(shouM)+" million"+underMillion(amariM);
		else if(shouM<=999)return underThree(shouM)+" million and "+underMillion(amariM);
		
		return num;
	}
	static String underTenBillion(int n){
		int shouB=n/1000000000;
		int amariB=n%1000000000;
		
		//キリ番
		if(amariB==0 && shouB<=9)return numbers1[shouB]+" billion";
		else if(amariB==0 && shouB<=99)return underTwo(shouB)+" billion";
		else if(amariB==0 && shouB<=999)return underThree(shouB)+" billion";
		
		//そのた
		if(shouB<=19)return numbers1[shouB]+" billion and "+underBillion(amariB);
		else if(shouB<=99)return underTwo(shouB)+" billion and "+underBillion(amariB);
		else if(shouB<=999)return underThree(shouB)+" billion and "+underBillion(amariB);
		
		return"num";
	}
}
