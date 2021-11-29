public class Parking {

    int miejsca;
    int max;
    int samochody;
    Stanparkingu stanparkingu;
    Stansamochodu stansamochodu;

    Parking(int miejsca, int samochody){
        this.miejsca = miejsca;
        this.samochody = samochody;
        this.max = 20;
    }

    public void bramka(){
        try{

            Thread.sleep(400);//sleep for 1000 ms

        }
        catch(Exception ie){
        }
        if(miejsca > max){
            System.out.println("BRAK MIEJSC NA PARKINGU");
            stanparkingu = Stanparkingu.PELNY;
        }
        else {
            stanparkingu = Stanparkingu.PUSTY;
        }


    }

    public void parkuj(){
        miejsca++;
        try{

            Thread.sleep(400);//sleep for 1000 ms

        }
        catch(Exception ie){
        }
    }
    public void wyjazd(){
        miejsca++;
        samochody--;

    }

}
