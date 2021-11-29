
import java.util.Random;

public class Samochod extends Thread {

    Random random = new Random();
    int id;
    int czas_postoju;
    boolean loop = true;
    int x;
    Parking p;
    Stansamochodu stansamochodu;
    Stanparkingu stanparkingu;

    Samochod(int id, Parking p) {
        this.id = id;

        this.p = p;
        stansamochodu = Stansamochodu.START;
        stanparkingu = Stanparkingu.PUSTY;

    }

    public void run() {
        while (loop) {
            if (stansamochodu == Stansamochodu.WJAZD) {
                p.bramka();
                if (stanparkingu == Stanparkingu.PELNY) {
                    stansamochodu = Stansamochodu.CZEKAJ;
                }
                try {
                    sleep(10000);
                } catch (Exception ie) {
                }
                System.out.println("Samochod o nr " + id + " wjezdza na parking");

                x = random.nextInt(2);
                if (x == 1) {
                    p.parkuj();

                    stansamochodu = Stansamochodu.POSTOJ;
                } else if (x == 0) {
                    stansamochodu = Stansamochodu.CZEKAJ;
                }
            } else if (stansamochodu == Stansamochodu.POSTOJ) {
                try {
                    sleep(czas_postoju);
                } catch (Exception ie) {
                }
                x = random.nextInt(2);
                if (x == 1) {
                    stansamochodu = Stansamochodu.WYJAZD;
                } else if (x == 0) {
                    stansamochodu = Stansamochodu.POSTOJ;
                }

            } else if (stansamochodu == Stansamochodu.WYJAZD) {
                try {
                    sleep(random.nextInt(2000));
                } catch (Exception ie) {
                }
                p.wyjazd();
                System.out.println("Samochod o nr " + id + " wyjechal z parkingu");
                stansamochodu = Stansamochodu.KONIEC;

            } else if (stansamochodu == Stansamochodu.START) {
                System.out.println("Samochod o nr " + id + " czeka na wjazd");
                try {
                    sleep(random.nextInt(2000));
                } catch (Exception ie) {

                }
                stansamochodu = Stansamochodu.WJAZD;
            } else if (stansamochodu == Stansamochodu.CZEKAJ) {
                try {
                    sleep(random.nextInt(2000));
                } catch (Exception ie) {

                }
                System.out.println("Samochod " + id + " postanawia poczekac");
                stansamochodu = Stansamochodu.WJAZD;
//                if (p.miejsca < p.max) {
//                    stansamochodu = Stansamochodu.START;
//                } else {
//
//                }

                if (stansamochodu == Stansamochodu.KONIEC) {
                    // System.out.println("KONIEC");
                    loop = false;
                }
            }
        }

    }
}
