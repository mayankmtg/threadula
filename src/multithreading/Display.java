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
public class Display {
    public float min;
    public float max;
    public float avg;
    public float pre;
    public int ind;
    @Override
    public String toString(){
        String s="Maximum for dataset "+ind+": "+max;
        s+="\nMinimum for dataset "+ind+": "+min;
        s+="\nAverage for dataset "+ind+": "+avg;
        s+="\nPrediction for dataset "+(int)ind+": "+pre;
        return s;
    }
}
