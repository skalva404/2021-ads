package kalva.learnings.ads.mergeinnntervals;

public class EmployeeInterval {
    Interval interval; // interval representing employee's working hours
    int employeeIndex; // index of the list containing working hours of this employee

    public EmployeeInterval(Interval interval, int employeeIndex) {
        this.interval = interval;
        this.employeeIndex = employeeIndex;
    }
}