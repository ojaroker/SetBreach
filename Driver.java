import java.util.*;
import java.io.File;
public class Driver {
    private School[] schools = new School[12]; //list of schools by #
    private int numQuestions = 7, numSchools=12;

    
    private void run(){
        
        try{
            File file = new File("Project/src/info.txt");
            Scanner scan = new Scanner(file);
            for(int num=1;num<=numSchools;num++){
                //maps category to value
                HashMap<String, Double> inputs = new HashMap<String, Double>();
                
                String name = scan.next();
                for(int i=0;i<13;i++){
                    inputs.put(scan.next() , scan.nextDouble());
                }
                schools[num-1] = new School(name,inputs); //creates school object with data
            }


            scan.close();
        } catch(Exception e){
            System.out.println(e);
        }

    }

    private void takeInput(){

        try{
            File file = new File("Project/src/answers.txt");
            Scanner scan = new Scanner(file);
            int[] answers = new int[numQuestions];
            
            //saves all the answers to array
            for(int i=0;i<numQuestions;i++){
                answers[i] = scan.nextInt();
            }

            rank(answers);

            scan.close();
        } catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    // adds up the difference in actual selection and answered selection for each school; ranks schools on points - lowest to highest
    private void rank(int[] answers){
        int[] points = new int[numSchools];
        for(int i=0;i<numSchools;i++){
            int currPoints=0;
            currPoints+=rankSize(answers[0],schools[i].getSize());
            currPoints+=rankMFRatio(answers[1], schools[i].getPercentMales());
            currPoints+=rankRaceRatio(answers[2], schools[i].getRaceProportions());
            currPoints+=rankUndergradRatio(answers[3], schools[i].getUndergradRatio());
            currPoints+=rankGreekLifePercent(answers[4], schools[i].getGreekLifePercentage());
            currPoints+=rankFinAid(answers[5], schools[i].getFinNeedMet());
            currPoints+=rankStudentFacRatio(answers[6], schools[i].getStudentToFacRatio());

            points[i] = currPoints;

        }
        // System.out.println("Points array: "+Arrays.toString(points));
        String[] rankings = rankSchools(points);
        // System.out.println("RANKINGS:\n"+Arrays.toString(rankings));
        printResults(rankings);

    }

    // returns the difference in answer selection and actual
    private int rankSize(int answer, int schoolSize){
        int actual=0;
        if(schoolSize>10000){
            actual=4;
        } else if(schoolSize>6000){
            actual=3;
        } else if(schoolSize>2500){
            actual=2;
        } else{
            actual=1;
        }
        return Math.abs(actual-answer);
    }

    private int rankMFRatio(int answer, double actualPercentMales){
        int actual=0;
        if(actualPercentMales>.54){
            actual=2;
        } else if(actualPercentMales<.54){
            actual=3;
        }  else{
            actual=1;
        }
        return Math.abs(actual-answer);

    }

    // if the school does not have the correct proportion, a 2 is returned
    private int rankRaceRatio(int answer, double[] actualProportions){
        if(actualProportions[answer] > .1){
            return 0;
        }
        return 2;
    }

    private int rankUndergradRatio(int answer, double undergradRatio){
        int actual=0;
        if(undergradRatio>.9){
            actual=1;
        } else if(undergradRatio>.8){
            actual=2;
        } else if(undergradRatio>.7){
            actual=3;
        } else{
            actual=4;
        }
        return Math.abs(actual-answer);
    }

    private int rankGreekLifePercent(int answer, double GLpercent){
        int actual=0;
        if(GLpercent>.5){
            actual=1;
        } else if(GLpercent>.3){
            actual=2;
        } else if(GLpercent>.15){
            actual=3;
        } else{
            actual=4;
        }
        return Math.abs(actual-answer);
    }

    private int rankFinAid(int answer, double finAidMet){
        int actual=0;
        if(finAidMet>.85){
            actual=1;
        } else if(finAidMet>.7){
            actual=2;
        }  else{
            actual=1;
        }
        return Math.abs(actual-answer);
    }

    private int rankStudentFacRatio(int answer, double ratio){
        int actual=0;
        if(ratio>14){
            actual=4;
        } else if(ratio>10){
            actual=3;
        } else if(ratio>8){
            actual=2;
        } else{
            actual=1;
        }
        return Math.abs(actual-answer);
    }

    private String[] rankSchools(int[] points){
        String[] arr = new String[numSchools];
        for(int i=0;i<numSchools;i++){
            int minIndex = 0;
            for(int j=0;j<numSchools;j++){
                if(points[j]<points[minIndex]){
                    minIndex=j;
                }
            }
            points[minIndex] = 100; //remove it from consideration
            arr[i] = intToName(minIndex+1);
        }
        return arr;
    }

    // converts int to school name
    private String intToName(int num){
        switch(num){
            case 1:
                return "Cornell University";
            case 2:
                return "University of Maryland";
            case 3:
                return "University of North Georgia";
            case 4:
                return "University of Houston";
            case 5:
                return "Cleveland State University";
            case 6:
                return "Kenyon College";
            case 7:
                return "Elon University";
            case 8:
                return "Stony Brook University";
            case 9:
                return "William and Mary College";
            case 10:
                return "Binghamton University";
            case 11:
                return "UMass Boston";
            case 12:
                return "Wesleyan University";
        }
        return null;
    }

    private void printResults(String[] arr){
        System.out.println("Top Three Schools For You:\n\t"+arr[0]+"\n\t"+arr[1]+"\n\t"+arr[2]);
    }


    public static void main(String[] args){
        Driver prog = new Driver();
        prog.run();
        prog.takeInput();

    }
    
}
