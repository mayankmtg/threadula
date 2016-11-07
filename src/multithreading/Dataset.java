/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

import java.util.ArrayList;

/**
 *
 * @author mayank
 */
public class Dataset {
    // Message sent from producer
    // to consumer.
    private ArrayList<Float> message;
    
    // True if consumer should wait
    // for producer to send message,
    // false if producer should wait for
    // consumer to retrieve message.
    private boolean empty1 = true;
    private boolean empty2 = true;
    private boolean empty3 = true;
    
    public synchronized ArrayList<Float> take(int index) {
        // Wait until message is
        // available.
        if(index==1){
            while (empty1) {
                try {
                    wait();
                } catch (InterruptedException e) {}
            }
            // Toggle status.
            empty1 = true;    
        }
        else if(index==2){
            while (empty2) {
                try {
                    wait();
                } catch (InterruptedException e) {}
            }
            // Toggle status.
            empty2 = true;    
        }
        else if(index==3){
            while (empty3) {
                try {
                    wait();
                } catch (InterruptedException e) {}
            }
            // Toggle status.
            empty3 = true;    
        }
        // Notify producer that
        // status has changed.
        notifyAll();
        return message;
        
    }
    public synchronized void put(ArrayList<Float> message) {
        // Wait until message has
        // been retrieved.
        while (!empty1 || !empty2 || !empty3) {
            try { 
                wait();
            } catch (InterruptedException e) {}
        }
        
        // Toggle status.
        empty1 = false;
        empty2=false;
        empty3=false;
        // Store message.
        this.message = message;
        // Notify consumer that status
        // has changed.
        notifyAll();
    }
}
