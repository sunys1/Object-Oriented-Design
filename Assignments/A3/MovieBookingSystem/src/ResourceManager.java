import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// ResourceManager is a generic class that manages resources of type T.
public class ResourceManager<T extends Resource> {
    protected Map<String, T> resources;

    public ResourceManager() {
        this.resources = new HashMap<>();
    }

    public T getResource(String resourceId) {
        return resources.get(resourceId);
    }

    public List<T> search(String keyword) {
        return resources.values().stream()
                .filter(r -> r.getName().contains(keyword)).
                collect(Collectors.toList());
    }

    public void addResource(T resource) {
        resources.put(resource.getId(), resource);
    }

    public boolean reserve(String resourceId, String userId) {
        T resource = resources.get(resourceId);
        if (resource == null) return false;

        synchronized (resource) {
            if (resource.getAvailableQuantity() > 0) {
                resource.setAvailableQuantity(resource.getAvailableQuantity() - 1);
                return true;
            } else { // If not available, store user id into the waiting list
                resource.getWaitingList().offer(userId);
                return false;
            }
        }
    }

    public void release(String resourceId, String userId) {
        T resource = resources.get(resourceId);
        if (resource == null) return;

        synchronized (resource){
            resource.setAvailableQuantity(resource.getAvailableQuantity() + 1);

            // Check waiting list
            String nextUser = resource.getWaitingList().peek();
            if (nextUser != null && resource.getAvailableQuantity() > 0) {
                if (reserve(resourceId,nextUser)) {
                    resource.getWaitingList().poll();
                }
            }
        }
    }
}
