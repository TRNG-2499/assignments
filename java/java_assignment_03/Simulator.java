import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Simulator {

    public record Stages(Map<String, Stage> nameToStage, Map<Integer, Stage> idxToStage, int maxCycles, Stage... stages) {
        
        public Stages(Stage... stages) {
            Map<String, Stage> nameToStage = new HashMap<>();
            Map<Integer, Stage> idxToStage = new HashMap<>();

            int maxCycles = 0;
            for (int i = 0; i < stages.length; i++) {
                Stage stage = stages[i];
                nameToStage.put(stage.name(), stage);
                for (int k = 0; k < stage.duration(); k++) {
                    idxToStage.put(maxCycles++, stage);
                }
            }

            this(nameToStage, idxToStage, maxCycles, stages);
        }

        public Stages(String[] names, int[] durations) {
            Stage[] stages =
                IntStream
                    .range(0, names.length)
                    .boxed()
                    .map(idx -> new Stage(names[idx], idx, durations[idx]))
                    .toArray(Stage[]::new);
            
            this(stages);
        }

        public Stages(String... names) {
            int[] durations = new int[names.length];
            Arrays.fill(durations, 0, durations.length, 1);

            this(names, durations);
        }

        public Stage get(int index) {
            return idxToStage.get(index % maxCycles);
        }

        public boolean contains(String name) {
            return nameToStage.containsKey(name);
        }

        public Integer index(String name) {
            Stage stage = nameToStage.get(name);

            return stage != null ? stage.index() : null;
        }

        public String cycle(String start, int cycles) {
            Integer idx = index(start);

            return switch(idx) {
                case null -> null;
                default -> get(idx).cycle(idx, cycles, maxCycles, this::get).name();
            };
        }

        public String next(String start) {
            return cycle(start, 1);
        }

        public String cycleLinear(String start, int cycles) {
            Integer idx = index(start);

            if (idx == null || cycles == 0) {
                return switch(idx) {
                    case null -> null;
                    default -> get(idx + 1).name();
                };
            }

            return cycleLinear(next(start), cycles - 1);
        }

        public String[] cycleLogged(String start, int cycles) {
            String[] out = new String[Math.abs(cycles)];

            for (int i = 0; i < cycles; i++) {
                start = next(start);
                out[i] = start;
            }

            return out;
        }
    }

    public static final Stages stages = new Stages("Green", "Yellow", "Red");

    public static String tick(String stage, int ticks) {
        String res;
        String invString = "Invalid input: %s";
        String invColString = String.format(
            "'%s' is not a recognized light color.",
            stage
        );
        String negString = "tick count cannot be negative.";

        if (stages.contains(stage)) {
            if (ticks >= 0) {
                res = stages.cycle(stage, ticks);
            } else {
                res = String.format(invString, negString);
            }
        } else {
            res = String.format(invString, invColString);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] ticks = {1, 3, 5, 0, 2, -3};
        String[] starts = {
            "Green",
            "Green",
            "Red",
            "Green",
            "Purple",
            "Green"
        };

        for (int i = 0; i < ticks.length; i++) {
            System.out.println(tick(starts[i], ticks[i]));
            System.out.println(
                Arrays.toString(
                    stages.cycleLogged(starts[i], ticks[i])
                )
            );
        }

        System.out.println();

        Stage[] g2r1_stages = new Stage[]{
            new Stage("Green", 0, 2),
            new Stage("Red", 2, 1)
        };

        Stages durStages = new Stages(g2r1_stages);

        System.out.println(
            Arrays.toString(
                durStages.cycleLogged("Green", 4)
            )
        );
    }
}
