import java.util.Scanner;

public class Userinterface {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the current temperature: ");
        double ctemp = input.nextDouble();
        System.out.print("Enter the Units (C, F or K): ");
        String units = input.next();
        ACUNIT.Unit u = null;
        switch (units) {
            case "C":
                u = ACUNIT.Unit.C;
                break;
            case "F":
                u = ACUNIT.Unit.F;
                break;
            case "K":
                u = ACUNIT.Unit.K;
                break;    
        }
        System.out.print("Enter the heating temperature: ");
        double heat = input.nextDouble();
        System.out.print("Enter the cooling temperature: ");
        double cool = input.nextDouble();
        ACUNIT AC = new ACUNIT(ctemp, u, heat, cool);

        while (true) {
            System.out.println("<----Menu---->");
            System.out.println("1 = Heat");
            System.out.println("2 = Cool");
            System.out.println("3 = Set Heat");
            System.out.println("4 = Set Cool");
            System.out.println("Current Temperature: " + AC.getCurrenttemp() + "°");
            System.out.println("Current Heat Temperature: " + AC.getHeattemp() + "°");
            System.out.println("Current Cool Temperature: " + AC.getCooltemp() + "°");
            System.out.print("Enter a choice: ");
            int x = input.nextInt();
            switch (x) {
                case 1:
                    while (AC.getHeattemp()>AC.getCurrenttemp()){
                        AC.heater();
                    }
                    break;
                case 2:
                    while (AC.getCooltemp()<AC.getCurrenttemp()){
                        AC.cooler();
                    }
                    break;
                case 3:
                    System.out.print("Enter a Heating Temperature: ");
                    AC.setHeattemp(input.nextDouble());
                    break;
                case 4:
                    System.out.print("Enter a Cooling Temperature: ");
                    AC.setCooltemp(input.nextDouble());
                    break;
            }
        }
        }
}
