package WS;
import org.springframework.data.repository.PagingAndSortingRepository;
public interface FilterAndSortingProductRepository
extends  PagingAndSortingRepository<Product, Integer>
{
}
