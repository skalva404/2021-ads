package kalva.learnings.ads;

public class SaLCell {

    public Integer vertex;
    public Integer diceCount;

    public SaLCell() {
    }

    public SaLCell(Integer diceCount) {
        this.diceCount = diceCount;
    }

    public SaLCell(Integer vertex, Integer diceCount) {
        this.vertex = vertex;
        this.diceCount = diceCount;
    }
}
