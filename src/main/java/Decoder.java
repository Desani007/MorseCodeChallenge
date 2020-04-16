import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class Decoder {
    private static MorseCodeDictionary morseCodeDictionary;

    public static void main(String[] args) {
        System.out.println(decode("XOXOXXXOXOOOXOXXXOOOXOXXXOXOOOXOXXXOOOXOXXXOXXXOOOXOXXXOOOXXXOXOXXXOXXXOOOO" +
                "OOOXOXXXOXOXOOOXOXXXOOOXOXOXXXOOOXXXOXOOOXXXOXOXOOOXOXXXOXOOOXXXOXOXXXOXXXOOO"));
    }

    public static String decode(String encoded) {
        if (!encoded.matches("^[a-zA-Z0-9]*$")) {
            throw new IllegalArgumentException("Unrecognized Symbol");
        }
        // TODO: Figure out via regex what chars are which
        Character sound = 'X';
        Character silence = 'O';
        morseCodeDictionary = new MorseCodeDictionary(silence, sound);
        return breakdownMorse(encoded);
    }

    public static String breakdownMorse(String encoded){
        StringBuilder words = new StringBuilder();
        String [] splitWords = encoded.split(morseCodeDictionary.getWordSpace());
        for(int i = 0; i < splitWords.length; i++){
            StringBuilder chars = new StringBuilder();
            String [] splitCharacters = splitWords[i].split(morseCodeDictionary.getCharacterSpace());
            for(String character: splitCharacters){
                String morse = convertToMorse(character);
                String letterOrNum = morseCodeDictionary.code.get(morse);
                chars.append(letterOrNum.toUpperCase());
            }
            words.append(chars);
            if (!((i + 1) >= splitWords.length)) {
                words.append(" ");
            }
        }
        return words.toString();
    }

    public static String convertToMorse(String chars){
        Character inContext = null;
        Character afterContext = null;
        StringBuilder morse = new StringBuilder();
        StringBuilder dotDashSB = new StringBuilder();
        //inContext = chars.charAt(0);
        for (int i = 0; i < chars.length() - 1; i++) {
            inContext = chars.charAt(i);
            afterContext = chars.charAt(i + 1);
            dotDashSB.append(inContext);
            if (!(inContext.equals(afterContext))) {
                String dotDash = morseCodeDictionary.convertToDashOrDot(dotDashSB.toString());
                morse.append(dotDash);
                dotDashSB = new StringBuilder();
            }
        }
        dotDashSB.append(afterContext);
        morse.append(morseCodeDictionary.convertToDashOrDot(dotDashSB.toString()));
        return morse.toString();
    }

}

