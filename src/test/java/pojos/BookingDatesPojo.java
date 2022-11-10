package pojos;

public class BookingDatesPojo {
    //inner pojo


    // 1) tum keyler icin private variable'lar olusturuyoruz
    private String checkin;
    private String checkout;

    // 2) parametreli(tum parametrelerle) ve parametresiz constructorlar olusturuyoruz.

    public BookingDatesPojo() {
    }

    public BookingDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    //public getter() ve setter() methodlarını olusturuyoruz.


    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    //4) toString() methodunu olusturuyoruz

    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
