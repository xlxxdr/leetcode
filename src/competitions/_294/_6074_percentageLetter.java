package competitions._294;

import tools.Asserts;

public class _6074_percentageLetter extends Asserts {

    public static void main(String[] args) {
        _6074_percentageLetter app = new _6074_percentageLetter();
//        "vmvvvvvzrvvpvdvvvvyfvdvvvvpkvvbvvkvvfkvvvkvbvvnvvomvzvvvdvvvkvvvvvvvvvlvcvilaqvvhoevvlmvhvkvtgwfvvzy"
//        "v"
        equals(59,app.percentageLetter("vmvvvvvzrvvpvdvvvvyfvdvvvvpkvvbvvkvvfkvvvkvbvvnvvomvzvvvdvvvkvvvvvvvvvlvcvilaqvvhoevvlmvhvkvtgwfvvzy",'v'));
//        "sgawtb"
//        "s"

        equals(16,app.percentageLetter("sgawtb",'s'));
        equals(33,app.percentageLetter("foobar",'o'));
        equals(0,app.percentageLetter("jjjj",'k'));

    }

    public int percentageLetter(String s, char letter) {
        if (s.isEmpty()){
            return 0;
        }
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == letter){
                count++;
            }
        }
        double num = (count / (s.length() * 1.0)) * 100;
        return (int)num;
    }
}
