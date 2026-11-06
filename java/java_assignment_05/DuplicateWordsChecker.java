


class DuplicateWordsChecker {
    public void checkDuplicateWords(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println("Input cannot be empty.");
            return;
        }

        String[] words = input.split("\\s+");
        java.util.Map<String, Integer> wordCountMap = new java.util.LinkedHashMap<>();
        for (String word : words) {
            word = word.toLowerCase(); 
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        wordCountMap.forEach((word, count) -> {
            System.out.print(word + " - " + count);
        });
    }

    public static void main(String[] args) {
        DuplicateWordsChecker checker = new DuplicateWordsChecker();
        String input1 = "The time I went to the store I bought a watermelon";
        String input2 = "Every word here is unique";

        checker.checkDuplicateWords(input1);
        System.out.println();
        checker.checkDuplicateWords(input2);

        
    }
}