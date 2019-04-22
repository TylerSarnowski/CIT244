/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inclass;

/**
 *
 * @author tyler
 */
public class radix {
    
    public static void main(String[] args){
        int[] mainList = new int[1000];
        int[][] sortList = new int[1000][1000];
        int[][] finalList = new int[1000][1000];
        int temp;
        Long time1,time2;
        
        time1 = java.time.Instant.now().toEpochMilli();
        for(int i = 0;i<1000;i++){
            mainList[i] = (int) (Math.random()*10000);
        }

        for(int i = 0;i<mainList.length;i++){
            temp = (mainList[i]%10);
            sortList[temp][i] = mainList[i];
        }
        
        for(int i = 0;i<1000;i++){
            for(int t = 0;t<1000;t++){
                if(sortList[i][t] != 0){
                    temp = (int)(sortList[i][t]/10);
                    finalList[temp][i] = sortList[i][t];
                }
            }
        }
        
        for(int i = 0;i<1000;i++){
            for(int t = 0;t<1000;t++){
                if(finalList[i][t] != 0){
                    System.out.println(finalList[i][t]);
                }
            }
        }
        
        time2 = java.time.Instant.now().toEpochMilli();
        System.out.println(time2 - time1);
    }
    
}
