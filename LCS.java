//Longest Common Subsequence
//Kristopher Price

import java.util.Scanner;
public class LCS {
	
	public static int  c[][];
	public static char b[][];
	public static char x[];
	public static char y[];
	public static char lcsax[];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Input a sequence of characters");
		String sequence = sc.next();
		System.out.println("Input another sequence of characters");
		String sequence2 = sc.next();
		
		c = new int[sequence.length()+1][sequence2.length()+1];
		b = new char[sequence.length()+1][sequence2.length()+1];
		
		LongestCommonSubsequence(sequence, sequence2);
		
		System.out.print("   ");
		for(int i = 0; i < sequence2.length() + 1; i++){
			System.out.print(y[i]);
			System.out.print("  ");	
		}
		for(int i = 0; i < sequence.length()+1; i++){
			System.out.println();
			System.out.print(x[i] + " ");	
			for(int j = 0; j < sequence2.length()+1; j++){/*won't print right number of rows and columns*/
				System.out.print(b[i][j]);
				System.out.print( c[i][j]);
				System.out.print(" ");				
			}
		}
		System.out.println();
		
	//	System.out.println(new String(x));
		
		int lcslength = 0;//initialize length variable
		lcslength = lcs();//calls lcs() method, sets length variable equal to the length returned by it
		System.out.println();
		System.out.println("The longest common sub sequence length is " + lcslength);//print lcs
		System.out.println();
		System.out.print("The longest common sub sequence is ");
		for(int i = 0; i < lcsax.length; i++){
			if(lcsax[i] > '0')
			System.out.print(lcsax[i]);
			}	
		
		
		sc.close();
	}
	
	private static int lcs(){/*reads the characters in b[][] to determine the lcs*/
		
		char lcs [] = new char[y.length];//characters are read from last to first into this array
		int count = 0;//counts the length of the lcs
		
		
			for(int i = x.length-1; i >= 1;){//nested for loop with length and height of table
				for(int j = y.length-1; j >= 1;){
					if(b[i][j] == '\\'){//if this character is encountered
						//System.out.print(b[i][j]);
						//System.out.print(c[i][j]);
						lcs[i] = x[i];//read the corresponding matching letters into the array
						//System.out.println(lcs[i]);
						i -= 1; //go to the left
						j -= 1;//go up
						count++;//increments count
						if(c[i][j] == 1){
							break;
						}
					}
					else if (b[i][j] == '<'){//if this character is read
						//System.out.print(b[i][j]);
						//System.out.println(c[i][j]);
						j-=1;//go to the left
						
					}
					else if(b[i][j] == '^'){//if this character is read
						//System.out.print(b[i][j]);
						//System.out.println(c[i][j]);
						i -= 1;//go up
						
					}
					else
						break;	//no more characters to read
					
					}
			}
			 
			lcsax = new char[lcs.length];//initialize character array
			for(int i = lcs.length-1; i >= 0; i--){
				lcsax[i] = lcs[i];//reads the characters from last to first into array		
			}
			
			return count;//returns lcs length
	}

	private static void LongestCommonSubsequence(String sequence, String sequence2)/*loops through each string to find the longest common sequence of characters*/ {

		int m = sequence.length();
		int n = sequence2.length();
		
		x = new char[m+1];
		y = new char[n+1];
		
		x[0] = '.';//'.' doesnt really mean anything. it just exists to fill up space in the arrays
		y[0] = '.';
		b[0][0] = '.';
		
		for(int i = 0; i < m; i++){
			x[i+1] = sequence.charAt(i);
			c[i+1][0] = 0;
			b[i+1][0] = '.';
		}
		for(int j = 0; j < n; j++){
			y[j+1] = sequence2.charAt(j);
			c[0][j+1] = 0;
			b[0][j+1] = '.';
		}
		for(int i = 0; i < m+1; i++){//test if the char arrays contain the strings
		System.out.print(x[i]);
		}		
		System.out.println();
		for(int j = 0; j < n+1; j++){
			System.out.print(y[j]);
		}
		System.out.println();
		
		for(int i = 1; i < m+1; i++){
			for(int j = 1; j < n+1; j++){
				if(x[i] == y[j]){//if the characters match
					c[i][j] = c[i-1][j-1] +1;
					b[i][j] = '\\'; /*tells the program to look up and left */
				}
				else if(c[i-1][j] >= c[i][j-1]){//if the characters don't, and the value of the space above is greatest
					c[i][j] = c[i-1][j];
					b[i][j] = '^'; /*tells the program to look  up */
				}
				else{//if the characters don't, and the value of the space to the left is greatest
					c[i][j] = c[i][ j-1];
					b[i][j] = '<'; /*tells the program to look  left */
				}
			}/* end of inner for loop */
		}/* end of outer for loop */		
	} 
}
