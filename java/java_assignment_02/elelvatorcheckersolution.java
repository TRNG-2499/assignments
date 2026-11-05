/*





 */
public static String checkElevator(int wLimit, int[] pLimit) {
    int total = 0;
    int where = 0;
    int overloaded = 0;



    for (int weight : pLimit) {
        where++;
        total += weight;
        if (total >= wLimit) {
            overloaded+= 1;
            break;
        }
    }
    if (overloaded > 0) {
        return "overloaded at " + where + "holding " + wLimit;
    }
    else {
        return "all boarded, weight = " + total;
    }
}

void main() {}