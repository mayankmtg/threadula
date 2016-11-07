/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

/**
 *
 * @author mayank
 */
import java.util.ArrayList;
import java.util.Random;

public class Consumer2 implements Runnable {
    private Dataset drop;

    public Consumer2(Dataset drop) {
        this.drop = drop;
    }

    public void run() {
        //System.out.println("c2s");
        float max=0;
        for (ArrayList<Float> temp = drop.take(2);temp.size()!=1;temp = drop.take(2)) {
            max=temp.get(1);
            for(int i=2;i<temp.size();i++){
                if(max<temp.get(i)){
                    max=temp.get(i);
                }
            }
            System.out.format("Max for dataset "+ Math.round(temp.get(0))+ " is: %f\n", max);
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//            }
              
        }
    //System.out.println("c2e");
    }
}