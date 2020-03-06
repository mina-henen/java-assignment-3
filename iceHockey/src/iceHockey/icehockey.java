package iceHockey;

import java.awt.Point;

public class icehockey implements IPlayersFinder  {
	public char[][] toCharArray(String[] photo){
		char[][] a=new char[photo.length][photo[0].toCharArray().length];
        for(int i=0;i<photo.length;i++){
            a[i]=photo[i].toCharArray();
        }
        return a;
	}
	public  boolean recursivefinder(char[][] arr,int[][]  coo,int y,int x,int i,char toBeFound){
        if(arr[y][x]==toBeFound){
            if(coo[y][x]==0){
                coo[y][x]=i;
                if(y+1<arr.length) {
                	recursivefinder(arr, coo, y + 1, x, i, toBeFound);
                }
                if(y-1>-1) {
                	recursivefinder(arr, coo, y - 1, x, i, toBeFound);
                }
                if(x+1<arr[y].length) {
                	recursivefinder(arr, coo, y, x+1, i, toBeFound);
                }
                if(x-1>-1) {
                	recursivefinder(arr, coo, y , x-1, i, toBeFound);
                }
                return true;

            }

        }

        return false;

    }
	public  void  sortting(int a[][]){
        int temp;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length-1-i;j++){
                if(a[j][0]>a[j+1][0]){
                    temp=a[j][0];
                    a[j][0]=a[j+1][0];
                    a[j+1][0]=temp;
                    temp=a[j][1];
                    a[j][1]=a[j+1][1];
                    a[j+1][1]=temp;
                }
                else if(a[j][0]==a[j+1][0]){
                    if(a[j][1]>a[j+1][1]){
                        temp=a[j][0];
                        a[j][0]=a[j+1][0];
                        a[j+1][0]=temp;
                        temp=a[j][1];
                        a[j][1]=a[j+1][1];
                        a[j+1][1]=temp;
                    }
                }
            }
        }

    }

	@Override
	public Point[] findPlayers(String[] photo, int team, int threshold) {
		// TODO Auto-generated method stub
		char[][] arr=new char[photo.length][photo[0].toCharArray().length];
		arr= toCharArray(photo);
		char toBeFound=(char)(48+team);
		int[][] coo=new int[arr.length][arr[0].length];
        int i=1;
        for(int y=0;y<arr.length;y++){
            for(int x=0;x<arr[0].length;x++){
                if(recursivefinder(arr, coo, y  , x, i, toBeFound)){
                    i++;
                }
            }
        }
        int[]available=new int[i+1];
        for(int k=0;k<=i;k++) {
        	available[k]=k;
        	}
        int flag=0,count;
        for(int k=1;k<=i;k++) {
        	count=0;
            for (int z = 0; z < coo.length; z++) {
                for (int j = 0; j < coo[z].length; j++) {
                    if(coo[z][j]==k){count++;}
                    if(flag==1){
                    	if(coo[z][j]==k-1){
                    		coo[z][j]=0;
                    		}
                    	}

                }
            }
            if(count*4<threshold){
            	flag=1;
            	if(k!=i){
            		available[k]=0;
            		}
            	}
            else {
            	flag=0;
            	}
        }
        count=0;
        for(int k=0;k<i;k++) {if(available[k]!=0){count++;}}
        int[][]points=new int[count+1][2];
        int index=0;
        for(int k=1;k<=i;k++) {
        	if(available[k]==0){
        		continue;
        		}
            int largestx=0,largesty=0,smallestx=coo[0].length,smallesty=coo.length;
            for (int z = 0; z < coo.length; z++) {
                for (int j = 0; j < coo[z].length; j++) {
                    if(coo[z][j]==k){
                        if(j>largestx){
                        	largestx=j;
                        	}
                        if(z>largesty){
                        	largesty=z;
                        	}
                        if(j<smallestx){
                        	smallestx=j;
                        	}
                        if(z<smallesty){
                        	smallesty=z;
                        	}

                    }
                }

            }
            points[index][0]=smallestx+largestx+1;
            points[index][1]=smallesty+largesty+1;
            index++;
        }
        int[][]pts=new int[points.length-1][2];
        for(int j=0;j<pts.length;j++){
            pts[j]=points[j];
        }
        points=pts;
        sortting(points);
        java.awt.Point[] p=new java.awt.Point[points.length];
        for (int z=0;z<points.length;z++){
            p[z]=new java.awt.Point();
            p[z].x=points[z][0];
            p[z].y=points[z][1];
        }

        return p;
    }
		

}
