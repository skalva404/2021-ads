package kalva.learnings.ads.companies.thoughtspot;

import java.util.Hashtable;
import java.util.List;

import static java.util.Arrays.asList;

public class CarParking {

    static int changes = 0;
    Hashtable<Character, Integer> givenMap = new Hashtable<>();

    public void minimumSwaps(List<Character> ideal, List<Character> given) {

        for (int i = 0; i < given.size(); i++) {
            givenMap.put(given.get(i), i);
        }

        int blankIndex = getBlankIndex(given);
        while (true) {

            if (!isCorrectlyParked(blankIndex, ideal, given)) {

                //blank is not correctly parked, get what car should be here at this index
                char ch = ideal.get(blankIndex);
                //find out where is it parked now
                final Integer idealIndex = givenMap.get(ch);
                swapCarsAtIndex(blankIndex, idealIndex, given);
                blankIndex = getBlankIndex(given);
            } else {

                //getFirstIncorrectlyParkedIndex
                int incorrectlyParked = incorrectlyParkedCar(ideal, given);
                if (incorrectlyParked == -1) {
                    break;
                } else {
                    swapCarsAtIndex(incorrectlyParked, blankIndex, given);
                    blankIndex = incorrectlyParked;
                }
            }
        }
    }

    public boolean isCorrectlyParked(int index, List<Character> ideal, List<Character> given) {
        if (index <= ideal.size() - 1 && index <= given.size() - 1) {
            return ideal.get(index) == given.get(index);
        }
        return false;
    }

    public int incorrectlyParkedCar(List<Character> ideal, List<Character> given) {
        for (int i = 0; i < ideal.size(); i++) {
            if (ideal.get(i) != given.get(i)) {
                return i;
            }
        }
        return -1;
    }

    public void swapCarsAtIndex(int x, int y, List<Character> given) {
        final Character temp = given.get(x);
        given.set(x, given.get(y));
        given.set(y, temp);
        changes++;
        givenMap.put(given.get(x), x);
        givenMap.put(given.get(y), y);
        System.out.println(given);
    }

    public int getBlankIndex(List<Character> given) {
        return given.indexOf('_');
    }

    public static void main(String[] args) {

        final List<Character> given = asList('D', 'F', 'E', 'A', 'G', 'C', 'B', '_');
        final List<Character> ideal = asList('_', 'A', 'B', 'C', 'G', 'F', 'D', 'E');

        System.out.println(given);
        System.out.println("||");
        System.out.println(ideal);
        System.out.println("==================");
        new CarParking().minimumSwaps(ideal, given);
        System.out.println("swaps required: " + changes);
    }
}
