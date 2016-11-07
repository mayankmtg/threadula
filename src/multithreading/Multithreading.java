/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mayank   2015056
 * @author aman     2015012
 */
public class Multithreading {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Dataset drop = new Dataset();
        ArrayList<Thread> Producers = new ArrayList();
        Thread c1=new Thread(new Consumer1(drop));
        Thread c2=new Thread(new Consumer2(drop));
        Thread c3=new Thread(new Consumer3(drop));
        Thread p1=new Thread(new Producer1(drop));
        Thread p2=new Thread(new Producer2(drop,p1));
        Thread p3=new Thread(new Producer3(drop,p1,p2));
        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
        c3.start();
    }
}
