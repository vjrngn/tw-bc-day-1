import java.util.HashMap;

public class HTTPQueryParser {
    private HashMap<String, String> keyValPairs = new HashMap<>();

    public HTTPQueryParser(String queryString) {
        if (queryString.length() > 0) {
            this.parse(queryString);
        }
    }

    private void parse(String queryString) {
        String[] pairs = queryString.split("&");
        for (String pair : pairs) {
            String[] keyValPair = pair.split("=");

            this.keyValPairs.put(keyValPair[0], keyValPair[1]);
        }
    }

    public int count() {
        return this.keyValPairs.size();
    }

    public String valueFor(String key) {
        return this.keyValPairs.get(key);
    }
}
