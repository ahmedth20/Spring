package tn.esprit.thabti_ahmed_4twin5.Services;

import tn.esprit.thabti_ahmed_4twin5.entities.Subscription;
import tn.esprit.thabti_ahmed_4twin5.entities.TypeSubscription;

import java.util.List;
import java.util.Set;

public interface ISubscriptionService {
    Subscription addSubscription(Subscription subscription);
    Subscription updateSubscription(Subscription subscription);
    void removeSubscription(Long numSubscription);
    Subscription retrieveSubscription(Long numSubscription);
    List<Subscription> getAllSubscriptions();
    Set<Subscription> getSubscriptionByType(TypeSubscription type);

}
