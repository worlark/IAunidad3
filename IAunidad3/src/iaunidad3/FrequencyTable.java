/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iaunidad3;

/**
 *
 * @author PinkyStyle
 */
public class FrequencyTable {

    //Name of the table/variable
    private String name;
    // Quantity of cases that have breast cancer, given the specific value (position 0 value 1, position 1 value 2, ..., position 9 value 10)
    private int[] positiveValues;
    // Quantity of cases that do not have breast cancer, given the specific value (position 0 value 1, position 1 value 2, ..., position 9 value 10)
    private int[] negativeValues;
    private int total;

    public FrequencyTable(String name, double[] data, double[] cases){
        this.name = name;
        this.positiveValues = new int[10];
        this.negativeValues = new int[10];
        this.total = 0;
        this.populateTable(data, cases);
    }

    public String getProbability(int value){  
        //We calculate the pobability of being a positive case, given a specific value for the variable and return it
        double x = (double) this.positiveValues[value-1]/(this.positiveValues[value-1]+this.negativeValues[value-1]) ;
        //if the frequency is not a number (for example we have 0 cases with a specific value) we replace the probability with 0
        if(Double.isNaN(x)){
            x = 0;
        }
        String valor = Double.toString(x);
        return valor;
    }

    public void populateTable(double[] data, double[] cases){
        //To populate the table, we first filter with the specific value of the variable to determinate the position
        //Then, we ask if it's a positive/negative case.
        //Depending of this, we add +1 to the specific position, on the specific list.
        for( int i = 0; i < data.length; i++){
            switch( (int)data[i]){
                case 1:
                    if(cases[i] == 2){
                        this.negativeValues[0]+=1;
                    }
                    else{
                        this.positiveValues[0]+=1;
                    }
                    break;
                case 2:
                    if(cases[i] == 2){
                        this.negativeValues[1]+=1;
                    }
                    else{
                        this.positiveValues[1]+=1;
                    }
                    break;
                case 3:
                    if(cases[i] == 2){
                        this.negativeValues[2]+=1;
                    }
                    else{
                        this.positiveValues[2]+=1;
                    }
                    break;
                case 4:
                    if(cases[i] == 2){
                        this.negativeValues[3]+=1;
                    }
                    else{
                        this.positiveValues[3]+=1;
                    }
                    break;
                case 5:
                    if(cases[i] == 2){
                        this.negativeValues[4]+=1;
                    }
                    else{
                        this.positiveValues[4]+=1;
                    }
                    break;
                case 6:
                    if(cases[i] == 2){
                        this.negativeValues[5]+=1;
                    }
                    else{
                        this.positiveValues[5]+=1;
                    }
                    break;
                case 7:
                    if(cases[i] == 2){
                        this.negativeValues[6]+=1;
                    }
                    else{
                        this.positiveValues[6]+=1;
                    }
                    break;
                case 8:
                    if(cases[i] == 2){
                        this.negativeValues[7]+=1;
                    }
                    else{
                        this.positiveValues[7]+=1;
                    }
                    break;
                case 9:
                    if(cases[i] == 2){
                        this.negativeValues[8]+=1;
                    }
                    else{
                        this.positiveValues[8]+=1;
                    }
                    break;
                case 10:
                    if(cases[i] == 2){
                        this.negativeValues[9]+=1;
                    }
                    else{
                        this.positiveValues[9]+=1;
                    }
                    break;
                default:
                    break;
            }
            this.total+=1;
        }
    }

    //GETTERS AND SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getPositiveValues() {
        return positiveValues;
    }

    public void setPositiveValues(int[] positiveValues) {
        this.positiveValues = positiveValues;
    }

    public int[] getNegativeValues() {
        return negativeValues;
    }

    public void setNegativeValues(int[] negativeValues) {
        this.negativeValues = negativeValues;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
}
