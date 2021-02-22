package EASi.Test.API.demo;

import com.google.common.collect.ImmutableMap;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class GraphQLDataFetchers {

    private static List<Map<String, String>> accessibilityRequests = Arrays.asList(
            ImmutableMap.of("id", "request-1",
                    "name", "Request for New System 1.0",
                    "systemId", "system-1"),
            ImmutableMap.of("id", "request-2",
                    "name", "Request for New System 1.1",
                    "systemId", "system-1"),
            ImmutableMap.of("id", "request-3",
                    "name", "Request for Old System 1.0",
                    "systemId", "system-2")
    );

    private static List<Map<String, String>> systems = Arrays.asList(
            ImmutableMap.of("id", "system-1",
                    "name", "New System",
                    "lcid", "123456a"),
            ImmutableMap.of("id", "system-2",
                    "name", "Old System",
                    "lcid", "678922b"),
            ImmutableMap.of("id", "system-3",
                    "name", "System Not Appearing In This Demo",
                    "lcid", "098765c")
    );

    public DataFetcher getAccessibilityRequestByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String accessibilityRequestId = dataFetchingEnvironment.getArgument("id");
            return accessibilityRequests
                    .stream()
                    .filter(accessibilityRequest -> accessibilityRequest.get("id").equals(accessibilityRequestId))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getSystemDataFetcher() {
        return dataFetchingEnvironment -> {
            Map<String,String> accessibilityRequest = dataFetchingEnvironment.getSource();
            String systemId = accessibilityRequest.get("systemId");
            return systems
                    .stream()
                    .filter(system -> system.get("id").equals(systemId))
                    .findFirst()
                    .orElse(null);
        };
    }
}