package com.lcs;
import java.lang.String;
import java.lang.Math;
public class LCS {
	public static void getLCS2(String x, String y){
		int M = x.length();
		int N = y.length();
		
		//opt[i][j] = length of LCS of x[i..M] and y[j..N]
		int [][]opt = new int[M+1][N+1];
		
		//compute length of LCS and all subproblems via dynamic programming
		for (int i = M-1; i >= 0; i--){
			for (int j = N-1;j >= 0; j--){
				if (x.charAt(i) == y.charAt(j))
					opt[i][j] = opt[i+1][j+1] + 1;
				else
					opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
			}
		}
		
		//recover LCS itself and print it to standard output
		int i = 0; 
		int j = 0;
		while(i < M && j < N){
			if (x.charAt(i) == y.charAt(j)){
				System.out.print(x.charAt(i));
				i++;
				j++;
			}
			else if (opt[i+1][j] >= opt[i][j+1]) i++;
			else 								 j++;
		}
		System.out.println();
	}
	public static void getLCS3(String x, String y, String z){
		int M = x.length();
		int N = y.length();
		int O = z.length();
		
		int [][][]opt = new int [M+1][N+1][O+1];
		
		for (int i = M-1; i >=0; i--) {
			for (int j = N-1; j >= 0; j--) {
				for (int l = O-1; l >= 0; l--) {
						if ((x.charAt(i)==y.charAt(j))&&(x.charAt(i)==z.charAt(l))) {
							opt[i][j][l] = opt[i+1][j+1][l+1] + 1;
						}
						else if ((x.charAt(i)==y.charAt(j))&&(x.charAt(i)!=z.charAt(l))) {
							opt[i][j][l] = Math.max(opt[i+1][j+1][l], opt[i][j][l+1]);
						} else if ((x.charAt(i)==z.charAt(l))&&(x.charAt(i)!=y.charAt(j))){
							opt[i][j][l] = Math.max(opt[i+1][j][l+1], opt[i][j+1][l]);
						}else if ((x.charAt(i)!=y.charAt(j))&&(y.charAt(j)==z.charAt(l))){
							opt[i][j][l] = Math.max(opt[i+1][j][l], opt[i][j+1][l+1]);
						}else{
							//opt[i][j][l] = opt[i+1][j+1][l+1];
							opt[i][j][l] = Math.max(Math.max(opt[i+1][j+1][l], opt[i+1][j][l+1]),
									opt[i][j+1][l+1]);
						}
					}
				}
			}
		
		int i = 0;
		int j = 0;
		int l = 0;
		while (i < M && j < N &&l < O){
				if ((x.charAt(i)==y.charAt(j))&&(x.charAt(i)==z.charAt(l))) {
					System.out.print(x.charAt(i));
					i++; j++; l++;
				}else if ((x.charAt(i)==y.charAt(j))&&(x.charAt(i)!=z.charAt(l))) {
					if (opt[i+1][j+1][l] >= opt[i][j][l+1]) {
						i++;j++;
					}else {
						l++;
					}
				} else if ((x.charAt(i)==z.charAt(l))&&(x.charAt(i)!=y.charAt(j))){
					if (opt[i+1][j][l+1] >= opt[i][j+1][l]) {
						i++;l++;
					}else {
						j++;
					}					
				}else if ((x.charAt(i)!=y.charAt(j))&&(y.charAt(j)==z.charAt(l))){
					if (opt[i][j+1][l+1] >= opt[i+1][j][l]) {
						j++;l++;
					}else {
						i++;
					}	
				}else{
					if ((opt[i+1][j+1][l] >= opt[i+1][j][l+1])&&(opt[i+1][j+1][l] >= opt[i][j+1][l+1])) {
						i++;j++;
					}else if ((opt[i+1][j][l+1] >= opt[i+1][j+1][l])&&(opt[i+1][j][l+1] >= opt[i][j+1][l+1])){
						i++;l++;
					}else{
						j++;l++;
					}
				}
			}
		System.out.println();
	}
}
