/**
 *
 */
enum RunningMod {
    WRITE("write"),
    READ("read")
    , EXIT("exit");

    private final String _read;

    RunningMod(String read) {
        _read = read;
    }
    public static RunningMod getMode(String value){
        if (value.equalsIgnoreCase(WRITE.getRead())) return WRITE;
        else if (value.equalsIgnoreCase(READ.getRead())) return READ;
        else return EXIT;
    }

    public String getRead(){
        return _read;
    }
}

