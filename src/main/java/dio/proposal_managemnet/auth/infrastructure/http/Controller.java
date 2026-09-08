package dio.proposal_managemnet.auth.infrastructure.http;

import dio.proposal_managemnet.auth.infrastructure.persistence.entity.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@EnableMethodSecurity
public class Controller {

    @GetMapping
    public String hello(@AuthenticationPrincipal User user) {
        return "Hello World " + user.getId();
    }

    @GetMapping("/influencer")
    @PreAuthorize("hasRole('INFLUENCER')")
    public String influencerEndpoint() {
        return "Hello World Influencer";
    }
    @GetMapping("/brand")
    @PreAuthorize("hasRole('BRAND')")
        public String brandEndpoint() {
            return "Hello World Brand";
        }
}
