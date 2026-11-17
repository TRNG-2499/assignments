/// exceptions for invalid directions and exits
/// usage: throw new DirectionExceptions.noExitException(dir);
class DirectionExceptions {

    static class directionException extends Exception {
        directionException(String msg) {
            super(msg);
        }
    }

    static class directionTakenException extends directionException {
        directionTakenException(Direction dir) {
            super("Direction '" + dir.name() + "' already leads to another Room.class instance");
        }
    }

    static class nullDirectionException extends directionException {
        nullDirectionException() {
            super("Specified direction cannot be null");
        }
    }

    static class invalidDirectionException extends directionException {
        invalidDirectionException(Direction dir) {
            super("Specified direction '" + dir.name() + "' is not a valid Direction.enum value");
        }

        invalidDirectionException(String word) {
            super("'" + word + "' is not a direction. Try north, south, east, west, up or down.");
        }
    }

    static class noExitException extends directionException {
        noExitException(Direction dir) {
            super("There is no exit to the " + dir.name().toLowerCase() + " from here.");
        }
    }
}
