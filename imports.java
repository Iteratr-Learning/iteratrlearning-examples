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

List<Payment> paymentsByValue =
	Stream.of(900, 700, 500, 300, 100, 0).map(Payment::new).collect(toList());

