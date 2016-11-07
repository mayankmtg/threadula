/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

/**
 *
 * @author mayank   2015056
 * @author aman     2015012
 */
import java.util.ArrayList;
import java.util.Random;

public class Consumer1 implements Runnable {
    private Dataset drop;

    public Consumer1(Dataset drop) {
        this.drop = drop;
    }

    public void run() {
        //System.out.println("c1s");
        float min=0;
        for (ArrayList<Float> temp = drop.take(1);temp.size()!=1;temp = drop.take(1)) {
            min=temp.get(1);
            for(int i=2;i<temp.size();i++){
                if(min>temp.get(i)){
                    min=temp.get(i);
                }
            }
            Multithreading.display.min=min;
            //System.out.format("Min for dataset "+ Math.round(temp.get(0))+ " is: %f\n", min);
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//            }
        }
    //System.out.println("c1e");
    }
    
}