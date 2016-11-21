import java.util.stream.*;
import static java.util.Map.*;
import static java.util.stream.Collectors.*;

class Payment
{
    private final int value;

    public Payment(final int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return "Payment{" +
            "value=" + value +
            '}';
    }
}

class Setting
{
    static Optional<Setting> lookupSettingByName(final String name)
    {
        return Optional.ofNullable(System.getProperty(name)).map(Setting::new);
    }

    private final String value;

    Setting(final String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    public String toString()
    {
        return "[value="+value+"]";
    }
}

class Booking
{
    static Optional<Booking> lookupBooking(final String reference)
    {
        return reference.startsWith("LCY")
             ? Optional.of(new Booking(reference))
             : Optional.empty();
    }

    private final String reference;

    Booking(final String reference)
    {
        this.reference = reference;
    }

    public String getReference()
    {
        return reference;
    }

    public String toString()
    {
        return "Booking{"+reference+"}";
    }
}

class Ui
{
    static void displayCheckIn(final Booking booking)
    {
        System.out.println("Checking in ... " + booking);
    }

    static void displayMissingBookingPage()
    {
        System.out.println("Missing Booking");
    }
}

class Client
{
    private final String address;

    Client(String address)
    {
        this.address = address;
    }

    public String toString()
    {
        return "Client{address="+address+"}";
    }
}

Optional<Client> findClient(final String clientId)
{
    return "aClient".equals(clientId)
         ? Optional.of(new Client("London"))
         : Optional.empty();
}

Optional<Client> lookupCompanyDetails(final String clientId)
{
    return "anotherCompany".equals(clientId)
         ? Optional.of(new Client("Cambridge"))
         : Optional.empty();
}

List<String> SETTING_NAMES = List.of("userHome", "user.home");

List<Payment> paymentsByValue =
	Stream.of(900, 700, 500, 300, 100, 0).map(Payment::new).collect(toList());

String bookingReference = "LCY to ANR"

