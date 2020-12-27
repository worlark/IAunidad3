/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iaunidad3;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author PinkyStyle
 */
public class NaiveBayes {

    private ReadFile reader;
    private ArrayList<FrequencyTable> tables;

    public NaiveBayes() throws FileNotFoundException {
        //Create a Reader object and give it the dataset.
        this.reader = new ReadFile("breast-cancer-wisconsin.data");
        //Initialize the List
        this.tables = new ArrayList<>();
    }

    public void createTables(){
        //Create the different tables for each variable
        FrequencyTable clumpThickness = new FrequencyTable("Clump Thickness", this.reader.getClumpThickness(), this.reader.getClasses());
        FrequencyTable uniformityOfCellSize  = new FrequencyTable("Uniformity of Cell Size", this.reader.getUniformityOfCellSize(), this.reader.getClasses());
        FrequencyTable uniformityOfCellShape  = new FrequencyTable("Uniformity of Cell Shape", this.reader.getUniformityOfCellShape(), this.reader.getClasses());
        FrequencyTable marginalAdhesion  = new FrequencyTable("Marginal Adhesion", this.reader.getMarginalAdhesion(), this.reader.getClasses());
        FrequencyTable singleEpithelialCellSize  = new FrequencyTable("Single Eputhelial Cell Size", this.reader.getSingleEpithelialCellSize(), this.reader.getClasses());
        FrequencyTable bareNuclei = new FrequencyTable("Bare Nuclei", this.reader.getBareNuclei(), this.reader.getClasses());
        FrequencyTable blandChromatin  = new FrequencyTable("Bland Chromatin", this.reader.getBlandChromatin(), this.reader.getClasses());
        FrequencyTable normalNucleoli  = new FrequencyTable("Normal Nucleoli", this.reader.getNormalNucleoli(), this.reader.getClasses());
        FrequencyTable mitoses = new FrequencyTable("Mitoses", this.reader.getMitoses(), this.reader.getClasses());

        //Store the tables in a List to make them easy to manage
        this.tables.add(clumpThickness);
        this.tables.add(uniformityOfCellSize);
        this.tables.add(uniformityOfCellShape);
        this.tables.add(marginalAdhesion);
        this.tables.add(singleEpithelialCellSize);
        this.tables.add(bareNuclei);
        this.tables.add(blandChromatin);
        this.tables.add(normalNucleoli);
        this.tables.add(mitoses);
    }

    public String calculateProbability(int[] newData){
        //Calculate the probability for each variable and then return the final result
        double result = 0;
        for(int i = 0; i < this.tables.size(); i++){
            String prob = this.tables.get(i).getProbability(newData[i]);
            double x = Double.parseDouble(prob);
            result +=x/9;
        }
        return Double.toString(result);
    }

    //GETTERS AND SETTERS
    
    public ReadFile getReader() {
        return reader;
    }

    public void setReader(ReadFile reader) {
        this.reader = reader;
    }

    public ArrayList<FrequencyTable> getTables() {
        return tables;
    }

    public void setTables(ArrayList<FrequencyTable> tables) {
        this.tables = tables;
    }
}
