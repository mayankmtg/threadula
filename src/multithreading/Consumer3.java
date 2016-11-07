/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

/**
 * @author mayank   2015056
 * @author aman     2015012
 */
import java.util.ArrayList;
import java.util.Random;

public class Consumer3 implements Runnable {
    private Dataset drop;

    public Consumer3(Dataset drop) {
        this.drop = drop;
    }

    public void run() {
        //System.out.println("Temperature data:");
        float avg=0;
        float sum=0;
        for (ArrayList<Float> temp = drop.take(3);temp.size()!=1;temp = drop.take(3)) {
            for(int i=1;i<temp.size();i++){
                sum+=temp.get(i);
            }
            avg=sum/100;
            sum=0;
            Multithreading.display.avg=avg;
            //System.out.format("Avg for dataset "+ Math.round(temp.get(0))+ " is: %f\n", avg);
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//            }
        }
        //System.out.println("c3e");
    }
}