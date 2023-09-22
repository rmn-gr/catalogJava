import java.io.IOException;
import java.util.*;

public class Catalog {

    private static void PrintFiltered(ArrayList<String> uC, Set<Laptop> laptops){
        for (Laptop lp : laptops){
            for (String option: uC) {
                if(lp.color.name() == option || lp.brand.name() == option){
                    System.out.println(lp);
                    break;
                }
            }
        }
    }



    public static void main(String[] args) throws IOException {
        Map<Integer, String[]> choiceMap = new HashMap<>();
        choiceMap.put(1,new String[]{"Apple", "Asus", "Hp","Lenovo"});
        choiceMap.put(2,new String[]{"Black","Gray","Green","White"});


        Set<Laptop> catalog = new HashSet<>();
        catalog.add(new Laptop(Brand.Apple, Color.Gray));
        catalog.add(new Laptop(Brand.Apple, Color.White));
        catalog.add(new Laptop(Brand.Apple, Color.Black));
        catalog.add(new Laptop(Brand.Hp, Color.Gray));
        catalog.add(new Laptop(Brand.Hp, Color.Green));
        catalog.add(new Laptop(Brand.Lenovo, Color.Green));
        catalog.add(new Laptop(Brand.Lenovo, Color.White));
        catalog.add(new Laptop(Brand.Lenovo, Color.Black));
        catalog.add(new Laptop(Brand.Asus, Color.Green));
        catalog.add(new Laptop(Brand.Asus, Color.White));
        catalog.add(new Laptop(Brand.Asus, Color.Black));
        catalog.add(new Laptop(Brand.Asus, Color.Green));


        String userAnswer = "";
        ArrayList<String> userChoices = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        while (!userAnswer.equals("No")){
            System.out.println("Which filter are we adding?");
            System.out.println("1 - Brand");
            System.out.println("2 - Color");
            int firstStep = in.nextInt();
            if (firstStep == 1 || firstStep == 2){
                System.out.println("Choose needed option:");
                for (int i = 0; i < choiceMap.get(firstStep).length; i++){
                    System.out.printf("%d - %s\n", i+1, choiceMap.get(firstStep)[i]);
                }
                int secondStep = in.nextInt();
                if (secondStep >= 0 && secondStep < choiceMap.get(firstStep).length)
                    userChoices.add(choiceMap.get(firstStep)[secondStep-1]);
                else System.out.println("Can't find needed option");

            }
            else {
                System.out.println("Can't find needed option");
            }
            System.out.println("Do you want to add another filter option?(Yes/No)");
            userAnswer = in.next();

        }
        in.close();
        if (userChoices.size() > 0) PrintFiltered(userChoices, catalog);
        else System.out.println("You didn't choose any option to filter!");
    }
}
