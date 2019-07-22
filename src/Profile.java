import java.util.List;

public class Profile {

	private List<Grade> grades = null;
    private int firstClassCount = 0;
    private int upperSecondClassCount = 0;
    private int lowerSecondClassCount = 0;
    private int thirdClassCount = 0;

	public Profile(List<Grade> grades) {
		this.grades = grades;
		if (grades == null || grades.isEmpty() || hasFailGrade(grades)) {
			throw new IllegalArgumentException();
		} else {
            countEachClass();
        }
	}

	private void countEachClass(){
        for (Grade grade : grades) {
            if (grade.classify() == Classification.First) {
                firstClassCount++;
            } else if (grade.classify() == Classification.UpperSecond) {
                upperSecondClassCount++;
            } else if (grade.classify() == Classification.LowerSecond) {
                lowerSecondClassCount++;
            } else if (grade.classify() == Classification.Third){
                thirdClassCount++;
            }
        }
    }

	private boolean hasFailGrade(List<Grade> grades) {
	    for (int i = 0; i < grades.size(); i++) {
	        if (grades.get(i).classify() == Classification.Fail){
	            return true;
            }
        }
        return false;
    }
	
	public Classification classify() {
        if (firstClassCount >= grades.size()/2){
            return Classification.First;
        } else if (upperSecondClassCount + firstClassCount >= grades.size()/2) {
            return Classification.UpperSecond;
        } else if (lowerSecondClassCount >= grades.size()/2) {
            return Classification.LowerSecond;
        } else {
	    return Classification.Third;
        }
	}

	public boolean isClear() {

	    if ((this.classify() == Classification.First) || (this.classify() == Classification.UpperSecond)){
            if (thirdClassCount <= grades.size()/4) {
                return true;
            } else {
                return false;
            }
        } else {
	        return true;
        }
    }
}
