public class ACUNIT {
    private Unit unit;
    private double currenttemp;
    private double heattemp;
    private double cooltemp;

    enum Unit {
        F, C, K
    }

    public ACUNIT(double currenttemp, Unit unit, double heattemp, double cooltemp){
        this.unit = unit;
        this.currenttemp = converter(currenttemp, unit, Unit.C);
        this.heattemp = converter(heattemp, unit, Unit.C);
        this.cooltemp = converter(cooltemp, unit, Unit.C);
    }

    public ACUNIT(double currenttemp, Unit unit){
        this.unit = unit;
        this.currenttemp = converter(currenttemp, unit, Unit.C);
        heattemp = this.currenttemp + 5;
        cooltemp = this.currenttemp - 5;
    }

    public ACUNIT(double currenttemp){
        unit = Unit.C;
        this.currenttemp = converter(currenttemp, unit, Unit.C);
    }

    public ACUNIT(){
        unit = Unit.C;
        this.currenttemp = 15;
    }

    public Unit getunit(){
        return unit;
    }

    public void setunit(Unit unit){
        this.unit = unit;
    }

    public double getHeattemp(){
        return converter(heattemp, Unit.C, unit);
    }

    public void setHeattemp(double heattemp){
        this.heattemp = converter(heattemp, unit, Unit.C);
    }

    public double getCooltemp(){
        return converter(cooltemp, Unit.C, unit);
    }

    public void setCooltemp(double cooltemp){
        this.cooltemp = converter(cooltemp, unit, Unit.C);
    }

    public double getCurrenttemp(){
        return converter(currenttemp, unit.C, unit);
    }

    public static double converter(double t, Unit currentu, Unit desiredu) {
        double tt;

        switch (currentu) {
            case F:
                tt = ((t-32.0)*(5.0/9.0));
                break;
            case K:
                tt = (t-273.15);
                break;
            default:
                tt = t;
        }
        switch(desiredu) {
            case F:
                return (((tt * (9.0 / 5.0)) + 32.0));
            case K:
                return (tt + 273.15);
            default:
                return tt;
        }
    }

    public void heater(){
        System.out.println("Heating...");
        currenttemp += 1;
        try {
            Thread.sleep(1000); // 1 second
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // best practice
        }
    }

    public void cooler(){
        System.out.println("Cooling...");
        currenttemp -= 1;
        try {
            Thread.sleep(1000); // 1 second
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // best practice
        }
    }
}
