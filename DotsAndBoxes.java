package project;
import java.util.*;

public class DotsAndBoxes {
	
	public static void TableDesign(int n, String [][]arr) {
        for(int i=0;i<2*n+1;i++) {
            for(int j=0;j<2*n+1;j++) {
                System.out.print(arr[i][j]+"  ");
            }
            System.out.println("");
        }
	}
	
	
	public static boolean checkIfDone(int n, String [][]arr,int i,int j) {
		if(arr[i-1][j]=="-"&&arr[i+1][j]=="-"&&arr[i][j-1]=="-"&&arr[i][j+1]=="-") {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean checkUp(int n, String [][]arr,int i,int j) {
		if(i-2>0) {
			i=i-2;
			return checkIfDone(n,arr,i,j);
		}else {
			return false;
		}
		
	}
	
	public static boolean checkDown(int n, String [][]arr,int i,int j) {
		
		if(i+2<2*n+1) {
			i=i+2;
			return checkIfDone(n,arr,i,j);
		}else {
			return false;
		}
	}
	
	public static boolean checkRight(int n, String [][]arr,int i,int j) {
		
		if(j+2<2*n+1) {
			j=j+2;
			return checkIfDone(n,arr,i,j);
		}else {
			return false;
		}
	}
	
	public static boolean checkLeft(int n, String [][]arr,int i,int j) {
		
		if(j-2>0) {
			j=j-2;
			return checkIfDone(n,arr,i,j);
		}else {
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		
		Scanner Scan = new Scanner(System.in);
		Scanner in = new Scanner(System.in);
		int n,i,j,a,k,flag;
		int activePlayer;
		activePlayer = 0;
		flag=0;
		a=0;
		String boxNo,boxPos;
		
		int[] player = new int[2];
		player[0]=0;
		player[1]=0;

		
		System.out.println("Choose the dimenssion of the game (from 1 to 6):");
		n = Scan.nextInt();
	
		String[][] arr = new String[2*n+1][2*n+1];
		String[] list = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9","0"};
		for(i=0;i<2*n+1;i++) {
			for(j=0;j<2*n+1;j++) {
				arr[i][j]= "*";
			}
		}
		for(i=1;i<2*n+1;i=i+2) {
			for(j=1;j<2*n+1;j=j+2) {
				arr[i][j]= list[a];                
				a++;
			}
		}
		
		TableDesign(n,arr);
		
		
		while(true) {
		System.out.println("Player "+Integer.toString(activePlayer+1)+" please select the box:");
		boxNo = in.nextLine();
		
		for(i=0;i<2*n+1;i++) {
			
			for(j=0;j<2*n+1;j++) {
				
				if(arr[i][j].equals(boxNo)) {
					System.out.println("Please select the side: u /d / l / r");
					boxPos = in.nextLine();
					
					if(boxPos.equals("u")&&!arr[i-1][j].equals("-")) {
						arr[i-1][j]="-";
					
						if(checkIfDone(n,arr,i,j)==true) {
							player[activePlayer]+=1;
							flag=1;
						}
						if(checkUp(n,arr,i,j)==true) {
							player[activePlayer]+=1;
							flag=1;
						}
					}
					
					if(boxPos.equals("d")&&!arr[i+1][j].equals("-")) {
						arr[i+1][j]="-";
					
						if(checkIfDone(n,arr,i,j)==true) {
							player[activePlayer]+=1;
							flag=1;
						}
						if(checkDown(n,arr,i,j)==true) {
							player[activePlayer]+=1;
							flag=1;
						}
					}
					
					if(boxPos.equals("r")&&!arr[i][j+1].equals("-")) {
						arr[i][j+1]="-";
					
						if(checkIfDone(n,arr,i,j)==true) {
							player[activePlayer]+=1;
							flag=1;
						}
						if(checkRight(n,arr,i,j)==true) {
							player[activePlayer]+=1;
							flag=1;
						}
					}
					
					if(boxPos.equals("l")&&!arr[i][j-1].equals("-")) {
						arr[i][j-1]="-";
					
						if(checkLeft(n,arr,i,j)==true) {
							player[activePlayer]+=1;
							flag=1;
						}
						if(checkIfDone(n,arr,i,j)==true) {
							player[activePlayer]+=1;
							flag=1;
						}
					}
				}
			}
		}
		
		TableDesign(n,arr);
		
		if(activePlayer==0 && flag==0) {
			activePlayer=1;
		}
		else if(activePlayer==1 && flag==0) {
			activePlayer=0;
		}
		
		
		flag=0;
		System.out.println("Player 1 Score: "+player[0]+" Player 2 Score:"+player[1]);
		}
	}

	
	
}
