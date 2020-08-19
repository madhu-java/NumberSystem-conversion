package converter;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        // System.out.print("10 = ");
        Scanner scanner = new Scanner(System.in);
        //toBinary(scanner);
    //String input=scanner.nextLine();
        int sourceRadix=0;
        int destRadix=0;
        String sourceDecimalNumber="";

        //while(true) {
           // System.out.println("enter base radix");
            if (scanner.hasNextInt()) {
                sourceRadix = scanner.nextInt();
                if (sourceRadix <= 0 || sourceRadix > 36) {
                    System.out.println("error");
                    //continue;
                    return;
                }
            } else {
                System.out.println("error");
                //continue;
                return;
            }
            //System.out.println("enter number");
             sourceDecimalNumber = scanner.next();
            if(!sourceDecimalNumber.matches("[0-9A-Za-z]+(\\.[0-9A-Za-z]+)?")){
                System.out.println("error");
                return;//continue;
            }
            //System.out.println("enter detination radix");
            if (scanner.hasNextInt()) {
                destRadix = scanner.nextInt();
                if (destRadix <= 0 || destRadix > 36) {
                    System.out.println("error");
                    // continue;
                    return;
                }
//                }else {
//                break;
//                }
            } else {
                System.out.println("error");
                //continue;
                return;
            }
           // break;
       // }

        String sourceNumber=sourceDecimalNumber;
    if(sourceDecimalNumber.contains(".")) {
        sourceNumber = sourceDecimalNumber.split("\\.")[0];
        String factoionalNumber = sourceDecimalNumber.split("\\.")[1];

        int fLength = factoionalNumber.length();
        double newFactionalNumber = 0;
        int n = sourceRadix;
        for (char eachc : factoionalNumber.toCharArray()) {
            int numc = Character.getNumericValue(eachc);

            newFactionalNumber += (double) numc / n;

            n *= sourceRadix;

        }


        System.out.println("newfaction " + newFactionalNumber);
        StringBuilder finalFractional = new StringBuilder();
        for (int i = 0; i < 5; i++) {

            String firstChar = String.valueOf(newFactionalNumber * destRadix).split("\\.")[0];
            System.out.println("firstchar " + firstChar);
            int firstDigit = Integer.parseInt(firstChar);
            System.out.println("first digit " + firstDigit);
            newFactionalNumber = (newFactionalNumber * destRadix) - firstDigit;
            System.out.println("new factio " + newFactionalNumber);

            if (firstDigit > 9) {
                finalFractional.append(Character.forDigit(firstDigit, destRadix));
                System.out.println("final fact to char" + finalFractional);
            } else {
                finalFractional.append(firstDigit);
                System.out.println("final fact to digit " + finalFractional);
            }
        }
        //System.out.println("final fractional "+finalFractional);
        integerPartConversion(sourceRadix, destRadix, sourceNumber);
        System.out.print("." + finalFractional);
    }else{
        integerPartConversion(sourceRadix, destRadix, sourceNumber);
    }

       // System.out.println(decimalNumber%8);
        //convertToRadix();

    }

    private static void toBinary(Scanner scanner) {
        int decimalNumber = scanner.nextInt();
        int n=10;
        String r="";
        while(n>=1){

            r=n%2+r;
            n=n/2;
        }

        System.out.print("0b"+r);
    }
    private static void convertToRadix() {
        String r="";
        int radix = 9; //get from user
        int n=10; //userinput
        switch(radix){
            case 2:
                //String r="";
                if(n==0){
                    System.out.print("0b"+n);
                break;
                }
                while(n>=1){

                    r=n%2+r;
                    n=n/2;
                }
                System.out.print("0b"+r);
                break;
            case 8:
              //  String r="";
              if(n==0){
                    System.out.print("0"+n);
                break;
                }
                while(n>=1){

                    r=n%8+r;
                    n=n/8;
                }
                System.out.print("0"+r);
                break;
            case 16:
               // String r="";
               if(n==0){
                    System.out.print("0x"+n);
                break;
                }
                int i=0;
                while(n>=1){
            //         i=n%16;
                    switch(i){
                    case 10:
                        r="a"+r;
                        break;
                    case 11:
                        r="b"+r;
                        break;
                    case 12:
                        r="c"+r;
                        break;
                    case 13:
                        r="d"+r;
                        break;
                    case 14:
                        r="e"+r;
                        break;
                    case 15:
                        r="f"+r;
                        break;
                    default:
                         r=i+r;
                         break;
                    }
                    n=n/16;
                }
                System.out.print("0x"+r);
                break;
        }
    }

    private static void integerPartConversion(int sourceRadix, int destRadix, String sourceNumber) {
        int newSourceNumber=0;
        //if(sourceRadix!=10){
        if(sourceRadix==1){
//            while(sourceNumber>=1){
//            newSourceNumber=newSourceNumber+sourceNumber%10;
//            sourceNumber/= 10;
//            }
            newSourceNumber= sourceNumber.length();
            //System.out.println("newnumber: "+newSourceNumber);
        }else {
//            String s = Integer.toString(sourceNumber, sourceRadix);
//            System.out.println("s :"+s);
            newSourceNumber = Integer.parseInt(sourceNumber,sourceRadix);
           // System.out.println("newnumber: "+newSourceNumber);

        }
//    }else
//    {
//        newSourceNumber=Integer.parseInt(sourceNumber);
//    }
        int destNumber=0;
        if(destRadix==1){
            for(int i=0;i<newSourceNumber;i++){
                System.out.print(1);
            }

        }else {
            System.out.print(Integer.toString(newSourceNumber, destRadix));
        }

    }


}
