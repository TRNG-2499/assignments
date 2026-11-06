import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Password {

    public interface Rule extends Function<String, Boolean> {}

    public record Score(Map<Rule, Integer> results) {
        public int value() {
            return
                results
                    .values()
                    .stream()
                    .reduce(0, Integer::sum);
        }
        
        public boolean getResult(Rule rule) {
            return results.get(rule) != 0;
        }
    }

    public static record Scorer(Rule[] rules, int[] weights) {
        public Scorer(Rule... rules) {
            this(
                rules,
                IntStream
                    .range(0, rules.length)
                    .map(i -> 1)
                    .toArray()
            );
        }

        public Score score(String password) {
            String p = password == null ? new String() : password;

            return
                new Score(
                    IntStream
                        .range(0, rules.length)
                        .boxed()
                        .collect(
                            Collectors.toMap(
                                i -> rules[i],
                                i -> rules[i].apply(p) ? weights[i] : 0
                            )
                        )
                );
        }
    }
    
    public static final Set<Integer> scSet = 
        "!@#$%^&*"
            .chars()
            .boxed()
            .collect(Collectors.toSet());
    
    public static final Rule ml = (String p) -> p.length() >= 8; 
    public static final Rule md = (String p) -> p.chars().anyMatch(Character::isDigit);
    public static final Rule up = (String p) -> p.toLowerCase().compareTo(p) != 0;
    public static final Rule sc = (String p) -> p.chars().anyMatch(c -> scSet.contains(c));
    public static final Scorer defaultScorer = new Scorer(ml, md, up, sc);

    public static final String passString =
        "Length: %s " +
        "Digit: %s " +
        "Uppercase: %s " +
        "Special Character: %s " +
        "-- Strength: %s";
    
    public static int boolToInt(boolean b) {
        return b ? 1 : 0;
    }

    public static int boolsToInt(Boolean... b) {
        return
            Arrays
                .stream(b)
                .map(Password::boolToInt)
                .reduce(0, Integer::sum);
    }

    public static String intToStrength(int i) {
        return switch(i) {
            case 4 -> "Strong";
            case 3 -> "Medium";
            case 2 -> "Medium";
            default -> "Weak";
        };
    }

    public static String boolToPassFail(boolean b) {
        return switch(boolToInt(b)) {
            case 1 -> "Pass";
            default -> "Fail";
        };
    }

    public static String strength(String password) {
        Score score = defaultScorer.score(password);
        
        return String.format(
            passString,
            boolToPassFail(score.getResult(ml)),
            boolToPassFail(score.getResult(md)),
            boolToPassFail(score.getResult(up)),
            boolToPassFail(score.getResult(sc)),
            intToStrength(score.value())
        );
    }

    public static String strength(String password, String... blacklist) {
        boolean isWeak =
            Arrays
                .stream(blacklist)
                .anyMatch(pwd -> pwd
                            .toLowerCase()
                            .compareTo(password.toLowerCase()) == 0);

        if (isWeak) {
            return "Password on blacklist -- Strength: Weak";
        }

        return strength(password);
    }

    public static void main(String[] args) {
        String[] blacklist = {
            "password",
            "Password1",
            "P@ssw0rd",
            "1234",
            "pass"
        };

        System.out.println(strength("password"));
        System.out.println(strength("Password1"));
        System.out.println(strength("P@ssw0rd"));
        System.out.println(strength(""));
        System.out.println(strength(null));
        
        System.out.println(strength("password", blacklist));
        System.out.println(strength("Password1", blacklist));
        System.out.println(strength("P@ssw0rd", blacklist));
    }
}
