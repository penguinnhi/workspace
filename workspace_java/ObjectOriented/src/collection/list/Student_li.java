package collection.list;

public class Student_li {
    private String studentName;
    private int korScore;
    private int engScore;
    private int mathScore;
    private int totalScore;

    public Student_li(String studentName, int korScore, int engScore, int mathScore) {
        this.studentName = studentName;
        this.korScore = korScore;
        this.engScore = engScore;
        this.mathScore = mathScore;
        this.totalScore=korScore+engScore+mathScore;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getKorScore() {
        return korScore;
    }

    public void setKorScore(int korScore) {
        this.korScore = korScore;
    }

    public int getEngScore() {
        return engScore;
    }

    public void setEngScore(int engScore) {
        this.engScore = engScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "Student_li{" +
                "studentName='" + studentName + '\'' +
                ", korScore=" + korScore +
                ", engScore=" + engScore +
                ", mathScore=" + mathScore +
                ", totalScore=" + totalScore +
                '}';
    }
}


