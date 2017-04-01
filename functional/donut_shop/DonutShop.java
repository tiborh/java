package donut_shop;

import edu.mit.utils.imlist.*;

public class DonutShop {
  private static ImList<Donut> d0 = ImList.empty();
  public static Pair<Donut, Payment> buyDonut(final CreditCard cCard) {
    return new Pair<>(new Donut(), new Payment(cCard, Donut.price));
  }

  public static Pair<ImList<Donut>, Payment> buyDonuts(final int quantity,
                                            final CreditCard cCard) {
    ImList<Donut> d1 = d0.cons(new Donut());
    return new Pair<>(d1,new Payment(cCard, Donut.price * quantity));
  }
}
