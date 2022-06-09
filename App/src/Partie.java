import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.swing.text.html.HTMLDocument.BlockElement;

public class Partie implements Serializable {


    Case[] plateau = new Case[100];
    private int position;
    private int Score;
    
    public Partie() {
        this.position = 0;
        setScore(0);
        generatePlateau();
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        this.Score = score;
    }

    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        if (position < 0) {
            this.position = 0;
        } else if (position > 99) {
             this.position =  99  -  (position - 99);
          } else {
            this.position = position ;
          }

    }
    public void generatePlateau() {
        int index;
        int[] indexTable = new int[25];
        plateau[0]= new CaseDepart();
        plateau[99]= new CaseFin();
        for (int i = 0; i < indexTable.length; i++) {
            index=(int)(1+Math.random()*98);
            while(rechercher(indexTable, index)){
                index=(int)(1+Math.random()*98);
            }
            indexTable[i]=index;
            if (i<5) plateau[index] = new CaseImage();
            else if(i<10) plateau[index] = new CaseDefinition();
            else if (i<15) plateau[index] = new CaseSaut();
            else if (i <20) plateau[index] = new CaseBonus();
            else plateau[index] = new CaseMalus();
        }
        for (int i = 1; i < plateau.length-1; i++) {
            if (!rechercher(indexTable, i)) plateau[i]=new CaseParcours();
        }

    }
    public void afficherPlateau(){
        for (int i = 0; i < plateau.length; i++) {
            System.out.println(plateau[i].color+" ......"+i);
        }
    }
    public boolean rechercher(int[] array,int value){
        for (int i : array) {
            if (i == value) return true;
        }
        return false;
    }


    
}
