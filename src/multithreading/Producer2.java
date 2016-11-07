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
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer2 implements Runnable {
    private Dataset drop;
    private Thread p1;
    public Producer2(Dataset drop, Thread p1) {
        this.drop = drop;
        this.p1=p1;
    }
    public void run() {
        try {
            p1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Producer2.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Humidity data: ");
        
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
            small.add(0,(float)(i+1));
            Multithreading.display.ind=i+1;
            drop.put(small);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            System.out.println("producer_exception");}
        }
        small.removeAll(small);
        small.add(3.14f);
        //drop.put(small);
        
        drop.empty1=true;
        drop.empty2=true;
        drop.empty3=true;
        drop.empty4=true;
        System.out.println("Humidity data Closed.\n");

    }
}
