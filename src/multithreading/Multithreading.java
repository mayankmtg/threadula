/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

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
        
        (new Thread(new Producer1(drop))).start();
        (new Thread(new Consumer1(drop))).start();
        (new Thread(new Consumer2(drop))).start();
        (new Thread(new Consumer3(drop))).start();
    }
}
