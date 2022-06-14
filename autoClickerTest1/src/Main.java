import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {

        System.out.println("\n\t\tAutoClicker'e hoşgeldin!");
        prepareClicker();
    }

    static void prepareClicker(){
        int clickAmount = 10;
        double delay = 200;    // default amount & delay
        clickTypes type = clickTypes.LEFT; // default click type
        try {
            System.out.println("\n\n1.Sol Tık\n2.Orta(Tekerlek)\n3.Sağ Tık");
            switch (scan.nextLine()){
                case "1":
                    type = clickTypes.LEFT;
                    break;
                case "2":
                    type = clickTypes.MIDDLE;
                    break;
                case "3":
                    type = clickTypes.RIGHT;
                    break;
                default:
                    System.out.println("Hatalı bir rakam tuşladınız.");
                    prepareClicker();
                    break;
            }

            System.out.println("\n\nKaç defa tıklansın : ");
            clickAmount = scan.nextInt();
            if(clickAmount>1000){
                System.out.println("\n["+clickAmount+"] Defa tıklamak istediğinizden emin misiniz?\n1. Evet\n2.Geri");
                switch (scan.nextLine()){
                    case "1":
                        break;
                    case "2":
                        prepareClicker();
                        break;
                    default:
                        System.out.println("Hatalı bir rakam tuşladınız.");
                        prepareClicker();
                        break;
                }
            }

            System.out.println("\n\nTıklamalar arası bekleme \n (milisaniye cinsinden 1s = 1000ms) : ");
            delay = scan.nextInt();
            if(delay>1000){

                System.out.println("\nTıklamalar arasında ["+(double)delay/1000+"] saniye beklemek istediğinizden emin misiniz?" +
                                   "\n(Bu işlem yaklaşık "+clickAmount+" x "+(double)(delay/1000)+" = "+(clickAmount*delay)/1000+" Saniye sürecektir.)" +
                                   "\n1.Evet\n2.Geri");
                scan.nextLine();//dummy
                switch (scan.nextLine()){
                    case "1":
                        break;
                    case "2":
                        prepareClicker();
                        break;
                    default:
                        System.out.println("Hatalı bir rakam tuşladınız.");
                        prepareClicker();
                        break;
                }
            }
        }catch (Exception e){
            System.out.println("\nLütfen tam sayı giriniz");
            prepareClicker();
        }

        System.out.println("Program 5 saniye içinde başlıyor, mouse'u dilediğiniz konuma taşıyın.\n" +
                "(Bu işlem yaklaşık "+clickAmount+" x "+(double)(delay/1000)+" = "+(clickAmount*delay)/1000+" Saniye sürecektir.)\n");
        for(int i = 1; i<6; i++){
            try{
                System.out.print(i+"  ");
                Thread.sleep(1000);
            }catch (InterruptedException ignored) {}
        }

        run(delay,clickAmount,type);

    }

    public static void run(double delay, int clickAmount, clickTypes type){
        Clicker clicker = new Clicker();
        clicker.setDelay((int)delay);
        clicker.clickMouse(type,clickAmount);
        prepareClicker();
    }
}
