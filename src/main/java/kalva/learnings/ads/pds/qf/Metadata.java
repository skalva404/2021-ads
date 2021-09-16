package kalva.learnings.ads.pds.qf;

public interface Metadata {
    public Boolean getOccupied();

    public Boolean getShifted();

    public Boolean getContinuation();

    public Metadata setOccupied();

    public void setContinuation();

    public void setShifted();

    public void clearOccupied();

    public void clearContinuation();

    public void clearShifted();

    public Boolean isClear();
}
