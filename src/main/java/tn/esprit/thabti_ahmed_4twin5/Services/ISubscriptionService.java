package tn.esprit.thabti_ahmed_4twin5.Services;

import tn.esprit.thabti_ahmed_4twin5.entities.Subscription;
import java.util.List;

public interface ISubscriptionService {
    Subscription addSubscription(Subscription subscription);
    Subscription updateSubscription(Subscription subscription);
    void removeSubscription(Long numSubscription);
    Subscription retrieveSubscription(Long numSubscription);
    List<Subscription> getAllSubscriptions();
}
