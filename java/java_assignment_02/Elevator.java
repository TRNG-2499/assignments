import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class Elevator {

    public static Integer globalOver;
    public static Integer globalCurrWeight;
    public static Integer globalI;
    
    public static String catchOverload(int maxWeight, List<Integer> passWeights) {
        String overString = "Passenger %d caused an overload. %s";
        String safeString = "All passengers boarded safely. %s";
        String weightString = "Total weight at that point: %d lbs.";

        globalOver = 0;
        globalCurrWeight = 0;
        globalI = 0;
        while (globalOver != 1 && globalI < passWeights.size()) {
            globalCurrWeight += passWeights.get(globalI);
            globalOver = globalCurrWeight >= maxWeight ? 1 : 0;
            globalI++;
        }

        weightString = String.format(weightString, globalCurrWeight);

        return switch (globalOver) {
            case 1 -> String.format(overString, globalI, weightString);
            default -> String.format(safeString, weightString);
        };
    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> out = new ArrayList<>();
        
        int li = 0;
        int ri = 0;
        while (li < left.size() && ri < right.size()) {
            if (left.get(li) < right.get(ri)) {
                out.add(left.get(li++));
            } else {
                out.add(right.get(ri++));
            }
        }

        if (li < left.size()) {
            out.addAll(left.subList(li, left.size()));
        }
        if (ri < right.size()) {
            out.addAll(right.subList(ri, right.size()));
        }

        return out;
    }

    public static List<Integer> mergeSort(List<Integer> n) {
        if (n == null) {
            return null;
        } else if (n.size() == 1) {
            return n;
        }

        int m = n.size() / 2;

        List<Integer> left = n.subList(0, m);
        List<Integer> right = n.subList(m, n.size());

        return merge(mergeSort(left), mergeSort(right));
    }

    public static int maxSafePassengerCount(int maxWeight, List<Integer> passWeights) {
        catchOverload(maxWeight, mergeSort(passWeights));
        return globalI;
    }

    public static String plusHeavyLight(int maxWeight, List<Integer> passWeights) {
        String initRes = catchOverload(maxWeight, passWeights);
        String weightString = "%s Heaviest: %d, Lightest: %d";
        List<Integer> subL = passWeights.subList(0, globalI);
        int max = 0;
        int min = 0;
        for (int i = 0; i < subL.size(); i++) {
            int w = subL.get(i);
            if (w > subL.get(max)) {
                max = i;
            } else if (w < subL.get(min)) {
                min = i;
            }
        }

        return String.format(weightString, initRes, ++max, ++min);
    }

    public static int minTrips(int maxWeight, List<Integer> passWeights) {
        if (passWeights.size() <= 1) {
            return 1;
        }

        int currWeight = 0;
        int over = 0;
        int i = 0;
        while (over != 1 && i < passWeights.size()) {
            currWeight += passWeights.get(i);
            over = currWeight >= maxWeight ? 1 : 0;
            i++;
        }

        return minTrips(maxWeight, passWeights.subList(i, passWeights.size())) + 1;
    }

    public static void main(String[] args) {
        ArrayList<String> out = new ArrayList<>();

        out.add(catchOverload(1000, List.of(150, 200, 300, 250, 180)));
        out.add(catchOverload(1000, List.of(150, 200, 300)));
        out.add(catchOverload(500, List.of(200, 300)));
        out.add(catchOverload(100, List.of(150, 200)));
        out.add(catchOverload(100, List.of()));

        for (String o : out) {
            System.out.println(o);
        }

        System.out.println();

        List<Integer> testN = List.of(1,4,0,2,3,5,10,9,8,11);
        List<Integer> sortTN = mergeSort(testN);
        System.out.println(sortTN);

        System.out.println();

        System.out.println(maxSafePassengerCount(5, List.of(5,1,3,2)));
        System.out.println(maxSafePassengerCount(2, List.of(1,2)));
        System.out.println(plusHeavyLight(5, List.of(5,1,3,2)));
        System.out.println(plusHeavyLight(2, List.of(1,2)));
        System.out.println(minTrips(5, List.of(5,1,3,2)));
        System.out.println(minTrips(2, List.of(1,2)));
    }
}