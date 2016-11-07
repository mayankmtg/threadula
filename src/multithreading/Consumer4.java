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

public class Consumer4 implements Runnable {
    private Dataset drop;

    public Consumer4(Dataset drop) {
        this.drop = drop;
    }

    public void run() {
        //System.out.println("Temperature data:");
        float predictSlope=0;
        float sum=0;
        for (ArrayList<Float> temp = drop.take(4);temp.size()!=1;temp = drop.take(4)) {
            for(int i=90;i<temp.size();i++){
                sum+=temp.get(i)-temp.get(i-1);
            }
            predictSlope=sum/100;
            predictSlope+=temp.get(temp.size()-1);
            sum=0;
            Multithreading.display.pre=predictSlope;
            //System.out.format("Pre for dataset "+ Math.round(temp.get(0))+ " is: %f\n", predictSlope);
            System.out.printf("%s\n",Multithreading.display);

        }
    }
}