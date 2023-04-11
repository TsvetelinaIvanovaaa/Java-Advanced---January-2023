package SetsAndMapsAdvanced.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String invitedGuests = scanner.nextLine();
        Set<String> VIP = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        while (!invitedGuests.equals("PARTY")){

            char firstSymbol = invitedGuests.charAt(0);
            if(Character.isDigit(firstSymbol) && invitedGuests.length() == 8){
                VIP.add(invitedGuests);
            }else if(invitedGuests.length() == 8){
                regular.add(invitedGuests);
            }
            invitedGuests = scanner.nextLine();
        }

        String comingGuests = scanner.nextLine();
        while (!comingGuests.equals("END")){
            if(VIP.contains(comingGuests)){
                VIP.remove(comingGuests);
            }
            if(regular.contains(comingGuests)){
                regular.remove(comingGuests);
            }

            comingGuests = scanner.nextLine();
        }
        int allGuests = VIP.size() + regular.size();
        System.out.println(allGuests);
        for (String guests : VIP) {
            System.out.println(guests);
        }
        for (String guests : regular) {
            System.out.println(guests);
        }
    }
}
