package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
//bu annotation aynı levelde bilinmeyen verileri görmezden gelerek diğer verilerin bu class tipinde pojo classa çevrilmesine yardımcı oluyor.
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingResponseBodyPojo {

    private Integer bookingid;
    private BookingPojo booking;

    public BookingResponseBodyPojo() {
    }

    public BookingResponseBodyPojo(Integer bookingid, BookingPojo booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public BookingPojo getBooking() {
        return booking;
    }

    public void setBooking(BookingPojo booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "BookingResponseBodyPojo{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
