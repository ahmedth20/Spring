package tn.esprit.thabti_ahmed_4twin5.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.thabti_ahmed_4twin5.entities.Subscription;
import tn.esprit.thabti_ahmed_4twin5.Services.SubscriptionServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subscription")
public class SubscriptionRestController {

    private final SubscriptionServiceImpl subscriptionService;

    @PostMapping("/add")
    public Subscription addSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.addSubscription(subscription);
    }

    @PutMapping("/update")
    public Subscription updateSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.updateSubscription(subscription);
    }

    @GetMapping("/get/{numSubscription}")
    public Subscription getSubscription(@PathVariable Long numSubscription) {
        return subscriptionService.retrieveSubscription(numSubscription);
    }

    @GetMapping("/all")
    public List<Subscription> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }

    @DeleteMapping("/delete/{numSubscription}")
    public void deleteSubscription(@PathVariable Long numSubscription) {
        subscriptionService.removeSubscription(numSubscription);
    }
}
