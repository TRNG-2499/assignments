enum Direction {
    NORTH, SOUTH, EAST, WEST, UP, DOWN;

    /// turns user input like "north" or "NORTH" into Direction.NORTH
    /// @throws invalidDirectionException if the word isn't a direction
    static Direction fromString(String word) throws DirectionExceptions.invalidDirectionException {
        try {
            return Direction.valueOf(word.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new DirectionExceptions.invalidDirectionException(word);
        }
    }
}
