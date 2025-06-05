package br.com.renanpollo.digitalwallet.authorization.infrastructure.external;

import br.com.renanpollo.digitalwallet.authorization.domain.ports.IAuthorizationGateway;
import br.com.renanpollo.digitalwallet.transaction.domain.entity.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

@Component
public class HttpAuthorizationGateway implements IAuthorizationGateway {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpAuthorizationGateway.class);
    private final RestClient restClient;

    public HttpAuthorizationGateway(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://util.devi.tools/api/v2/authorize")
                .build();
    }

    @Override
    public boolean isAuthorized(Transaction transaction) {
        try {
            var response = restClient.get().retrieve().toEntity(AuthorizationWrapper.class);

            return !response.getStatusCode().isError()
                    && response.getBody() != null
                    && response.getBody().data().authorization();
        } catch (HttpClientErrorException.Forbidden e) {
            LOGGER.warn("Authorization denied for transaction {}", transaction.id());
            return false;
        } catch (HttpClientErrorException e) {
            LOGGER.error("HTTP client error during authorization for transaction {}: {}", transaction.id(), e.getStatusCode());
            return false;
        } catch (Exception e) {
            LOGGER.error("Unexpected error during authorization for transaction {}: {}", transaction.id(), e.toString(), e);
            return false;
        }
    }

    private record AuthorizationWrapper(String status, AuthorizationData data) {
    }

    private record AuthorizationData(boolean authorization) {
    }
}
