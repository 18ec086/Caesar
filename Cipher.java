class Freq{
	private int n;
	private char c;
	Freq(int n,char c){
		this.n=n;
		this.c=c;
	}
}
class CaesarChiper{
	String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";//アルファベットの文字列
	char[] alpha = alphabet.toCharArray();//アルファベットの文字配列
	String alphabet2="EATIOSNRHLDCUMPFGYWBVKJXQZ";//頻度順のアルファベット
	String str;//暗号化された文字列
	char[] strChar;//ユーザーが入力する文字列
	char[] freqChar=alphabet2.toCharArray();//頻度のアルファベットのChar
	Freq[] freq;

	//コンストラクタ
	CaesarChiper(String str){
		this.str=str;
		this.str=this.str.toUpperCase().trim();
		strChar=this.str.toCharArray();
	}
	//---------シーザ暗号の暗号化復号化のメソッド群-----------
	//charはアルファベットかを確かめる。
	boolean isAlphabet(char c) {
		for(int i=0;i<26;i++) {
			if(c==freqChar[i])return true;
		}
		return false;
	}
	//n文字だけ後ろにずらしたもの(記号はそのまま)をString型で返却
	String shiftStr(int n) {
		String str1="";
		for(int i=0;i<strChar.length;i++){
			char c=' ';
			if(isAlphabet(strChar[i]))
				c=alpha[(alphabet.indexOf(strChar[i])+n)%26];
			else
				c=strChar[i];
			str1+=c;
		}
		str1.trim();
		return str1;
	}
	//----------シーザー暗号の暗号、復号化のメソッド群終了----------

	int countChar() {
		return 0;
	}
}


public class Cipher {
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String str ="twitter";
        CaesarChiper a =new CaesarChiper(str);
        for(int i=0;i<26;i++) {
        	System.out.println(a.shiftStr(i));
        }
        System.out.println("--完了--");

	}
}
