import java.util.HashMap;
import java.util.Map;

public class MorseCodeDictionary {

    Map<String, String> code = new HashMap<>();
    private Character silence;
    private Character sound;
    private String characterSpace;
    private String wordSpace;
    private String dash;

    public MorseCodeDictionary(Character silence, Character sound) {
        initMorseDictionaryMap();
        this.silence = silence;
        this.sound = sound;
        this.setTimeUnitVariables();
    }

    public String convertToDashOrDot(String input) {
        if (input.equals(dash)) {
            return "-";
        } else if(input.equals(sound.toString())) {
            return ".";
        } else {
            return "";
        }
    }

    //space between sounds in a character: 1 TU
    //space between characters: 3 TU
    //space between words: 7 TU
    public void setTimeUnitVariables() {
        this.characterSpace = "" + silence + silence + silence;
        this.wordSpace = characterSpace + characterSpace + silence;
        this.dash = "" + sound + sound + sound;
    }

    public Character getSilence() {
        return silence;
    }

    public Character getSound() {
        return sound;
    }

    public String getCharacterSpace() {
        return characterSpace;
    }


    public String getWordSpace() {
        return wordSpace;
    }

    public void initMorseDictionaryMap() {
        code.put(".-", "a");
        code.put("-...", "b");
        code.put("-.-.", "c");
        code.put("-..", "d");
        code.put(".", "e");
        code.put("..-.", "f");
        code.put("--.-", "g");
        code.put("....", "h");
        code.put("..", "i");
        code.put(".---", "j");
        code.put("-.-", "k");
        code.put(".-..", "l");
        code.put("--", "m");
        code.put("-.", "n");
        code.put("---", "o");
        code.put(".--.", "p");
        code.put("--.-", "q");
        code.put(".-.", "r");
        code.put("...", "s");
        code.put("-", "t");
        code.put("..-", "u");
        code.put("...-", "v");
        code.put(".--", "w");
        code.put("-..-", "x");
        code.put("-.--", "y");
        code.put("--..", "z");
        code.put("-----", "0");
        code.put(".----", "1");
        code.put("..---", "2");
        code.put("...--", "3");
        code.put("....-", "4");
        code.put(".....", "5");
        code.put("-....", "6");
        code.put("--...", "7");
        code.put("---..", "8");
        code.put("----.", "9");
    }


}
