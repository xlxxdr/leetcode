package competitions._295;

import tools.Asserts;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class _6079_discountPrices extends Asserts {

    public static void main(String[] args) {
        _6079_discountPrices app = new _6079_discountPrices();

        //"ka3caz4837h6ada4 r1 $602"
        //9
        equals("ka3caz4837h6ada4 r1 $547.82",
                app.discountPrices("ka3caz4837h6ada4 r1 $602", 9));


        equals("1 2 $0.00 4 $0.00 $0.00 7 8$ $0.00 $10$",
                app.discountPrices("1 2 $3 4 $5 $6 7 8$ $9 $10$", 100));

        equals("there are $0.50 $1.00 and 5$ candies in the shop",
                app.discountPrices("there are $1 $2 and 5$ candies in the shop", 50));


    }

    public String discountPrices(String sentence, int discount) {
        if (discount == 0) {
            return sentence;
        }
        String[] s = sentence.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < s.length; j++) {
            String s1 = s[j];
            if (s1.startsWith("$")  ) {
                char[] chars = s1.toCharArray();
                int sum = 0;
                boolean isNum = true;
                for (int i = 1; i < chars.length; i++) {
                    if (chars[i] >= '0' && chars[i] <= '9') {
                        int num = (int) ((chars[i] - 48) * Math.pow (10,chars.length - i - 1));
                        sum += num;
                    } else {
                        isNum = false;
                        break;
                    }
                }
                if (isNum){
                    double result = sum * ((100.0 - discount) / 100.0);
                    s1 = "$" + String.format("%.2f",result);
                }

            }
            sb.append(s1);
            if (j !=s.length - 1){
                sb.append(" ");
            }

        }
        return sb.toString().trim();
    }
}
