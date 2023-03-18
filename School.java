//Each school object has attributes for all data asked in questions



import java.util.*;
class School{

    private double[] raceRatio = new double[5];
    private double males, greekParticipation, finNeedMet,size, studentToFacRatio, undergrads;
    private String name;

    public School(String name, HashMap<String,Double> inputs){
        this.name = name;
        size = inputs.get("Size");
        males = inputs.get("Males");
        // females = inputs.get("Females");
        raceRatio[0] = inputs.get("Hispanics");
        raceRatio[1] = inputs.get("BlacksOrAA");
        raceRatio[2] = inputs.get("Asians");
        raceRatio[3] = inputs.get("PacificIslanders");
        raceRatio[4] = inputs.get("TwoOrMoreRaces");
        undergrads = inputs.get("Undergrads");
        // grads = inputs.get("Grads");
        greekParticipation = inputs.get("GreekLifeParticipation");
        finNeedMet = inputs.get("FinNeedMet");
        studentToFacRatio = inputs.get("StudentsPerFaculty");

    }

    public String getName(){
        return name;
    }

    public int getSize(){
        return (int)size;
    }

    public double getPercentMales(){
        return males / size;
    }

    public double[] getRaceProportions(){
        double[] arr = new double[5];
        for(int i=0;i<raceRatio.length;i++){
            arr[i] = raceRatio[i]/size;
        }
        return arr;
    }

    public double getUndergradRatio(){
        return undergrads/size;
    }

    public double getGreekLifePercentage(){
        return greekParticipation;
    }

    public double getFinNeedMet(){
        return finNeedMet;
    }

    public int getStudentToFacRatio(){
        return (int)studentToFacRatio;
    }






}