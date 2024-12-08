package tn.esprit.thabti_ahmed_4twin5.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.thabti_ahmed_4twin5.entities.Subscription;
import tn.esprit.thabti_ahmed_4twin5.Services.SubscriptionServiceImpl;
import tn.esprit.thabti_ahmed_4twin5.entities.TypeSubscription;

import java.util.List;
import java.util.Set;

@Tag(name = "Gestion Subscription")
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

    @Operation(description = "get Subscriptionby type de la base de données")
    @GetMapping("/byType")
    public Set<Subscription> getSubscriptionsByType(@RequestParam TypeSubscription type) {
        return subscriptionService.getSubscriptionByType(type);
    }
}
