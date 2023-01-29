package data;

public enum departments {
    JAVADEVELOP,
    ANALYST,
    FULLSTACKDEVELOP,
    PYTHONDEVELOP,
    DESIGNER;

    /**
     * Generates a beautiful list of enum string values.
     *
     * @return String with all enum values separated by comma.
     */
    public static String nameList() {
        String nameList = "";
        for (departments organized : values()) {
            nameList += organized.name() + ", ";
        }
        return nameList.substring(0, nameList.length() - 2);
    }


}
