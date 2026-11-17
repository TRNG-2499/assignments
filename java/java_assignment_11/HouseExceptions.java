/// exceptions for invalid house layouts
/// usage: throw new HouseExceptions.houseOccupiedException();
class HouseExceptions {

    static class houseException extends Exception {
        houseException(String msg) {
            super(msg);
        }
    }

    static class houseOccupiedException extends houseException {
        houseOccupiedException() {
            super("The starting room's default exit is already connected to a room");
        }
    }
}
