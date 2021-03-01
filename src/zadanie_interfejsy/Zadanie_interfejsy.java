/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadanie_interfejsy;

import java.io.IOException;
import java.nio.CharBuffer;

/**
 *
 * @author Kamil
 */
public class Zadanie_interfejsy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Okrag o = new Okrag(0,0,3);
       Prostokat p = new Prostokat(0,0,5,6);
       
        System.out.println("Pole o: "+o.pole());
        System.out.println("Pole p: "+ p.pole());
        System.out.println("o > p: " +o.isLargerThan(p));
        System.out.println("p > o: "+p.isLargerThan(o));
        
        Okrag o1 = new Okrag(0,0,6);
        Prostokat p1 = new Prostokat(0,0,2,1);
        System.out.println("o1 > p1 " +o1.isLargerThan(p1));
        
    }

    
    
}

interface Relatable{
    public int isLargerThan(Relatable other);
    
}
 abstract class Figura implements Relatable{
    int x;
    int y;

    public Figura(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    abstract double pole();
        
}

class Okrag extends Figura{
    double r;
    Okrag(int x, int y,double r){
        super(x,y);
        this.r = r;
    }
    public double pole(){
        return Math.PI*r*r;
    }
    
    
    
    public int isLargerThan(Relatable other){
        Prostokat p = (Prostokat)other;
        if(this.pole() < p.pole())
        return -1;
        else if(this.pole()> p.pole())
            return 1;
        else return 0;
    }

    
    
}

class Prostokat extends Figura{
    double a;
    double b;

    public Prostokat(int x, int y, double a, double b) {
        super(x,y);
        this.a = a;
        this.b = b;
    }
    
    
    double pole() {
        return a*b;
    }

    public int isLargerThan(Relatable other){
        Okrag o = (Okrag)other;
        if(this.pole() < o.pole())
            return -1;
        else if(this.pole()> o.pole())
            return 1;
        else 
            return 0;
            
    }

   
    
    
}