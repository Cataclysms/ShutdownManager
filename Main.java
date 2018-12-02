import java.lang.Runtime;
import java.util.Scanner;
import java.io.IOException;

class Main{

	public static void main(String args[]){
		Menu();
	}

	public static void Menu(){
		String version = "Ver0.1\n";
		System.out.println("#####################################\n"+"Shutdown Manager by NX "+version+"実行したい番号を入力 |\n 0:シャットダウン \n1:再起動 \n2:タイマーシャットダウン　\n3:予約したタイマーをリセット\n"+"#####################################");
		int number = new java.util.Scanner(System.in).nextInt();
			switch(number){
				case 0:
				try{ 
					Runtime.getRuntime().exec("shutdown /s /t 0");
				}catch(IOException e){
					e.printStackTrace();
				} 
				break;
				case 1:
				try{ 
					Runtime.getRuntime().exec("shutdown /r /t 0");
				}catch(IOException e){
					e.printStackTrace();
				} 
				break;
				case 2:
				try{ 
					System.out.print("タイマーをセットしてください(分)");
					int timer = new java.util.Scanner(System.in).nextInt();
					Runtime.getRuntime().exec("shutdown /s /t "+timer*60);
					System.out.println("予約を追加しました\n"+"デバイスは"+timer+"分後にシャットダウンされます\n");
					Menu();
				}catch(IOException e){
					e.printStackTrace();
				} 
				break;
				case 3:
				try{ 
					Runtime.getRuntime().exec("shutdown -a");
					System.out.print("予定されていたシャットダウンを取り消しました。\n");
					Menu();
				}catch(IOException e){
					e.printStackTrace();
				} 
				break;
				default:
				System.out.println("不正な値です");
				break;
			}
	}
}