package tn.esprit.thabti_ahmed_4twin5.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.thabti_ahmed_4twin5.entities.Subscription;
import tn.esprit.thabti_ahmed_4twin5.entities.TypeSubscription;

import java.util.List;

public interface ISubscriptionRepository extends CrudRepository<Subscription, Long> {
    List<Subscription> findByTypeSubOrderByStartDate(TypeSubscription type);

}
