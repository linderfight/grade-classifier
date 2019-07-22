public class Grade {
	
	private final int points;

	public Grade(int p) throws IllegalArgumentException {
		if(p<1 || p>20) {
			throw new IllegalArgumentException();
		} else {
			points = p;
		}
	}


	public Classification classify() {

		if (points > 0 && points < 5) {
			return Classification.First;
		} else if (points > 4 && points < 9) {
			return Classification.UpperSecond;
		} else if (points > 8 && points < 13) {
			return Classification.LowerSecond;
		} else if (points > 12 && points < 17) {
			return Classification.Third;
		} else
			return Classification.Fail;
	}
	
	public static Grade fromPercentage(int g) throws IllegalArgumentException {

		int newGrade = 0;

		int[][] rangesArr = {
				{78, 101},
				{75, 79},
				{72, 76},
				{69, 73},
				{66, 70},
				{64, 67},
				{61, 65},
				{59, 62},
				{56, 60},
				{54, 57},
				{51, 55},
				{49, 52},
				{46, 50},
				{44, 47},
				{41, 45},
				{39, 42},
				{34, 40},
				{29, 35},
				{-1, 30},
		};

		for (int i = 0; i < rangesArr.length; i++){
			if (g > rangesArr[i][0] && g < rangesArr[i][1]){
				newGrade = i + 1;
			} else if (g == rangesArr[18][0]){
				newGrade = 20;
			} else {
				throw new IllegalArgumentException();
			}
		}

		return new Grade(newGrade);
	}

	public int getPoints() {
		return points;
	}
}
