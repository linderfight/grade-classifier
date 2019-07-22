import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] secondYearGrades = getGrades(2);
        int[] thirdYearGrades = getGrades(3);

        getOutcome(secondYearGrades, thirdYearGrades);

    }

    private static int[] getGrades(int year){
        Scanner sc = new Scanner(System.in);
        String[] strGrades;
        String prompt = "";
        int[] intGrades = new int[4];

        if (year == 2){
            prompt = "Please list your 2nd year grades separated by coma.";
        } else if (year == 3){
            prompt = "Please list your 3rd year grades separated by coma.";
        }

        System.out.println(prompt);
        strGrades = sc.nextLine().split(",");
        for (int i = 0; i < strGrades.length; i++){
            strGrades[i] = strGrades[i].replaceAll("\\s+","");
        }

        while (!(gradesValid(strGrades))){
            System.out.println("Error! No more than 4 grades allowed. A grade must be an integer between 1 and 20:");
            System.out.println(prompt);
            strGrades = sc.nextLine().split(",");
            for (int i = 0; i < strGrades.length; i++){
                strGrades[i] = strGrades[i].replaceAll("\\s+","");
            }
        }


        return intGrades;
    }

    private static boolean gradesValid(String[] grades){

        int[] intGrade = new int[4];
        boolean isValid = true;

        try{
            for (int i = 0; i < intGrade.length; i++){
                intGrade[i] = Integer.parseInt(grades[i]);
            }
        } catch (Exception x){
            isValid = false;
        }

        for (int i = 0; i < intGrade.length; i++){
            if (!(intGrade[i] > 0) && !(intGrade[i] < 21)){
               isValid = false;
            }

        }

        return isValid;
    }

    private static void getOutcome(int[] secondYearIntGrades, int[] thirdYearIntGrades){
        List<Grade> year2_Grades = new ArrayList<Grade>();
        List<Grade> year3_Grades = new ArrayList<Grade>();

        for(int i = 0; i < 4; i++){
            year2_Grades.add(new Grade(secondYearIntGrades[i]));
            year3_Grades.add(new Grade(thirdYearIntGrades[i]));
        }

        Degree degree = new Degree(year2_Grades, year3_Grades);
        System.out.println("Outcome: " + degree.classify());
    }

}
