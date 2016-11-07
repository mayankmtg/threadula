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
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class Producer3 implements Runnable {
    private Dataset drop;

    public Producer3(Dataset drop) {
        this.drop = drop;
    }
    public void run() {
         System.out.println("p3s");
         ArrayList<Float> big = new ArrayList();
         ArrayList<Float> small = new ArrayList();
            try{
            BufferedReader in = new BufferedReader(new FileReader("humidity"));
            String line;
            //int ind=0;
            while((line = in.readLine()) != null){
                if(line.length()>0)
                {
                    big.add(Float.parseFloat(line));
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
//        for(int i=0;i<big.size();i++){
//            System.out.println(big.get(i));
//        }
        for (int i = 0; i < 5;i++) {
            small.removeAll(small);
            for(int j=i*100;j<i*100+100;j++){
                small.add((big.get(j)));
            }
            //System.out.println(small);
            small.add(0,(float)(30+i+1));
            drop.put(small);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            System.out.println("producer_exception");}
        }
        small.removeAll(small);
        small.add(3.14f);
        drop.put(small);
        System.out.println("p3e");
    }
}