import java.util.ArrayList;
import java.util.List;

public class Degree {

    private List<Grade> year2 = null;
    private List<Grade> year3 = null;
    private Profile lvl5Profile;
    private Profile lvl6Profile;

	public Degree(List<Grade> year2, List<Grade> year3) {
	    this.year2 = year2;
	    this.year3 = year3;
        if ( (year2 == null || year3 == null) || (year2.size() != 4 || year3.size() != 4)){
            throw new IllegalArgumentException();
        } else {
            List<Grade> years2And3 = new ArrayList<Grade>();
            years2And3.addAll(year2);
            years2And3.addAll(year3);
            lvl6Profile = new Profile(year3);
            lvl5Profile = new Profile(years2And3);
        }
	}

    public Classification classify() {
	    int lvl5ProfileRank = lvl5Profile.classify().ordinal();
	    int lvl6ProfileRank = lvl6Profile.classify().ordinal();
        if (lvl5ProfileRank == lvl6ProfileRank) {
            return lvl5Profile.classify();
        } else if ((lvl6ProfileRank > lvl5ProfileRank)
                && (lvl6Profile.isClear())
                && (lvl6ProfileRank - lvl5ProfileRank == 1)) {
            return lvl6Profile.classify();
        } else if ((lvl5ProfileRank > lvl6ProfileRank)
                && (lvl5Profile.isClear())
                && (lvl5ProfileRank - lvl6ProfileRank == 1)) {
            return lvl5Profile.classify();
        } else {
            return Classification.Discretion;
        }
    }
}
